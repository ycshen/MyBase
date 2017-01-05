package com.brp.entity;

import java.util.Date;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: UserEntity.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class MemoEntity extends BaseEntity{
	private Long userId;
	private Date memoTime; //备忘时间
	private Long memoEventId;
	private Integer isDelete; //是否删除
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getMemoTime() {
		return memoTime;
	}
	public void setMemoTime(Date memoTime) {
		this.memoTime = memoTime;
	}
	public Long getMemoEventId() {
		return memoEventId;
	}
	public void setMemoEventId(Long memoEventId) {
		this.memoEventId = memoEventId;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}

