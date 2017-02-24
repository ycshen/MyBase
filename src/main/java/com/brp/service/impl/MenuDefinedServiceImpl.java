package com.brp.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.MenuDefinedEntity;
import com.brp.mapper.MenuDefinedMapper;
import com.brp.service.MenuDefinedService;

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
			String idStr = "";
			for (MenuDefinedEntity md : list) {
				idStr += md.getId().toString() + ",";
			}
			
			if(StringUtils.isNotBlank(idStr)){
				idStr = idStr.substring(0, idStr.length() - 1);
				mdMapper.batchUpdateIsDelete(isDelete, idStr);
			}
		}
	}
	@Override
	public void batchInsertMenuDefined(List<MenuDefinedEntity> list) {
		if(list != null && list.size() > 0){
			mdMapper.batchInsertMenuDefined(list);
		}
	}
	
	
}

