package com.brp.util.query;

import com.brp.model.pageutil.Page;
import com.brp.util.vo.AuthorityVO;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ConfigQuery.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class AuthorityVOQuery extends Page<AuthorityVO>{
	private String authName;
	private String companyId;

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}

