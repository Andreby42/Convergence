package com.convergence.web.websocket;

public interface CustomCallBack {
        // 服务端发送消息给客户端
         void send(Request request) throws Exception;
        
    }