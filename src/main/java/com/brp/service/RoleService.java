package com.brp.service;

import com.brp.entity.RoleEntity;
import com.brp.util.query.RoleQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: RoleService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface RoleService {
	void insertRole(RoleEntity role);
	void updateRole(RoleEntity role);
	void cancelRole(String idList, String companyId);
	RoleEntity getRoleById(Integer id);
	void deleteRoleById(String id);
	RoleQuery getRolePage(RoleQuery roleQuery);
	void startRoleById(String id);	
	
}

