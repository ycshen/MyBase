package com.brp.entity;


/** 
 * <p>Project: MyBase</p> 
 * <p>Title: UserEntity.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class MemoEventEntity extends BaseEntity{
	private Long userId;
	private String momeEventName; //备忘录事件名称
	private Integer level;
	private String levelColor;
	private Integer isDelete;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getMomeEventName() {
		return momeEventName;
	}
	public void setMomeEventName(String momeEventName) {
		this.momeEventName = momeEventName;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getLevelColor() {
		return levelColor;
	}
	public void setLevelColor(String levelColor) {
		this.levelColor = levelColor;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}

