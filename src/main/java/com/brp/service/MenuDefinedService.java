package com.brp.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.brp.entity.City;
import com.brp.entity.MenuDefinedEntity;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MenuDefinedService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface MenuDefinedService {
	void insertMenuDefined(MenuDefinedEntity menuDefined);
	List<MenuDefinedEntity> getMenuDefinedList(
			String companyId, String definedType, String casecadeId);
	void batchUpdateIsDelete(Integer isDelete, List<MenuDefinedEntity> list);
	void batchInsertMenuDefined(List<MenuDefinedEntity> list);
}

