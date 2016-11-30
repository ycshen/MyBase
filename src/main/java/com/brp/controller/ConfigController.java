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

import com.brp.entity.ConfigEntity;
import com.brp.entity.UserEntity;
import com.brp.service.ConfigService;
import com.brp.util.UserUtils;
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
@RequestMapping("/inner/config")
public class ConfigController extends BaseController{
	@Autowired
	private ConfigService configService;
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveOrUpdate(@ModelAttribute ConfigEntity config, HttpServletRequest request){
		Integer result = 0;
		Long id = config.getId();
		UserEntity user = UserUtils.getLoginUser(request);
		if(id == null){
			config.setCreateTime(new Date());
			config.setCreateUser(user.getUserName());
			configService.insertConfig(config);
			result = 1;
		}else{
			config.setUpdateTime(new Date());
			config.setUpdateUser(user.getUserName());
			configService.updateConfig(config);
			result = 2;
		}
		
		return result;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editConfig(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/config/config_edit");
		ConfigEntity config = null;
		if(StringUtils.isNotBlank(id)){
			config = configService.getConfigById(Integer.parseInt(id));
		}
		
		mav.addObject("config", config);
		
		return mav;
	}
	
	@RequestMapping(value = "/addSame", method = RequestMethod.GET)
	public ModelAndView addSameConfig(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/config/config_edit");
		ConfigEntity config = new ConfigEntity();
		if(StringUtils.isNotBlank(id)){
			ConfigEntity sameConfig = configService.getConfigById(Integer.parseInt(id));
			config.setCode(sameConfig.getCode());
			config.setRemark(sameConfig.getRemark());
		}
		
		mav.addObject("config", config);
		
		return mav;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewConfig(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/config/config_detail");
		ConfigEntity config = null;
		if(StringUtils.isNotBlank(id)){
			config = configService.getConfigById(Integer.parseInt(id));
		}
		
		mav.addObject("config", config);
		
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listConfig(@ModelAttribute ConfigQuery configQuery, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/config/config_list");
		configQuery = configService.getConfigList(configQuery);
		mav.addObject("configQuery", configQuery);
		
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public void delete(String id, HttpServletRequest request){
		UserEntity user = UserUtils.getLoginUser(request);
		if(StringUtils.isNotBlank(id)){
			ConfigEntity config = configService.getConfigById(Integer.parseInt(id));
			config.setUpdateTime(new Date());
			config.setUpdateUser(user.getUserName());
			config.setIsDelete(1);
			configService.updateConfig(config);
		}
	}
}

