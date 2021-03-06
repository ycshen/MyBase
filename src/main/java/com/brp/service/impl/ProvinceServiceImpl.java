package com.brp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.Area;
import com.brp.entity.ConfigEntity;
import com.brp.entity.OrganizationEntity;
import com.brp.entity.Province;
import com.brp.mapper.ConfigMapper;
import com.brp.mapper.OrganizationMapper;
import com.brp.mapper.ProvinceMapper;
import com.brp.service.AreaService;
import com.brp.service.ConfigService;
import com.brp.service.OrganzationService;
import com.brp.service.ProvinceService;
import com.brp.util.query.ConfigQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: AreaServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class ProvinceServiceImpl implements ProvinceService{
	@Autowired
	private ProvinceMapper provinceMapper;
	@Override
	public void insertProvince(Province province) {
		provinceMapper.insertProvince(province);
	}
	@Override
	public List<Province> getAllProvince() {
		return provinceMapper.getAllProvince();
	}

}

