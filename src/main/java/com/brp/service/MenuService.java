package com.brp.service;

import com.brp.entity.MenuEntity;
import com.brp.util.query.MenuQuery;
import com.brp.util.vo.MenuTreeVO;

import java.util.List;

/**
 * <p>
 * Project: MyBase
 * </p>
 * <p>
 * Title: MenuService.java
 * </p>
 * <p>
 * Description: TODO
 * </p>
 * <p>
 * Copyright (c) 2016 xjw Consultancy Services
 * </p>
 * <p>
 * All Rights Reserved.
 * </p>
 * 
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface MenuService {
	void insertMenu(MenuEntity menu);

	MenuQuery getMenuPage(MenuQuery menuQuery);

	void updateMenu(MenuEntity menu);

	MenuEntity getMenuById(Integer id);

	List<MenuEntity> getMenuListByCode(String code);

	void deleteMenuById(String id);

	MenuEntity getMenuByNameAndType(String menuName, String menuType);

	MenuEntity getMenuByNameAndSystemId(String menuName, String systemId);

	List<MenuEntity> getMenuList(MenuQuery menuQuery);

	List<MenuTreeVO> getMenuTreeByPid(String companyId, String pid, String definedType,
			String casecadeId);

	List<MenuEntity> getDefinedMenuList(String definedType, String menuType,
			String casecadeId, String companyId);

	List<MenuEntity> getLoginMenuList(String definedType, String menuType,
			String companyId, String definedCasecaseId);
}
