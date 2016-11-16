package com.brp.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.brp.entity.UserEntity;
import com.brp.util.query.UserQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: UserMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface UserMapper {
	void insertUser(UserEntity user);
	List<UserEntity> getUserList(UserQuery userQuery);
	void updateUser(UserEntity user);
	UserEntity getUserById(Integer id);
	UserEntity login(String account, String password);
}

