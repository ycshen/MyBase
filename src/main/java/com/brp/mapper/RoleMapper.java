package com.brp.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.brp.entity.RoleEntity;
import com.brp.util.query.AuthorityVOQuery;
import com.brp.util.query.RoleQuery;
import com.brp.util.query.RoleVOQuery;
import com.brp.util.vo.AuthorityVO;
import com.brp.util.vo.RoleVO;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: PositionMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface RoleMapper {
	void insertRole(RoleEntity role);
	void updateRole(RoleEntity role);
	RoleEntity getRoleById(Integer id);
	void deleteRoleById(String id);
	void startRoleById(String id);
	List<RoleEntity> getRolePage(RoleQuery roleQuery);	
	List<RoleVO> getRoleVOPage(RoleVOQuery roleQuery);

	
}

