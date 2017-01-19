package com.brp.util.query;

import com.brp.entity.MenuEntity;
import com.brp.model.pageutil.Page;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ConfigQuery.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class PositionQuery extends Page<MenuEntity>{
	private Long companyId;
	private Integer positionType; // 1.用户自定义 2.系统定义
	private String postionName;
	public Integer getPositionType() {
		return positionType;
	}
	public void setPositionType(Integer positionType) {
		this.positionType = positionType;
	}
	public String getPostionName() {
		return postionName;
	}
	public void setPostionName(String postionName) {
		this.postionName = postionName;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
}

