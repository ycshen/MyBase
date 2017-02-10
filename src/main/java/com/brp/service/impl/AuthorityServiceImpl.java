package com.brp.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.AuthorityEntity;
import com.brp.entity.AuthorityUserEntity;
import com.brp.entity.UserEntity;
import com.brp.mapper.AuthorityMapper;
import com.brp.mapper.AuthorityUserMapper;
import com.brp.mapper.UserMapper;
import com.brp.service.AuthorityService;
import com.brp.util.query.AuthorityQuery;
import com.brp.util.query.AuthorityUserQuery;
import com.brp.util.query.AuthorityVOQuery;
import com.brp.util.vo.AuthorityVO;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: AuthorityServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	private AuthorityMapper authMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AuthorityUserMapper authUserMapper;
	@Override
	public void insertAuthority(AuthorityEntity authority) {
		authMapper.insertAuthority(authority);
	}

	@Override
	public void updateAuthority(AuthorityEntity authority) {
		authMapper.updateAuthority(authority);
	}

	@Override
	public AuthorityEntity getAuthorityById(Integer id) {
		
		return authMapper.getAuthorityById(id);
	}

	@Override
	public void deleteAuthorityById(String id) {
		authMapper.deleteAuthorityById(id);
	}

	@Override
	public AuthorityQuery getAuthorityPage(AuthorityQuery authorityQuery) {
		List<AuthorityEntity> list = authMapper.getAuthorityPage(authorityQuery);
		authorityQuery.setItems(list);
		
		return authorityQuery;
	}

	@Override
	public void startAuthorityById(String id) {
		authMapper.startAuthorityById(id);
	}

	@Override
	public AuthorityVOQuery getAuthorityVOPage(AuthorityVOQuery authorityQuery) {
		List<AuthorityVO> list = authMapper.getAuthorityVOPage(authorityQuery);
		List<AuthorityVO> handleList = null;
		if(list != null && list.size() > 0){
			handleList = new LinkedList<AuthorityVO>();
			AuthorityUserQuery authuserQuery = null;
			for (AuthorityVO auth : list) {
				Integer count = auth.getCount();
				if(count != null && count > 0){
					String authId = auth.getId();
					authuserQuery = new AuthorityUserQuery();
					authuserQuery.setAuthId(Integer.parseInt(authId));
					List<AuthorityUserEntity> authUserlist = authUserMapper.getAuthorityUserList(authuserQuery);
					String userList = "";
					if(authUserlist != null && authUserlist.size() > 0){
						for (AuthorityUserEntity auser : authUserlist) {
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
		
		authorityQuery.setItems(handleList);
		
		return authorityQuery;
	}

	
}

