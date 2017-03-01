package com.brp.util.query;

import com.brp.model.pageutil.Page;
import com.brp.util.vo.RoleVO;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: RoleVOQuery.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class RoleVOQuery extends Page<RoleVO>{
	private String roleName;
	private String companyId;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}

