package com.brp.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.brp.entity.CompanyEntity;
import com.brp.entity.OrganizationEntity;
import com.brp.util.query.CompanyQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: OrganizationMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface OrganizationMapper {
	String getOrgByCompanyId(Integer companyId);
	void insertCompanyOrg(OrganizationEntity org);
	void updateCompnayOrg(OrganizationEntity org);
}

