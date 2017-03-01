package com.brp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.RoleUserEntity;
import com.brp.mapper.RoleUserMapper;
import com.brp.service.RoleUserService;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: RoleServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @roleor <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class RoleUserServiceImpl implements RoleUserService{
	@Autowired
	private RoleUserMapper roleUserMapper;
	@Override
	public void cancelRole(String idList, String companyId) {
		roleUserMapper.cancelRole(idList, companyId);
	}

	@Override
	public void insertRoleUser(RoleUserEntity roleUser) {
		roleUserMapper.insertRoleUser(roleUser);	
	}

	@Override
	public void batchCancelRole(String userIdArr, String companyId,
			String roleId) {
		roleUserMapper.batchCancelRole(userIdArr, companyId, roleId);
	}
	
}

