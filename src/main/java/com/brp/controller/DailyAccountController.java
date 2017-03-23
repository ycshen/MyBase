package com.brp.controller;

import com.brp.base.Status;
import com.brp.entity.DailyAccountEntity;
import com.brp.entity.UserEntity;
import com.brp.service.DailyAccountService;
import com.brp.util.UserUtils;
import com.brp.util.query.DailyAccountQuery;
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
import java.util.List;
import java.util.UUID;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ConfigController.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/inner/dailyAccount")
public class DailyAccountController extends BaseController{
	@Autowired
	private DailyAccountService dailyAccountService;
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveOrUpdate(@ModelAttribute DailyAccountEntity dailyAccount, HttpServletRequest request){
		Integer result = 0;
		String id = dailyAccount.getId();
		UserEntity user = UserUtils.getLoginUser(request);
		if(StringUtils.isBlank(id)){
			id = UUID.randomUUID().toString().replace("-", "");
			dailyAccount.setId(id);
			dailyAccount.setAddTime(new Date());
			dailyAccount.setIsDelete(Status.NORMAL);
			dailyAccountService.insertDailyAccount(dailyAccount);
			result = 1;
		}else{
			DailyAccountEntity oldDailyAccount = dailyAccountService.getDailyAccountById(id);
			
			dailyAccountService.updateDailyAccount(oldDailyAccount);
			result = 2;
		}
		
		return result;
	}

	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/dailyAccount/dailyAccount_detail");
		DailyAccountEntity dailyAccount = null;
		if(StringUtils.isNotBlank(id)){
			dailyAccount = dailyAccountService.getDailyAccountById(id);
		}
		
		mav.addObject("dailyAccount", dailyAccount);
		
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@ModelAttribute DailyAccountQuery dailyAccountQuery, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/dailyAccount/dailyAccount_list");
		List<DailyAccountEntity> list = dailyAccountService.getDailyAccountList(dailyAccountQuery);
		mav.addObject("list", list);
		
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public void delete(String id, HttpServletRequest request){
		if(StringUtils.isNotBlank(id)){
			dailyAccountService.deleteDailyAccountById(id);
		}
	}
}

