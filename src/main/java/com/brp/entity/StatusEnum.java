package com.brp.entity;

/**
 * 状态枚举类
 *
 * @author Administrator
 */
public enum StatusEnum {
	ENABLE("1", "启用"), DISABLE("0", "禁用");
	private String code;
	private String desc;

	StatusEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static StatusEnum getStatusEnum(String code) {
		if (null == code || "".equals(code.trim())) {
			return null;
		}
		code = code.trim();
		for (StatusEnum r : StatusEnum.values()) {
			if (r.code.equals(code)) {
				return r;
			}
		}
		return null;
	}
}
