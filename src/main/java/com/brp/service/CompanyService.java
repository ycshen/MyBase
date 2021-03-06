package com.brp.service;

import java.util.List;

import com.brp.entity.CompanyEntity;
import com.brp.util.query.CompanyQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: CompanyService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface CompanyService {
	void insertCompany(CompanyEntity company);
	CompanyQuery getCompanyList(CompanyQuery companyQuery);
	void updateCompany(CompanyEntity company);
	CompanyEntity getCompanyById(Long id);
	String getSecretById(Long id);
	CompanyQuery getSubCompanyPage(CompanyQuery companyQuery);
	Integer deleteCompany(Long id);
	Integer activateCompany(Long id);
	List<CompanyEntity> getSubCompanyListByPId(Integer pId);
	
}

