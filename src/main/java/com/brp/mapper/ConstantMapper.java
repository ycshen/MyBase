package com.brp.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.brp.entity.CompanyEntity;
import com.brp.entity.ConstantEntity;
import com.brp.entity.OrganizationEntity;
import com.brp.util.query.CompanyQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ConstantMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface ConstantMapper {
	ConstantEntity getConstantByCode(String code);
	void insertConstant(ConstantEntity constant);
	void updateConstant(ConstantEntity constant);
}

