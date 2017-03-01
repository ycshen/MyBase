package com.brp.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.AuthorityUserEntity;
import com.brp.entity.RoleEntity;
import com.brp.entity.RoleUserEntity;
import com.brp.entity.UserEntity;
import com.brp.mapper.RoleMapper;
import com.brp.mapper.RoleUserMapper;
import com.brp.mapper.UserMapper;
import com.brp.service.RoleService;
import com.brp.util.query.AuthorityUserQuery;
import com.brp.util.query.RoleQuery;
import com.brp.util.query.RoleUserQuery;
import com.brp.util.query.RoleVOQuery;
import com.brp.util.vo.AuthorityVO;
import com.brp.util.vo.RoleVO;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: RoleServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper roleMapper;@Autowired
	private RoleUserMapper roleUserMapper;
	@Autowired
	private UserMapper userMapper;
	/*@Autowired
	private RoleUserMapper authUserMapper;*/
	@Override
	public void insertRole(RoleEntity role) {
		roleMapper.insertRole(role);
	}

	@Override
	public void updateRole(RoleEntity role) {
		roleMapper.updateRole(role);
	}

	@Override
	public RoleEntity getRoleById(Integer id) {
		
		return roleMapper.getRoleById(id);
	}

	@Override
	public void deleteRoleById(String id) {
		roleMapper.deleteRoleById(id);
	}

	@Override
	public RoleQuery getRolePage(RoleQuery roleQuery) {
		List<RoleEntity> list = roleMapper.getRolePage(roleQuery);
		roleQuery.setItems(list);
		
		return roleQuery;
	}

	@Override
	public void startRoleById(String id) {
		roleMapper.startRoleById(id);
	}

	@Override
	public void cancelRole(String idList, String companyId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RoleVOQuery getRoleVOPage(RoleVOQuery roleQuery) {
		List<RoleVO> list = roleMapper.getRoleVOPage(roleQuery);
		String companyId = roleQuery.getCompanyId();
		if(StringUtils.isNotBlank(companyId)){
			
		}
		
		List<RoleVO> handleList = null;
		if(list != null && list.size() > 0){
			handleList = new LinkedList<RoleVO>();
			RoleUserQuery roleuserQuery = null;
			for (RoleVO role : list) {
				Integer count = role.getCount();
				if(count != null && count > 0){
					String roleId = role.getId();
					roleuserQuery = new RoleUserQuery();
					if(StringUtils.isNotBlank(companyId)){
						roleuserQuery.setCompanyId(Integer.parseInt(companyId));
					}
					roleuserQuery.setRoleId(Integer.parseInt(roleId));
					List<RoleUserEntity> roleUserlist = roleUserMapper.getRoleUserList(roleuserQuery);
					String userList = "";
					if(roleUserlist != null && roleUserlist.size() > 0){
						for (RoleUserEntity auser : roleUserlist) {
							Integer userId = auser.getUserId();
							UserEntity user = userMapper.getUserById(userId);
							if(user != null){
								userList += user.getUserName() + ";";
							}
						}
					}
					
					if(StringUtils.isNotBlank(userList)){
						userList = userList.substring(0, userList.length() - 1);
					}
					
					role.setUserList(userList);
				}
				
				handleList.add(role);
			}
		}
		
		roleQuery.setItems(handleList);
		
		return roleQuery;
	}

	
}

