package com.brp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.UserEntity;
import com.brp.mapper.UserMapper;
import com.brp.service.UserService;
import com.brp.util.query.UserAuthQuery;
import com.brp.util.query.UserQuery;
import com.brp.util.query.UserRoleQuery;
import com.brp.util.vo.UserAuthVO;
import com.brp.util.vo.UserRoleVO;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: UserServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public void insertUser(UserEntity user) {
		userMapper.insertUser(user);
	}

	@Override
	public UserQuery getUserList(UserQuery userQuery) {
		List<UserEntity> list = userMapper.getUserPage(userQuery);
		userQuery.setItems(list);
		
		return userQuery;
	}

	@Override
	public void updateUser(UserEntity user) {
		userMapper.updateUser(user);
	}

	@Override
	public UserEntity getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.getUserById(id);
	}

	@Override
	public UserEntity login(String account, String password) {
		return userMapper.login(account, password);
	}

	@Override
	public boolean isExistTelphone(String departmentId, String telphone, Long userId) {
		UserEntity user = userMapper.getUserByDepartmentIdAndTelphone(departmentId, telphone);
		if(user != null){
			Long existUserId = user.getId();
			if(userId != existUserId){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void deleteUserById(String id) {
		userMapper.deleteUserById(id);
	}

	@Override
	public List<UserEntity> getUserPage(UserQuery userQuery) {
		List<UserEntity> list = userMapper.getUserPage(userQuery);
		
		return list;
	}

	@Override
	public UserEntity loginMybase(String account, String password) {
		return userMapper.loginMybase(account, password);
	}

	@Override
	public List<UserEntity> getUserListByCompanyIdAndDeptId(UserQuery userQuery) {
		return userMapper.getUserListByCompanyIdAndDeptId(userQuery);
	}

	@Override
	public UserAuthQuery getUserListByAuthIdPage(UserAuthQuery userAuthQuery) {
		List<UserAuthVO> list = userMapper.getUserListByAuthIdPage(userAuthQuery);
		userAuthQuery.setItems(list);
		
		return userAuthQuery;
	}
	
	@Override
	public UserRoleQuery getUserListByRoleIdPage(UserRoleQuery userRoleQuery) {
		List<UserRoleVO> list = userMapper.getUserListByRoleIdPage(userRoleQuery);
		userRoleQuery.setItems(list);
		
		return userRoleQuery;
	}

	@Override
	public List<UserAuthVO> getAuthUserByCompanyIdAndAuthId(String companyId,
			String authId) {
		return userMapper.getAuthUserByCompanyIdAndAuthId(companyId, authId);
	}

	@Override
	public List<UserAuthVO> getNotAuthUserByCompanyIdAndAuthId(
			String companyId, String authId) {
		return userMapper.getNotAuthUserByCompanyIdAndAuthId(companyId, authId);
	}

	@Override
	public List<UserAuthVO> getUserByCompanyIdAndAuthId(String companyId,
			String authId) {
		return userMapper.getUserByCompanyIdAndAuthId(companyId, authId);
	}

	@Override
	public Integer isExistTelephone(String telephone) {
		return userMapper.isExistTelephone(telephone);
	}

	@Override
	public void changeCollapse(String userId, String isCollapseMenu) {
		userMapper.changeCollapse(userId, isCollapseMenu);
	}

	@Override
	public List<UserEntity> getUserListByCompanyId(String companyId) {
		return userMapper.getUserListByCompanyId(companyId);
	}

	@Override
	public void batchUpdateUserDefineType(String defineType, String companyId,
			String deptIdStr) {
		userMapper.batchUpdateUserDefineType(defineType, companyId, deptIdStr);
	}

	@Override
	public List<String> getUserIdListByAuthIdForRole(String authId) {
		return userMapper.getUserIdListByAuthIdForRole(authId);
	}

	@Override
	public void batchUpdateDefineTypeForRole(String userIdStr) {
		userMapper.batchUpdateDefineTypeForRole(userIdStr);
	}

	@Override
	public List<UserRoleVO> getRoleUserByCompanyIdAndRoleId(String companyId,
			String roleId) {
		return userMapper.getRoleUserByCompanyIdAndRoleId(companyId, roleId);
	}

	@Override
	public List<UserRoleVO> getUserByCompanyIdAndRoleId(String companyId,
			String roleId) {
		return userMapper.getUserByCompanyIdAndRoleId(companyId, roleId);
	}

	@Override
	public List<UserRoleVO> getNotRoleUserByCompanyIdAndRoleId(
			String companyId, String roleId) {
		return userMapper.getNotRoleUserByCompanyIdAndRoleId(companyId, roleId);
	}

	
	
}

