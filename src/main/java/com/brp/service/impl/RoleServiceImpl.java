package com.brp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.RoleEntity;
import com.brp.mapper.RoleMapper;
import com.brp.mapper.UserMapper;
import com.brp.service.RoleService;
import com.brp.util.query.RoleQuery;

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
	private RoleMapper roleMapper;
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

	/*@Override
	public RoleVOQuery getRoleVOPage(RoleVOQuery roleQuery) {
		List<RoleVO> list = authMapper.getRoleVOPage(roleQuery);
		String companyId = roleQuery.getCompanyId();
		if(StringUtils.isNotBlank(companyId)){
			
		}
		
		List<RoleVO> handleList = null;
		if(list != null && list.size() > 0){
			handleList = new LinkedList<RoleVO>();
			RoleUserQuery authuserQuery = null;
			for (RoleVO auth : list) {
				Integer count = auth.getCount();
				if(count != null && count > 0){
					String authId = auth.getId();
					authuserQuery = new RoleUserQuery();
					if(StringUtils.isNotBlank(companyId)){
						authuserQuery.setCompanyId(Integer.parseInt(companyId));
					}
					authuserQuery.setAuthId(Integer.parseInt(authId));
					List<RoleUserEntity> authUserlist = authUserMapper.getRoleUserList(authuserQuery);
					String userList = "";
					if(authUserlist != null && authUserlist.size() > 0){
						for (RoleUserEntity auser : authUserlist) {
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
					
					auth.setUserList(userList);
				}
				
				handleList.add(auth);
			}
		}
		
		roleQuery.setItems(handleList);
		
		return roleQuery;
	}*/

	/*@Override
	public void cancelRole(String idList, String companyId) {
		authUserMapper.cancelRole(idList, companyId);
	}
*/
	
}

