package com.brp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.MenuEntity;
import com.brp.mapper.MenuMapper;
import com.brp.service.MenuService;
import com.brp.util.query.MenuQuery;
import com.brp.util.vo.MenuTreeVO;
import com.google.gson.Gson;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MenuService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	private MenuMapper menuMapper;
	@Override
	public void insertMenu(MenuEntity menu) {
		menuMapper.insertMenu(menu);
	}
	
	@Override
	public MenuQuery getMenuPage(MenuQuery menuQuery) {
		List<MenuEntity> list = menuMapper.getMenuPage(menuQuery);
		if(list != null && list.size() > 0){
			menuQuery.setItems(list);
		}
		
		return menuQuery;
	}

	@Override
	public void updateMenu(MenuEntity menu) {
		menuMapper.updateMenu(menu);
	}

	@Override
	public MenuEntity getMenuById(Integer id) {
		MenuEntity Menu = menuMapper.getMenuById(id);
		
		return Menu;
	}

	@Override
	public List<MenuEntity> getMenuListByCode(String code) {
		List<MenuEntity> list = menuMapper.getMenuListByCode(code);
		
		return list;
	}

	@Override
	public void deleteMenuById(String id) {
		menuMapper.deleteMenuById(id);
	}

	@Override
	public MenuEntity getMenuByNameAndType(String menuName, String menuType) {
		return menuMapper.getMenuByNameAndType(menuName, menuType);
	}

	@Override
	public MenuEntity getMenuByNameAndSystemId(String menuName, String systemId) {
		return menuMapper.getMenuByNameAndSystemId(menuName, systemId);
	}
}

