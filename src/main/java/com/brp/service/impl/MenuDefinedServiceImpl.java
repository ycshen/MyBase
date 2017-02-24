package com.brp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.Area;
import com.brp.entity.City;
import com.brp.entity.ConfigEntity;
import com.brp.entity.MenuDefinedEntity;
import com.brp.entity.OrganizationEntity;
import com.brp.mapper.CityMapper;
import com.brp.mapper.ConfigMapper;
import com.brp.mapper.MenuDefinedMapper;
import com.brp.mapper.OrganizationMapper;
import com.brp.service.AreaService;
import com.brp.service.CityService;
import com.brp.service.ConfigService;
import com.brp.service.MenuDefinedService;
import com.brp.service.OrganzationService;
import com.brp.util.query.ConfigQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MenuDefinedServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class MenuDefinedServiceImpl implements MenuDefinedService{
	@Autowired
	private MenuDefinedMapper mdMapper;
	@Override
	public void insertMenuDefined(MenuDefinedEntity menuDefined) {
		mdMapper.insertMenuDefined(menuDefined);
	}
	@Override
	public List<MenuDefinedEntity> getMenuDefinedList(String companyId,
			String definedType, String casecadeId) {
		return mdMapper.getMenuDefinedList(companyId, definedType, casecadeId);
	}
	@Override
	public void batchUpdateIsDelete(Integer isDelete, List<MenuDefinedEntity> list) {
		if(list != null && list.size() > 0){
			
		}
	}
	@Override
	public void batchInsertMenuDefined(List<MenuDefinedEntity> list) {
		if(list != null && list.size() > 0){
			
		}
	}
	
	
}

