package com.convergence.web.websocket;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

public class Request {
    private String requestId;
    private int serviceId;
    private String name;
    private String message;
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getRequestId() {
        return requestId;
    }

    public Request setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public int getServiceId() {
        return serviceId;
    }

    public Request setServiceId(int serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Request setName(String name) {
        this.name = name;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Request setMessage(String message) {
        this.message = message;
        return this;
    }

    public static Request create(String json) {
        if (StringUtils.isNotBlank(json)) {
            return JSON.parseObject(json, Request.class);
        }
        return null;
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }

    @Override
    public String toString() {
        return toJson();
    }

}
