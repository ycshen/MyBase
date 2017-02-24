package com.brp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.brp.entity.MenuDefinedEntity;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MenuDefinedMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface MenuDefinedMapper {
	void insertMenuDefined(MenuDefinedEntity menuDefined);
	List<MenuDefinedEntity> getMenuDefinedList(
			@Param("companyId")String companyId, 
			@Param("definedType")String definedType, 
			@Param("casecadeId")String casecadeId);
}

