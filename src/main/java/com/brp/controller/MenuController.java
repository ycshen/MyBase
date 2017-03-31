package com.brp.controller;

import com.brp.base.Config;
import com.brp.base.enums.MenuEnum;
import com.brp.entity.ConfigEntity;
import com.brp.entity.MenuEntity;
import com.brp.entity.UserEntity;
import com.brp.service.ConfigService;
import com.brp.service.MenuService;
import com.brp.util.UserUtils;
import com.brp.util.query.MenuQuery;
import com.brp.util.vo.BTreeVO;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
			String parentMenuId = menu.getParentMenuId();
			if(StringUtils.isNotBlank(parentMenuId)){
				Integer parentId = Integer.parseInt(parentMenuId);
				MenuEntity parentMenu = menuService.getMenuById(parentId);
				Integer maxSort = menuService.getMaxSort(parentId, menu.getMenuType());
				menu.setSort(maxSort + 1);
				menu.setBeyondOfSystem(parentMenu.getBeyondOfSystem());
				String beyondOfSystemId = parentMenu.getBeyondOfSystemId();
				if(StringUtils.isNotBlank(beyondOfSystemId)){
					menu.setBeyondOfSystemId(beyondOfSystemId);
				}else{
					menu.setBeyondOfSystemId(parentMenuId);
					parentMenu.setBeyondOfSystemId(parentMenuId);
					menuService.updateMenu(parentMenu);
				}
				
				menuService.insertMenu(menu);
			}else{
				menu.setBeyondOfSystem(menu.getMenuName());
				menuService.insertMenu(menu);
			}
			
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
	public ModelAndView editMenu(@ModelAttribute MenuEntity menu, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/menu/menu_edit");
		Long id = menu.getId();
		if(id != null){
			menu = menuService.getMenuById(id.intValue());
		}
		
		List<ConfigEntity> configList = configService.getConfigListByCode(Config.MENU);
		mav.addObject("configList", configList);
		String formName = MenuEnum.getMenuTypeName(menu.getMenuType());
		mav.addObject("formName", formName);
		mav.addObject("menu", menu);
		return mav;
	}
	
	@RequestMapping(value = "/addSubMenu", method = RequestMethod.GET)
	public ModelAndView addSubMenu(MenuEntity menu, String isTree, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/menu/menu_edit");
		List<ConfigEntity> configList = configService.getConfigListByCode(Config.MENU);
		mav.addObject("configList", configList);
		
		String formName = MenuEnum.getMenuTypeName(menu.getMenuType());
		mav.addObject("formName", formName);
		mav.addObject("isTree", isTree);
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
		menuQuery = menuService.getMenuPage(menuQuery);
		mav.addObject("menuQuery", menuQuery);
		List<ConfigEntity> configList = configService.getConfigListByCode(Config.MENU);
		mav.addObject("configList", configList);
		
		return mav;
	}
	
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public ModelAndView tree(@ModelAttribute MenuQuery menuQuery, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/menu/menu_tree");
		/*menuQuery.setMenuType(MenuEnum.SYSTEM.getMenuType().toString());
		menuQuery = menuService.getMenuList(menuQuery);
		mav.addObject("treeData", menuQuery.getItems());*/
		
		return mav;
	}
	
	@RequestMapping(value = "/treeData", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String treeData(@ModelAttribute MenuQuery menuQuery, HttpServletRequest request){
		menuQuery.setMenuType(MenuEnum.OUTER_SYSTEM.getMenuType().toString());
		menuQuery = menuService.getMenuPage(menuQuery);
		List<MenuEntity> list = menuQuery.getItems();
		String tree = StringUtils.EMPTY;
		List<BTreeVO> treeList = null;
		if(list != null && list.size() > 0){
			treeList = new LinkedList<BTreeVO>();
			BTreeVO treeVO = null;
			for (MenuEntity menuEntity : list) {
				treeVO = new BTreeVO();
				Integer idInt = menuEntity.getId().intValue();
				treeVO.setId(idInt + "_5_n");
				treeVO.setName(menuEntity.getMenuName());
				String id = menuEntity.getId().toString();
				menuQuery = new MenuQuery();
				menuQuery.setParentMenuId(id);
				menuQuery = menuService.getMenuPage(menuQuery);
				List<BTreeVO> childrens = this.getNodes(menuQuery.getItems(), menuQuery);
				treeVO.setChildren(childrens);
				treeList.add(treeVO);
			}
			
			tree = new Gson().toJson(treeList);
		}
		
		return tree;
	}
	
	private List<BTreeVO> getNodes(List<MenuEntity> list, MenuQuery menuQuery){
		List<BTreeVO> treeList = null;
		if(list != null && list.size() > 0){
			treeList = new LinkedList<BTreeVO>();
			BTreeVO treeVO = null;
			for (MenuEntity menuEntity : list) {
				treeVO = new BTreeVO();
				treeVO.setName(menuEntity.getMenuName());
				//treeVO.setId(menuEntity.getId().toString());
				Integer idInt = menuEntity.getId().intValue();
				String id = menuEntity.getId().toString();
				menuQuery = new MenuQuery();
				menuQuery.setParentMenuId(id);
				menuQuery = menuService.getMenuPage(menuQuery);
				List<BTreeVO> childrens = this.getNodes(menuQuery.getItems(), menuQuery);
				treeVO.setId(idInt + "_5_" + id);
				treeVO.setChildren(childrens);
				
				treeList.add(treeVO);
			}
			
		}
		
		return treeList;
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
	
	@RequestMapping(value = "/isSystem", method = RequestMethod.GET)
	@ResponseBody
	public Integer isSystem(Integer id, HttpServletRequest request){
		MenuEntity menu = menuService.getMenuById(id);
		Integer isSystem = 0;
		if(menu != null && MenuEnum.OUTER_SYSTEM.getMenuType() == menu.getMenuType()){
			isSystem = 1;
		}
		
		return isSystem;
	}
	
	@RequestMapping(value = "/isSystemOrUrl", method = RequestMethod.GET)
	@ResponseBody
	public Integer isSystemOrUrl(Integer id, HttpServletRequest request){
		MenuEntity menu = menuService.getMenuById(id);
		Integer isSystemOrUrl = 0;
		if(menu != null){
			Integer menuType = menu.getMenuType();
			if(MenuEnum.OUTER_SYSTEM.getMenuType() == menuType){
				isSystemOrUrl = 1;
			}else if(MenuEnum.URL.getMenuType() == menuType){
				isSystemOrUrl = 2;
			}
		}
		
		return isSystemOrUrl;
	}
	
	@RequestMapping(value = "/isExistMenu", method = RequestMethod.GET)
	@ResponseBody
	public Integer isExistMenu(Integer parentMenuId, String menuName, HttpServletRequest request){
		Integer isExist = 0;
		MenuEntity menu = null;
		if(parentMenuId != null){
			menu = menuService.getMenuById(parentMenuId);
			String systemId = menu.getBeyondOfSystemId();
			if(StringUtils.isBlank(systemId)){
				systemId = menu.getId().toString();
			}
			
			MenuEntity oldMenu = menuService.getMenuByNameAndSystemId(menuName, systemId);
			
			if(oldMenu != null){
				Integer menuType = oldMenu.getMenuType();
				if(MenuEnum.OUTER_SYSTEM.getMenuType() == menuType || MenuEnum.URL.getMenuType() == menuType){
					isExist = 1;
				}
			}
		}else{
			menu = menuService.getMenuByNameAndType(menuName, MenuEnum.OUTER_SYSTEM.getMenuType().toString());
			if(menu != null){
				isExist = 2;
			}
		}
		
		return isExist;
	}

	@RequestMapping(value = "/nextList", method = RequestMethod.GET)
	public ModelAndView nextList(Integer id, Integer menuType, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/menu/nextlevel_menu_list");
		//menuType 0-外部系统（下级：一级菜单3） 3-菜单（二级菜单7） 6-内部系统（一级菜单3）
		List<MenuEntity> list = null;
		if(menuType == 0 || menuType == 6){
			list = menuService.getNextMenuList(id, MenuEnum.URL.getMenuType());
		}else if(menuType == 3){
			list = menuService.getNextMenuList(id, MenuEnum.SECOND_URL.getMenuType());
		}

		mav.addObject("list", list);

		return mav;
	}

	@RequestMapping(value = "/sortMenu")
	@ResponseBody
	public void sortMenu(Integer plusId, Integer subtractId){
		if(plusId != null && subtractId != null){
			MenuEntity subtractMenu = menuService.getMenuById(subtractId);
			if(subtractMenu.getSort() != null &&  subtractMenu.getSort()!= 0){
				menuService.subtractOneSortById(subtractId);
			}
			menuService.plusOneSortById(plusId);
		}
	}
}

