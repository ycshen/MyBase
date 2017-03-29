package com.brp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.brp.entity.UserEntity;
import com.brp.util.query.UserAuthQuery;
import com.brp.util.query.UserQuery;
import com.brp.util.query.UserRoleQuery;
import com.brp.util.vo.UserAuthVO;
import com.brp.util.vo.UserRoleVO;

/**
 * <p>
 * Project: MyBase
 * </p>
 * <p>
 * Title: UserMapper.java
 * </p>
 * <p>
 * Description: TODO
 * </p>
 * <p>
 * Copyright (c) 2016 xjw Consultancy Services
 * </p>
 * <p>
 * All Rights Reserved.
 * </p>
 * 
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface UserMapper {
	void insertUser(UserEntity user);

	List<UserEntity> getUserPage(UserQuery userQuery);

	void updateUser(UserEntity user);

	UserEntity getUserById(Integer id);

	UserEntity login(@Param("account") String account,
			@Param("password") String password);

	UserEntity getUserByDepartmentIdAndTelphone(
			@Param("departmentId") String departmentId,
			@Param("telphone") String telphone);

	void deleteUserById(String id);

	UserEntity loginMybase(@Param("account") String account,
			@Param("password") String password);

	List<UserEntity> getUserListByCompanyIdAndDeptId(UserQuery userQuery);

	List<UserAuthVO> getUserListByAuthIdPage(UserAuthQuery userAuthQuery);
	List<UserRoleVO> getUserListByRoleIdPage(UserRoleQuery userRoleQuery);
	
	List<UserRoleVO> getRoleUserByCompanyIdAndRoleId(
			@Param("companyId") String companyId, @Param("roleId") String roleId);
	List<UserAuthVO> getAuthUserByCompanyIdAndAuthId(
			@Param("companyId") String companyId, @Param("authId") String authId);
	List<UserAuthVO> getUserByCompanyIdAndAuthId(
			@Param("companyId") String companyId, @Param("authId") String authId);

	List<UserAuthVO> getNotAuthUserByCompanyIdAndAuthId(
			@Param("companyId") String companyId, @Param("authId") String authId);
	List<UserRoleVO> getUserByCompanyIdAndRoleId(
			@Param("companyId") String companyId, @Param("roleId") String roleId);

	List<UserRoleVO> getNotRoleUserByCompanyIdAndRoleId(
			@Param("companyId") String companyId, @Param("roleId") String roleId);
	Integer isExistTelephone(String telephone);

	void changeCollapse(@Param("userId") String userId,
			@Param("isCollapseMenu") String isCollapseMenu);

	List<UserEntity> getUserListByCompanyId(String companyId);
	Integer getUserCountByCompanyId(String companyId);
	void batchUpdateUserDefineType(@Param("defineType") String defineType,
			@Param("companyId") String companyId,
			@Param("deptIdStr") String deptIdStr);
	List<String> getUserIdListByAuthIdForRole(String authId);
	void batchUpdateDefineTypeForRole(String userIdStr);
}
