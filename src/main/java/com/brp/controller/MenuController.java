package com.brp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.brp.base.Config;
import com.brp.base.MenuEnum;
import com.brp.entity.ConfigEntity;
import com.brp.entity.MenuEntity;
import com.brp.entity.UserEntity;
import com.brp.service.ConfigService;
import com.brp.service.MenuService;
import com.brp.util.UserUtils;
import com.brp.util.query.MenuQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MenuController.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/inner/menu")
public class MenuController extends BaseController{
	@Autowired
	private MenuService menuService;
	@Autowired
	private ConfigService configService;
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveOrUpdate(@ModelAttribute MenuEntity menu, HttpServletRequest request){
		Integer result = 0;
		Long id = menu.getId();
		UserEntity user = UserUtils.getLoginUser(request);
		Integer menuType = menu.getMenuType();
		String menuTypeName = MenuEnum.getMenuTypeName(menuType);
		String menuTypeTag = MenuEnum.getMenuTypeTag(menuType);
		menu.setMenuTypeName(menuTypeName);
		menu.setMenuTypeTag(menuTypeTag);
		
		if(id == null){
			menu.setCreateTime(new Date());
			menu.setCreateUser(user.getUserName());
			menu.setIsDelete(0);
			menuService.insertMenu(menu);
			result = 1;
		}else{
			menu.setUpdateTime(new Date());
			menu.setUpdateUser(user.getUserName());
			menuService.updateMenu(menu);
			result = 2;
		}
		
		return result;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editMenu(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/menu/menu_edit");
		MenuEntity menu = null;
		if(StringUtils.isNotBlank(id)){
			menu = menuService.getMenuById(Integer.parseInt(id));
		}
		
		List<ConfigEntity> configList = configService.getConfigListByCode(Config.MENU);
		mav.addObject("configList", configList);
		mav.addObject("menu", menu);
		
		return mav;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewMenu(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/menu/menu_detail");
		MenuEntity menu = null;
		if(StringUtils.isNotBlank(id)){
			menu = menuService.getMenuById(Integer.parseInt(id));
		}
		
		mav.addObject("menu", menu);
		
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listMenu(@ModelAttribute MenuQuery menuQuery, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/menu/menu_list");
		menuQuery = menuService.getMenuList(menuQuery);
		mav.addObject("menuQuery", menuQuery);
		
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public void delete(String id, HttpServletRequest request){
		UserEntity user = UserUtils.getLoginUser(request);
		if(StringUtils.isNotBlank(id)){
			MenuEntity menu = menuService.getMenuById(Integer.parseInt(id));
			menu.setUpdateTime(new Date());
			menu.setUpdateUser(user.getUserName());
			menu.setIsDelete(1);
			menuService.updateMenu(menu);
		}
	}
}

