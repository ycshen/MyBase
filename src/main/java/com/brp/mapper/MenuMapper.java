package com.brp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.brp.entity.MenuEntity;
import com.brp.util.query.MenuQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MenuMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface MenuMapper {
	void insertMenu(MenuEntity menu);
	List<MenuEntity> getMenuPage(MenuQuery menuQuery);
	void updateMenu(MenuEntity menu);
	MenuEntity getMenuById(Integer id);
	List<MenuEntity> getMenuListByCode(String code);
	void deleteMenuById(String id);
	MenuEntity getMenuByNameAndType(@Param("menuName")String menuName, @Param("menuType")String menuType);
	MenuEntity getMenuByNameAndSystemId(@Param("menuName")String menuName, @Param("systemId")String systemId);
}

