package com.brp.util.query;

import com.brp.entity.AuthorityUserEntity;
import com.brp.model.pageutil.Page;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: AuthorityUserQuery.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class AuthorityUserQuery extends Page<AuthorityUserEntity>{
	private Integer authId;
	private Integer companyId;
	private Integer userId;
	public Integer getAuthId() {
		return authId;
	}
	public void setAuthId(Integer authId) {
		this.authId = authId;
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
