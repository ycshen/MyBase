package com.brp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.brp.base.VipLevel;
import com.brp.entity.CompanyEntity;
import com.brp.entity.ConfigEntity;
import com.brp.entity.Constant;
import com.brp.entity.UserEntity;
import com.brp.service.CompanyService;
import com.brp.service.ConfigService;
import com.brp.util.UserUtils;
import com.brp.util.query.CompanyQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: CompanyController.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/inner/company")
public class CompanyController extends BaseController{
	@Autowired
	private CompanyService companyService;
	@Autowired
	private ConfigService configService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listCompany(@ModelAttribute CompanyQuery companyQuery){
		ModelAndView mav = new ModelAndView("/company/company_list");
		companyQuery = companyService.getCompanyList(companyQuery);
		mav.addObject("companyQuery", companyQuery);
		List<ConfigEntity> configList = configService.getConfigListByCode(Constant.VIPCODE);
		mav.addObject("configList", configList);
		
		return mav;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editCompany(String id){
		ModelAndView mav = new ModelAndView("/company/company_edit");
		CompanyEntity company = null;
		if(StringUtils.isNotBlank(id)){
			Long companyId = Long.parseLong(id);
			company = companyService.getCompanyById(companyId);
		}
		mav.addObject("company", company);
		
		return mav;
	}
	
	@RequestMapping(value = "/addSub", method = RequestMethod.GET)
	public ModelAndView addSubCompany(String id){
		ModelAndView mav = new ModelAndView("/company/company_addsub");
		CompanyEntity company = null;
		if(StringUtils.isNotBlank(id)){
			Long companyId = Long.parseLong(id);
			company = companyService.getCompanyById(companyId);
		}
		mav.addObject("company", company);
		
		return mav;
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveOrUpdateCompany(@ModelAttribute CompanyEntity company, HttpServletRequest request){
		Integer result = 0;
		try{
			Long id = company.getId();
			UserEntity user = UserUtils.getLoginUser(request);
			if(id == null){
				company.setCreateTime(new Date());
				company.setCreateUser(user.getUserName());
				company.setLevel(VipLevel.VIP);				
				companyService.insertCompany(company);
				result = 1;
			}else{
				company.setUpdateUser(user.getUserName());
				company.setUpdateTime(new Date());
				companyService.updateCompany(company);
				result = 2;
			}
		}catch(Exception e){
			//暂时不记录监控
			e.printStackTrace();
			result = 0;
		}
		
		return result;
	}
}

