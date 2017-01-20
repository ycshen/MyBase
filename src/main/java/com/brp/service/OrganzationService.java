package com.brp.service;

import com.brp.entity.OrganizationEntity;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: OrganzationService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface OrganzationService {

	String getOrgByCompanyId(Integer companyId);
	void insertCompanyOrg(OrganizationEntity org);
	void updateCompnayOrg(OrganizationEntity org);
}

