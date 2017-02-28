package com.brp.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.brp.base.Status;
import com.brp.entity.RoleEntity;
import com.brp.entity.UserEntity;
import com.brp.service.RoleService;
import com.brp.util.UserUtils;
import com.brp.util.query.RoleQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ConfigController.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @roleor <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/inner/role")
public class RoleController extends BaseController{

	@Autowired
	private RoleService roleService;
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveOrUpdate(@ModelAttribute RoleEntity role, HttpServletRequest request){
		Integer result = 0;
		Long id = role.getId();
		UserEntity user = UserUtils.getLoginUser(request);
		if(id == null){
			role.setCreateTime(new Date());
			role.setCreateUser(user.getUserName());
			role.setIsDelete(Status.NORMAL);
			roleService.insertRole(role);
			result = 1;
		}else{
			RoleEntity oldRole = roleService.getRoleById(id.intValue());
			oldRole.setUpdateTime(new Date());
			oldRole.setRoleName(role.getRoleName());
			oldRole.setRoleDesc(role.getRoleDesc());
			oldRole.setUpdateUser(user.getUserName());
			roleService.updateRole(oldRole);
			result = 2;
		}
		
		return result;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editRole(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/role/role_edit");
		RoleEntity role = null;
		if(StringUtils.isNotBlank(id)){
			role = roleService.getRoleById(Integer.parseInt(id));
		}
		
		mav.addObject("role", role);
		
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public void delete(String id, HttpServletRequest request){
		UserEntity user = UserUtils.getLoginUser(request);
		if(StringUtils.isNotBlank(id)){
			RoleEntity role = roleService.getRoleById(Integer.parseInt(id));
			role.setUpdateTime(new Date());
			role.setUpdateUser(user.getUserName());
			role.setIsDelete(1);
			roleService.updateRole(role);
		}
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	@ResponseBody
	public void start(String id, HttpServletRequest request){
		if(StringUtils.isNotBlank(id)){
			roleService.startRoleById(id);
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listRole(@ModelAttribute RoleQuery roleQuery, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/role/role_list");
		String roleName = roleQuery.getRoleName();
		if(StringUtils.isNotBlank(roleName)){
			roleQuery.setRoleName("%" + roleName + "%");
		}
		
		roleQuery = roleService.getRolePage(roleQuery);
		mav.addObject("roleQuery", roleQuery);
		
		return mav;
	}
}

