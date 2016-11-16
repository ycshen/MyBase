package com.brp.entity;

/**
 * 请求方式枚举类
 * 
 * @author Administrator
 *
 */
public enum RequestType {
	POST("1", "POST"), GET("2", "GET"), HEAD("5", "HEAD"), OPTIONS("6", "OPTIONS"), PUT("3", "PUT"), PATCH("7",
			"PATCH"), DELETE("4", "DELETE"), TRACE("8", "TRACE");
	private String code;
	private String name;

	private RequestType(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public static RequestType getRequestTypeByCode(String code) {
		if (null == code || "".equals(code.trim())) {
			return null;
		}
		code = code.trim();
		for (RequestType r : RequestType.values()) {
			if (r.code.equals(code)) {
				return r;
			}
		}
		return null;
	}

	public static RequestType getRequestTypeByName(String name) {
		if (null == name || "".equals(name.trim())) {
			return null;
		}
		name = name.trim();
		for (RequestType r : RequestType.values()) {
			if (r.name.equals(name)) {
				return r;
			}
		}
		return null;
	}
}
