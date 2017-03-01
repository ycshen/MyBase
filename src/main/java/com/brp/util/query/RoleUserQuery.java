package com.brp.util.query;

import com.brp.entity.RoleUserEntity;
import com.brp.model.pageutil.Page;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: AuthorityUserQuery.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class RoleUserQuery extends Page<RoleUserEntity>{
	private Integer roleId;
	private Integer companyId;
	private Integer userId;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
