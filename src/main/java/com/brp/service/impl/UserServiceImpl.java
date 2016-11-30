package com.brp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.UserEntity;
import com.brp.mapper.UserMapper;
import com.brp.service.UserService;
import com.brp.util.query.UserQuery;

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
	public boolean isExistTelphone(String departmentId, String telphone) {
		UserEntity user = userMapper.getUserByDepartmentIdAndTelphone(departmentId, telphone);
		if(user != null){
			return true;
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
	
}

