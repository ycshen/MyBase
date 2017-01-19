package com.brp.base.enums;
/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MenuEnum.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public enum PositionEnum {
	SYSTEM_DEFINED(1, "系统定义"), 
	USER_DEFINED(2, "用户定义");
	private Integer positionType; 
	private String positionTypeName;
	private PositionEnum(Integer positionType, String positionTypeName)  
    {  
        this.positionType = positionType;  
        this.positionTypeName = positionTypeName;  
    }
	
	public Integer getPositionType() {
		return positionType;
	}

	public void setPositionType(Integer positionType) {
		this.positionType = positionType;
	}

	public String getPositionTypeName() {
		return positionTypeName;
	}

	public void setPositionTypeName(String positionTypeName) {
		this.positionTypeName = positionTypeName;
	}

	public static String getPositonTypeName(Integer positionType) {
		for (PositionEnum position : PositionEnum.values()) {
			if(positionType == position.getPositionType()){
				return position.getPositionTypeName();
			}
		}
		return null;
	}
	
}

