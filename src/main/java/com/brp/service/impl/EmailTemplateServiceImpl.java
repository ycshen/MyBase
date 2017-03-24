package com.brp.service.impl;

import com.brp.entity.EmailTemplateEntity;
import com.brp.mapper.EmailTemplateMapper;
import com.brp.service.EmailTemplateService;
import com.brp.util.query.email.EmailTemplateQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: EmailTemplateServiceImpl.java</p>
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2017 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class EmailTemplateServiceImpl implements EmailTemplateService{
	@Autowired
	private EmailTemplateMapper emailTemplateMapper;

	@Override
	public void insertEmailTemplate(EmailTemplateEntity emailTemplate) {
		emailTemplateMapper.insertEmailTemplate(emailTemplate);
	}

	@Override
	public void updateEmailTemplate(EmailTemplateEntity emailTemplate) {
		emailTemplateMapper.updateEmailTemplate(emailTemplate);
	}

	@Override
	public EmailTemplateEntity getEmailTemplateById(String id) {
		return emailTemplateMapper.getEmailTemplateById(id);
	}

	@Override
	public EmailTemplateQuery getEmailTemplatePage(EmailTemplateQuery emailTemplateQuery) {
		List<EmailTemplateEntity> list = emailTemplateMapper.getEmailTemplatePage(emailTemplateQuery);
		emailTemplateQuery.setItems(list);
		return emailTemplateQuery;
	}

	@Override
	public void switchStatus(String id, Integer status) {
		emailTemplateMapper.switchStatus(id, status);
	}

}

