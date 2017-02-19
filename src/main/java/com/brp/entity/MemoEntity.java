package com.brp.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

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
	private String memoStartTime; //备忘开始时间
	private String memoEndTime; //备忘结束时间
	private String memoName; //行程名称
	private Long memoTypeId;
	private String memoDesc;
	private Integer status; //1-未结束  2-已结束  3-已取消
	private Integer isDelete; //是否删除
	private String companyId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getMemoStartTime() {
		return memoStartTime;
	}
	public void setMemoStartTime(String memoStartTime) {
		this.memoStartTime = memoStartTime;
	}
	public String getMemoEndTime() {
		return memoEndTime;
	}
	public void setMemoEndTime(String memoEndTime) {
		this.memoEndTime = memoEndTime;
	}
	public String getMemoName() {
		return memoName;
	}
	public void setMemoName(String memoName) {
		this.memoName = memoName;
	}
	public Long getMemoTypeId() {
		return memoTypeId;
	}
	public void setMemoTypeId(Long memoTypeId) {
		this.memoTypeId = memoTypeId;
	}
	public String getMemoDesc() {
		return memoDesc;
	}
	public void setMemoDesc(String memoDesc) {
		this.memoDesc = memoDesc;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
}

