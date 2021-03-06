package com.brp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.brp.entity.AuthorityUserEntity;
import com.brp.entity.RoleUserEntity;
import com.brp.util.query.AuthorityUserQuery;
import com.brp.util.query.RoleUserQuery;

/**
 * <p>
 * Project: MyBase
 * </p>
 * <p>
 * Title: AuthorityUserMapper.java
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
public interface RoleUserMapper {
	List<RoleUserEntity> getRoleUserList(RoleUserQuery roleuserQuery);

	void cancelRole(@Param("idList") String idList,
			@Param("companyId") String companyId);

	void insertRoleUser(RoleUserEntity roleUser);

	// update authority_user set is_delete = 1 where user_id in(${userIdArr})
	// and company_id=#{companyId} and is_delete = 0 and auth_id=1
	void batchCancelRole(@Param("userIdArr") String userIdArr,
			@Param("companyId") String companyId, @Param("roleId") String roleId);
}
