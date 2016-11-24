package com.brp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brp.entity.CompanyEntity;
import com.brp.service.CompanyService;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: CompanyApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
public class CompanyApi {
	/*@Autowired
	private CompanyService companyService;
	@RequestMapping(value = "/addCompany", method = RequestMethod.GET)
	public void addCompany(@ModelAttribute CompanyEntity company){
		System.out.println("addCompany");
		company.setUpdateUser("aaa");
		companyService.insertCompany(company);
	}*/
}

