package com.brp.service;

import java.util.List;

import com.brp.entity.DepartmentEntity;
import com.brp.entity.UserEntity;
import com.brp.util.query.DepartmentQuery;
import com.brp.util.query.UserQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: UserService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface UserService {
	void insertUser(UserEntity user);
	UserQuery getUserList(UserQuery userQuery);
	void updateUser(UserEntity user);
	UserEntity getUserById(Integer id);
	UserEntity login(String account, String password);
	boolean isExistTelphone(String departmentId, String telphone);
	void deleteUserById(String id);
	List<UserEntity> getUserPage(UserQuery userQuery);
}

