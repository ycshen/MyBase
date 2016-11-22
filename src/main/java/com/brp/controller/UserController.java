package com.brp.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.brp.entity.DepartmentEntity;
import com.brp.entity.UserEntity;
import com.brp.service.DepartmentService;
import com.brp.service.UserService;
import com.brp.util.UserUtils;
import com.brp.util.query.UserQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: UserController.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/inner/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveOrUpdate(@ModelAttribute UserEntity user, HttpServletRequest request){
		Integer result = 0;
		Long id = user.getId();
		UserEntity loginUser = UserUtils.getLoginUser(request);
		if(id == null){
			user.setCreateTime(new Date());
			user.setCreateUser(loginUser.getUserName());
			String initPass = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
			user.setPassword(initPass);
			userService.insertUser(user);
			result = 1;
		}else{
			user.setUpdateTime(new Date());
			user.setUpdateUser(loginUser.getUserName());
			userService.updateUser(user);
			result = 2;
		}
		
		return result;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/user/user_edit");
		UserEntity user = null;
		if(StringUtils.isNotBlank(id)){
			user = userService.getUserById(Integer.parseInt(id));
		}
		
		mav.addObject("user", user);
		
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addUser(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		DepartmentEntity department = null;
		if(StringUtils.isNotBlank(id)){
			mav.setViewName("/user/user_add");
			department = departmentService.getDepartmentById(Integer.parseInt(id));
			mav.addObject("department", department);
		}else{
			mav.setViewName("/user/user_edit");
			UserEntity loginUser = UserUtils.getLoginUser(request);
			Long companyId = loginUser.getCompanyId();
			List<DepartmentEntity> departmentList = departmentService.getListByCompanyId(companyId.toString());
			mav.addObject("departmentList", departmentList);
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewUser(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/user/user_detail");
		UserEntity user = null;
		if(StringUtils.isNotBlank(id)){
			user = userService.getUserById(Integer.parseInt(id));
		}
		
		mav.addObject("user", user);
		
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listUser(@ModelAttribute UserQuery userQuery, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/user/user_list");
		userQuery = userService.getUserList(userQuery);
		mav.addObject("userQuery", userQuery);
		
		return mav;
	}
}

