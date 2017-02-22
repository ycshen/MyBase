package com.brp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.ConfigEntity;
import com.brp.entity.ConstantEntity;
import com.brp.entity.OrganizationEntity;
import com.brp.mapper.ConfigMapper;
import com.brp.mapper.ConstantMapper;
import com.brp.mapper.OrganizationMapper;
import com.brp.service.ConfigService;
import com.brp.service.ConstantService;
import com.brp.service.OrganzationService;
import com.brp.util.query.ConfigQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ConfigService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class ConstantServiceImpl implements ConstantService{
	@Autowired
	private ConstantMapper constantMapper;

	@Override
	public ConstantEntity getConstantByCode(String code) {
		return constantMapper.getConstantByCode(code);
	}

	@Override
	public void insertConstant(ConstantEntity constant) {
		constantMapper.insertConstant(constant);
	}

	@Override
	public void updateConstant(ConstantEntity constant) {
		constantMapper.updateConstant(constant);
	}

	
	
}

