package com.convergence.web.websocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class CustomService implements CustomCallBack {
    private static final Logger logger = LoggerFactory.getLogger(CustomService.class);
    public static final Map<String, CustomCallBack> watchMap =
            new ConcurrentHashMap<String, CustomCallBack>(); // <requestId, callBack>

    private ChannelHandlerContext ctx;
    private String name;

    public CustomService(ChannelHandlerContext ctx, String name) {
        this.ctx = ctx;
        this.name = name;
    }

    public static boolean register(String requestId, CustomCallBack callBack) {
        if (StringUtils.isNoneBlank(requestId) || watchMap.containsKey(requestId)) {
            return false;
        }
        watchMap.put(requestId, callBack);
        return true;
    }

    public static boolean logout(String requestId) {
        if (StringUtils.isNoneBlank(requestId) || !watchMap.containsKey(requestId)) {
            return false;
        }
        watchMap.remove(requestId);
        return true;
    }

    @Override
    public void send(Request request) throws Exception {
        if (this.ctx == null || this.ctx.isRemoved()) {
            throw new Exception(" 尚未握手成功，无法向客户端发送 WebSocket 消息 ");
        }
        this.ctx.channel().write(new TextWebSocketFrame(request.toJson()));
        this.ctx.flush();
    }


    /**
     * 通知所有机器有机器下线
     * 
     * @param requestId
     */
    public static void notifyDownline(String requestId) {
        CustomService.watchMap.forEach((reqId, callBack) -> { // 通知有人下线
            Request serviceRequest = new Request();
            serviceRequest.setServiceId(CODE.downline.code);
            serviceRequest.setRequestId(requestId);
            try {
                callBack.send(serviceRequest);
            } catch (Exception e) {
                logger.warn(" 回调发送消息给客户端异常 ", e);
            }
        });
    }

    public String getName() {
        return name;
    }
}
