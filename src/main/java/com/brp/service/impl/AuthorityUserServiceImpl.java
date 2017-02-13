package com.brp.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.AuthorityEntity;
import com.brp.entity.AuthorityUserEntity;
import com.brp.entity.UserEntity;
import com.brp.mapper.AuthorityMapper;
import com.brp.mapper.AuthorityUserMapper;
import com.brp.mapper.UserMapper;
import com.brp.service.AuthorityService;
import com.brp.service.AuthorityUserService;
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
public class AuthorityUserServiceImpl implements AuthorityUserService{
	@Autowired
	private AuthorityUserMapper authUserMapper;
	@Override
	public void cancelAuthority(String idList, String companyId) {
		authUserMapper.cancelAuthority(idList, companyId);
	}

	@Override
	public void insertAuthorityUser(AuthorityUserEntity authUser) {
		authUserMapper.insertAuthorityUser(authUser);	
	}
	
}

