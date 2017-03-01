package com.brp.service;

import com.brp.entity.RoleUserEntity;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: RoleUserService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @roleor <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface RoleUserService {
	void cancelRole(String idList, String companyId);
	void insertRoleUser(RoleUserEntity roleUser);
	void batchCancelRole(String userIdArr, String companyId, String roleId);
}

