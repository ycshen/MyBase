package com.brp.controller;

import com.brp.entity.EmailTemplateEntity;
import com.brp.service.EmailTemplateService;
import com.brp.util.MailUtils;
import com.brp.util.query.email.EmailTemplateQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author yuchuanshen
 * @Date Created by 2017/3/24
 * @Desc MyBase-com.brp.controller
 */
@Controller
@RequestMapping("/inner/emailTemplate")
public class EmailTemplateController {
	@Autowired
	private EmailTemplateService emailTemplateService;
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editDepartment(HttpServletRequest request, String id){
        ModelAndView mav = new ModelAndView("/email/email_template");
        EmailTemplateEntity emailTemplate = emailTemplateService.getEmailTemplateById(id);
        mav.addObject("emailTemplate", emailTemplate);
        return mav;
    }
    
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveOrUpdate(@ModelAttribute EmailTemplateEntity emailTemplate, HttpServletRequest request){
		Integer result = 0;
		try{
			Long id = emailTemplate.getId();
			if(id == null){
				emailTemplateService.insertEmailTemplate(emailTemplate);
				result = 1;
			}else{
				emailTemplateService.updateEmailTemplate(emailTemplate);
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
	public ModelAndView listConfig(@ModelAttribute EmailTemplateQuery emailTemplateQuery, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/email/email_template_list");
		emailTemplateQuery = emailTemplateService.getEmailTemplatePage(emailTemplateQuery);
		mav.addObject("emailTemplateQuery", emailTemplateQuery);
		
		return mav;
	}

	@RequestMapping(value = "/switchStatus", method = RequestMethod.GET)
	@ResponseBody
	public Integer switchStatus(String id, HttpServletRequest request){
		Integer result = -1;
		try{
			if(StringUtils.isNotBlank(id)){
				EmailTemplateEntity emailTemplate = emailTemplateService.getEmailTemplateById(id);
				Integer status = 0;
				if(emailTemplate != null && emailTemplate.getStatus() != null && emailTemplate.getStatus() == 1){
					status = 0;
				}else{
					status = 1;
				}

				emailTemplateService.switchStatus(id, status);

				result = status;
			}
		}catch(Exception e){
			//暂时不记录监控
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@RequestMapping(value = "/testEmail", method = RequestMethod.GET)
	@ResponseBody
	public Integer testEmail(String code, String email){
		Integer result = 0;
		try{
			if(StringUtils.isNotBlank(code)){
				MailUtils.sendRegisterEmail(email, "企家婆");
				result = 1;
			}
		}catch(Exception e){
			//暂时不记录监控
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@RequestMapping(value = "/getTemplateContent", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getTemplateContent(String id){
		String content = "";
		try{
			if(StringUtils.isNotBlank(id)){
				EmailTemplateEntity template = emailTemplateService.getEmailTemplateById(id);
				if(template != null){
					content = template.getTemplateContent();
				}
			}
		}catch(Exception e){
			//暂时不记录监控
			e.printStackTrace();
		}

		return content;
	}
}
