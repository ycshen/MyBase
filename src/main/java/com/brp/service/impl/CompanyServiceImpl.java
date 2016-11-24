package com.brp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.CompanyEntity;
import com.brp.mapper.CompanyMapper;
import com.brp.service.CompanyService;
import com.brp.util.query.CompanyQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: CompanyService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class CompanyServiceImpl implements CompanyService{
	@Autowired
	private CompanyMapper companyMapper;
	@Override
	public void insertCompany(CompanyEntity company) {
		companyMapper.insertCompany(company);
	}
	
	@Override
	public CompanyQuery getCompanyList(CompanyQuery companyQuery) {
		List<CompanyEntity> list = companyMapper.getCompanyPage(companyQuery);
		if(list != null && list.size() > 0){
			companyQuery.setItems(list);
		}
		
		return companyQuery;
	}

	@Override
	public void updateCompany(CompanyEntity company) {
		companyMapper.updateCompany(company);
	}

	@Override
	public CompanyEntity getCompanyById(Long id) {
		CompanyEntity company = companyMapper.getCompanyById(id.intValue());
		
		return company;
	}
}

