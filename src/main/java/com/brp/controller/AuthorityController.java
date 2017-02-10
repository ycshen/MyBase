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
import com.brp.entity.AuthorityEntity;
import com.brp.entity.UserEntity;
import com.brp.service.AuthorityService;
import com.brp.util.UserUtils;
import com.brp.util.query.AuthorityQuery;
import com.brp.util.query.ConfigQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ConfigController.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/inner/authority")
public class AuthorityController extends BaseController{

	@Autowired
	private AuthorityService authorityService;
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveOrUpdate(@ModelAttribute AuthorityEntity authority, HttpServletRequest request){
		Integer result = 0;
		Long id = authority.getId();
		UserEntity user = UserUtils.getLoginUser(request);
		if(id == null){
			authority.setCreateTime(new Date());
			authority.setCreateUser(user.getUserName());
			authority.setIsDelete(Status.NORMAL);
			authorityService.insertAuthority(authority);
			result = 1;
		}else{
			AuthorityEntity oldAuthority = authorityService.getAuthorityById(id.intValue());
			oldAuthority.setUpdateTime(new Date());
			oldAuthority.setAuthName(authority.getAuthName());
			oldAuthority.setAuthDesc(authority.getAuthDesc());
			oldAuthority.setUpdateUser(user.getUserName());
			authorityService.updateAuthority(oldAuthority);
			result = 2;
		}
		
		return result;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editAuthority(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/authority/authority_edit");
		AuthorityEntity auth = null;
		if(StringUtils.isNotBlank(id)){
			auth = authorityService.getAuthorityById(Integer.parseInt(id));
		}
		
		mav.addObject("auth", auth);
		
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public void delete(String id, HttpServletRequest request){
		UserEntity user = UserUtils.getLoginUser(request);
		if(StringUtils.isNotBlank(id)){
			AuthorityEntity authority = authorityService.getAuthorityById(Integer.parseInt(id));
			authority.setUpdateTime(new Date());
			authority.setUpdateUser(user.getUserName());
			authority.setIsDelete(1);
			authorityService.updateAuthority(authority);
		}
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	@ResponseBody
	public void start(String id, HttpServletRequest request){
		if(StringUtils.isNotBlank(id)){
			authorityService.startAuthorityById(id);
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAuthority(@ModelAttribute AuthorityQuery authorityQuery, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/authority/authority_list");
		String authName = authorityQuery.getAuthName();
		if(StringUtils.isNotBlank(authName)){
			authorityQuery.setAuthName("%" + authName + "%");
		}
		
		authorityQuery = authorityService.getAuthorityPage(authorityQuery);
		mav.addObject("authorityQuery", authorityQuery);
		
		return mav;
	}
}

