package com.brp.controller;

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

import com.brp.entity.EmailConfigEntity;
import com.brp.service.EmailConfigService;
import com.brp.util.query.ConfigQuery;
import com.brp.util.query.DepartmentQuery;
import com.brp.util.query.EmailConfigQuery;

/**
 * @Author yuchuanshen
 * @Date Created by 2017/3/17
 * @Desc MyBase-com.brp.controller
 */
@Controller
@RequestMapping("/inner/emailConfig")
public class EmailConfigController {
	@Autowired
	private EmailConfigService emailConfigService;
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editDepartment(HttpServletRequest request, String id){
        ModelAndView mav = new ModelAndView("/email/email_config");
        EmailConfigEntity emailConfig = emailConfigService.getEmailConfigById(id);
        mav.addObject("emailConfig", emailConfig);
        return mav;
    }
    
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveOrUpdate(@ModelAttribute EmailConfigEntity emailConfig, HttpServletRequest request){
		Integer result = 0;
		try{
			String id = emailConfig.getId();
			if(StringUtils.isBlank(id)){
				id = UUID.randomUUID().toString().replace("-", "");
				emailConfig.setId(id);
				emailConfigService.insertEmailConfig(emailConfig);
				result = 1;
			}else{
				emailConfigService.updateEmailConfig(emailConfig);
				result = 2;
			}
		}catch(Exception e){
			//暂时不记录监控
			e.printStackTrace();
			result = 0;
		}
		
		return result;
	}
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listConfig(@ModelAttribute EmailConfigQuery emailconfigQuery, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/email/email_config_list");
		emailconfigQuery = emailConfigService.getEmailConfigPage(emailconfigQuery);
		mav.addObject("emailconfigQuery", emailconfigQuery);
		
		return mav;
	}

	@RequestMapping(value = "/switchStatus", method = RequestMethod.GET)
	@ResponseBody
	public Integer switchStatus(String id, HttpServletRequest request){
		Integer result = -1;
		try{
			if(StringUtils.isNotBlank(id)){
				EmailConfigEntity emailConfig = emailConfigService.getEmailConfigById(id);
				Integer status = 0;
				if(emailConfig != null && emailConfig.getStatus() != null && emailConfig.getStatus() == 1){
					status = 0;
				}else{
					status = 1;
				}

				emailConfigService.switchStatus(id, status);

				result = status;
			}
		}catch(Exception e){
			//暂时不记录监控
			e.printStackTrace();
			result = -1;
		}

		return result;
	}
}
