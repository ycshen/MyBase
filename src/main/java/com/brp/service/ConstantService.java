package com.brp.service;

import com.brp.entity.ConstantEntity;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ConstantService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface ConstantService {
	ConstantEntity getConstantByCode(String code);
	void insertConstant(ConstantEntity constant);
	void updateConstant(ConstantEntity constant);
}

