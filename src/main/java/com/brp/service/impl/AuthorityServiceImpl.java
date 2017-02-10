package com.brp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.AuthorityEntity;
import com.brp.mapper.AuthorityMapper;
import com.brp.service.AuthorityService;
import com.brp.util.query.AuthorityQuery;

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

	
}

