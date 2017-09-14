package com.convergence.support.common;

import java.io.Serializable;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int SUCCESS = 0;

	public static int FAILED = -1;
	public static String MSG_SUCCESS = "success";
	public static String MSG_FAILED = "failed";
	public static String[] NOOP = new String[] {};

	private int code;

	private String message;

	private Object data;

	public Result(int code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Result(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public static final Result success(Object data) {
		return new Result(SUCCESS, MSG_SUCCESS, data);
	}

	public static final Result success() {
		return new Result(SUCCESS, MSG_SUCCESS, NOOP);
	}

	public static final Result success(String msg) {
		return new Result(SUCCESS, msg, NOOP);
	}

	public static final Result success(String msg, Object data) {
		return new Result(SUCCESS, msg, data);
	}

	public static final Result failure(int code, String msg, Object data) {
		return new Result(code, msg, data);
	}

	public static final Result failure(String msg) {
		return new Result(FAILED, msg, NOOP);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", message=" + message + ", data=" + data + "]";
	}

}
