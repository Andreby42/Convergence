package com.convergence.config;

import java.nio.charset.Charset;

import org.springframework.http.MediaType;

public class ProtoBufMediaType extends MediaType {
    public static final String APPLICATION_PROTOBUF_VALUE = "application/x-protobuf";
    public final static String APPLICATION_PROTOBUF_UTF8_VALUE =
            APPLICATION_PROTOBUF_VALUE + ";charset=UTF-8";

    public ProtoBufMediaType(MediaType other, Charset charset) {
        super(other, charset);
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
}
