package com.convergence.web.websocket;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;

/**
 * 
 * @author ander 自定義 服务端处理handler
 * @param <T>
 */
public class CustomWebSocketServerHandler<T> extends SimpleChannelInboundHandler<Object> {
    private static final Logger logger =
            LoggerFactory.getLogger(CustomWebSocketServerHandler.class);
    private WebSocketServerHandshaker handshaker;
    private ChannelHandlerContext ctx;
    private String sessionId;

    @Override
    protected void channelRead0(ChannelHandlerContext context, Object obj) throws Exception {
        if (obj instanceof FullHttpRequest) { // 传统的 HTTP 接入
            handleHttpRequest(context, (FullHttpRequest) obj);
        } else if (obj instanceof WebSocketFrame) { // WebSocket 接入
            handleWebSocketRequest(context, (WebSocketFrame) obj);
        }
    }

    /**
     * 处理websocket请求
     * 
     * @param context
     * @param obj
     */
    private void handleWebSocketRequest(ChannelHandlerContext context, WebSocketFrame frame) {
        // 判断是否是关闭链路的指令
        if (frame instanceof CloseWebSocketFrame) {
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            return;
        }
        // 判断是否是 Ping 消息
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        // 当前只支持文本消息，不支持二进制消息
        if (!(frame instanceof TextWebSocketFrame)) {
            throw new UnsupportedOperationException("当前只支持文本消息，不支持二进制消息");
        }

        // 处理来自客户端的 WebSocket 请求
        try {
            Request request = Request.create(((TextWebSocketFrame) frame).text());
            Response response = new Response();
            response.setServiceId(request.getServiceId());
            if (CODE.online.code.intValue() == request.getServiceId()) { // 客户端注册
                String requestId = request.getRequestId();
                if (StringUtils.isNoneBlank(requestId)) {
                    response.setIsSucc(false).setMessage("requestId 不能为空");
                    return;
                } else if (StringUtils.isNoneBlank(request.getName())) {
                    response.setIsSucc(false).setMessage("name 不能为空");
                    return;
                } else if (CustomService.watchMap.containsKey(requestId)) {
                    response.setIsSucc(false).setMessage("您已经注册了，不能重复注册");
                    return;
                }
                if (!CustomService.register(requestId, new CustomService(ctx, request.getName()))) {
                    response.setIsSucc(false).setMessage("注册失败");
                } else {
                    response.setIsSucc(true).setMessage("注册成功");

                    CustomService.watchMap.forEach((reqId, callBack) -> {
                        response.getHadOnline().put(reqId, ((CustomService) callBack).getName()); // 将已经上线的人员返回

                        if (!reqId.equals(requestId)) {
                            Request serviceRequest = new Request();
                            serviceRequest.setServiceId(CODE.online.code);
                            serviceRequest.setRequestId(requestId);
                            serviceRequest.setName(request.getName());
                            try {
                                callBack.send(serviceRequest); // 通知有人上线
                            } catch (Exception e) {
                                logger.warn("回调发送消息给客户端异常", e);
                            }
                        }
                    });
                }
                sendWebSocket(response.toJson());
                this.sessionId = requestId; // 记录会话 id，当页面刷新或浏览器关闭时，注销掉此链路
            } else if (CODE.send_message.code.intValue() == request.getServiceId()) { // 客户端发送消息到聊天群
                String requestId = request.getRequestId();
                if (StringUtils.isNoneBlank(requestId)) {
                    response.setIsSucc(false).setMessage("requestId 不能为空");
                } else if (StringUtils.isNoneBlank(request.getName())) {
                    response.setIsSucc(false).setMessage("name 不能为空");
                } else if (StringUtils.isNoneBlank(request.getMessage())) {
                    response.setIsSucc(false).setMessage("message 不能为空");
                } else {
                    response.setIsSucc(true).setMessage("发送消息成功");

                    CustomService.watchMap.forEach((reqId, callBack) -> { // 将消息发送到所有机器
                        Request serviceRequest = new Request();
                        serviceRequest.setServiceId(CODE.receive_message.code);
                        serviceRequest.setRequestId(requestId);
                        serviceRequest.setName(request.getName());
                        serviceRequest.setMessage(request.getMessage());
                        try {
                            callBack.send(serviceRequest);
                        } catch (Exception e) {
                            logger.warn("回调发送消息给客户端异常", e);
                        }
                    });
                }
                sendWebSocket(response.toJson());
            } else if (CODE.downline.code.intValue() == request.getServiceId()) { // 客户端下线
                String requestId = request.getRequestId();
                if (StringUtils.isNoneBlank(requestId)) {
                    sendWebSocket(response.setIsSucc(false).setMessage("requestId 不能为空").toJson());
                } else {
                    CustomService.logout(requestId);
                    response.setIsSucc(true).setMessage("下线成功");

                    CustomService.notifyDownline(requestId); // 通知有人下线

                    sendWebSocket(response.toJson());
                }

            } else {
                sendWebSocket(response.setIsSucc(false).setMessage("未知请求").toJson());
            }
        } catch (Exception e1) {
            logger.error("处理 Socket 请求异常", e1);
        }
    }

    /**
     * WebSocket 返回
     * 
     * @param ctx
     * @param req
     * @param res
     */
    public void sendWebSocket(String msg) throws Exception {
        if (this.handshaker == null || this.ctx == null || this.ctx.isRemoved()) {
            throw new Exception(" 尚未握手成功，无法向客户端发送 WebSocket 消息 ");
        }
        this.ctx.channel().write(new TextWebSocketFrame(msg));
        this.ctx.flush();
    }

    /**
     * 处理http请求
     * 
     * @param context
     * @param request
     */
    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request) {
        // 如果 HTTP 解码失败，返回 HHTP 异常
        if (!request.decoderResult().isSuccess()
                || (!"websocket".equals(request.headers().get("Upgrade")))) {
            sendHttpResponse(ctx, request, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                    HttpResponseStatus.BAD_REQUEST));
            return;
        }

        // 正常 WebSocket 的 Http 连接请求，构造握手响应返回
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
                "ws://" + request.headers().get(HttpHeaderNames.HOST), null, false);
        handshaker = wsFactory.newHandshaker(request);
        if (handshaker == null) { // 无法处理的 websocket 版本
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        } else { // 向客户端发送 websocket 握手, 完成握手
            handshaker.handshake(ctx.channel(), request);
            // 记录管道处理上下文，便于服务器推送数据到客户端
            this.ctx = ctx;
        }
    }

    private void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest request,
            DefaultFullHttpResponse response) {
        // 返回应答给客户端
        if (response.status().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(response.status().toString(), CharsetUtil.UTF_8);
            response.content().writeBytes(buf);
            buf.release();
            HttpUtil.setContentLength(response, response.content().readableBytes());
        }

        // 如果是非 Keep-Alive，关闭连接
        ChannelFuture f = ctx.channel().writeAndFlush(response);
        if (!HttpUtil.isKeepAlive(request) || response.status().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }

    }

    public WebSocketServerHandshaker getHandshaker() {
        return handshaker;
    }

    public void setHandshaker(WebSocketServerHandshaker handshaker) {
        this.handshaker = handshaker;
    }

    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public void setCtx(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }


}
