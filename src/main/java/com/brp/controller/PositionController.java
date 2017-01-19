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

import com.brp.base.Status;
import com.brp.base.enums.PositionEnum;
import com.brp.entity.ConfigEntity;
import com.brp.entity.PositionEntity;
import com.brp.entity.UserEntity;
import com.brp.service.ConfigService;
import com.brp.service.PositionService;
import com.brp.util.UserUtils;
import com.brp.util.query.ConfigQuery;
import com.brp.util.query.PositionQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ConfigController.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/inner/position")
public class PositionController extends BaseController{
	@Autowired
	private ConfigService configService;
	@Autowired
	private PositionService positionService;
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveOrUpdate(@ModelAttribute PositionEntity position, HttpServletRequest request){
		Integer result = 0;
		Long id = position.getId();
		UserEntity user = UserUtils.getLoginUser(request);
		if(id == null){
			position.setCreateTime(new Date());
			position.setCreateUser(user.getUserName());
			position.setPositionType(PositionEnum.SYSTEM_DEFINED.getPositionType());
			position.setIsDelete(Status.NORMAL);
			positionService.insertPosition(position);
			result = 1;
		}else{
			PositionEntity oldPosition = positionService.getPositionById(id.intValue());
			oldPosition.setUpdateTime(new Date());
			oldPosition.setUpdateUser(user.getUserName());
			oldPosition.setPostionName(position.getPostionName());
			positionService.updatePosition(oldPosition);
			result = 2;
		}
		
		return result;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editConfig(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/position/position_edit");
		PositionEntity position = null;
		if(StringUtils.isNotBlank(id)){
			position = positionService.getPositionById(Integer.parseInt(id));
		}
		
		mav.addObject("position", position);
		
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
	public ModelAndView listConfig(@ModelAttribute PositionQuery positionQuery, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/position/position_list");
		positionQuery.setPositionType(PositionEnum.SYSTEM_DEFINED.getPositionType());
		List<PositionEntity> list = positionService.getPositionList(positionQuery);
		mav.addObject("list", list);
		
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

