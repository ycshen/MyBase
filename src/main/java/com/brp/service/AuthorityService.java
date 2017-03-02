package com.brp.service;

import java.util.List;

import com.brp.entity.AuthorityEntity;
import com.brp.util.query.AuthorityQuery;
import com.brp.util.query.AuthorityVOQuery;
import com.brp.util.vo.AuthorityVO;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: AuthorityService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface AuthorityService {
	void insertAuthority(AuthorityEntity authority);
	void updateAuthority(AuthorityEntity authority);
	void cancelAuthority(String idList, String companyId);
	AuthorityEntity getAuthorityById(Integer id);
	void deleteAuthorityById(String id);
	AuthorityQuery getAuthorityPage(AuthorityQuery authorityQuery);
	void startAuthorityById(String id);	
	AuthorityVOQuery getAuthorityVOPage(AuthorityVOQuery authorityQuery);
	List<AuthorityEntity> getAuthListByUserId(String userId);
	
}

