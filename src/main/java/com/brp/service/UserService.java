package com.brp.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.brp.entity.DepartmentEntity;
import com.brp.entity.UserEntity;
import com.brp.util.query.DepartmentQuery;
import com.brp.util.query.UserAuthQuery;
import com.brp.util.query.UserQuery;
import com.brp.util.vo.UserAuthVO;

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
	boolean isExistTelphone(String departmentId, String telphone, Long userId);
	void deleteUserById(String id);
	List<UserEntity> getUserPage(UserQuery userQuery);
	UserEntity loginMybase(String account, String password);
	List<UserEntity> getUserListByCompanyIdAndDeptId(UserQuery userQuery);
	UserAuthQuery getUserListByAuthIdPage(UserAuthQuery userAuthQuery);

	List<UserAuthVO> getAuthUserByCompanyIdAndAuthId(String companyId, String authId);
	List<UserAuthVO> getUserByCompanyIdAndAuthId(String companyId, String authId);
	List<UserAuthVO> getNotAuthUserByCompanyIdAndAuthId(String companyId, String authId);
	Integer isExistTelephone(String telephone);
	void changeCollapse(String userId, String isCollapseMenu);
	List<UserEntity> getUserListByCompanyId(String companyId);
}

