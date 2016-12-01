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

import com.brp.base.ResponseStatus;
import com.brp.entity.CompanyEntity;
import com.brp.entity.DepartmentEntity;
import com.brp.entity.UserEntity;
import com.brp.service.CompanyService;
import com.brp.service.DepartmentService;
import com.brp.service.UserService;
import com.brp.util.UserUtils;
import com.brp.util.query.DepartmentQuery;
import com.brp.util.query.UserQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: DepartmentController.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/inner/department")
public class DepartmentController extends BaseController{
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveOrUpdate(@ModelAttribute DepartmentEntity department, HttpServletRequest request){
		Integer result = ResponseStatus.INIT;
		String departmentName = department.getDepartmentName();
		Long companyId = department.getCompanyId();
		boolean isExist = departmentService.isExistDepartment(departmentName, companyId.toString());
		if(isExist){
			result = ResponseStatus.EXIST;
		}else{
			Long id = department.getId();
			UserEntity user = UserUtils.getLoginUser(request);
			if(id == null){
				department.setCreateTime(new Date());
				department.setStatus(0);
				department.setCreateUser(user.getUserName());
				departmentService.insertDepartment(department);
				result = ResponseStatus.INSERT_SUCCESS;
			}else{
				department.setUpdateTime(new Date());
				department.setUpdateUser(user.getUserName());
				departmentService.updateDepartment(department);
				result = ResponseStatus.UPDATE_SUCCESS;
			}
		}

		return result;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editDepartment(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/department/department_edit");
		DepartmentEntity department = null;
		if(StringUtils.isNotBlank(id)){
			department = departmentService.getDepartmentById(Integer.parseInt(id));
		}
		
		mav.addObject("department", department);
		
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addDepartment(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/department/department_add");
		CompanyEntity company = null;
		if(StringUtils.isNotBlank(id)){
			company = companyService.getCompanyById(Long.parseLong(id));
		}
		
		mav.addObject("company", company);
		
		return mav;
	}
	
	@RequestMapping(value = "/addSub", method = RequestMethod.GET)
	public ModelAndView addSubDepartment(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/department/department_add");
		if(StringUtils.isNotBlank(id)){
			DepartmentEntity department = departmentService.getDepartmentById(Integer.parseInt(id));
			CompanyEntity company = companyService.getCompanyById(department.getCompanyId());
			mav.addObject("company", company);
			mav.addObject("parentDepartment", department);
		}
		
		
		
		return mav;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewDepartment(String id, UserQuery userQuery, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/department/department_detail");
		DepartmentEntity department = null;
		if(StringUtils.isNotBlank(id)){
			department = departmentService.getDepartmentById(Integer.parseInt(id));
			userQuery.setDepartmentId(Integer.parseInt(id));
			userQuery = userService.getUserList(userQuery);
			
		}
		
		mav.addObject("department", department);
		mav.addObject("userQuery", userQuery);
		
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listDepartment(@ModelAttribute DepartmentQuery departmentQuery, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/department/department_list");
		departmentQuery = departmentService.getDepartmentList(departmentQuery);
		mav.addObject("departmentQuery", departmentQuery);
		
		return mav;
	}
}

