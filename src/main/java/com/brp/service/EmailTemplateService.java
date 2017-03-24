package com.brp.service;

import com.brp.entity.EmailTemplateEntity;
import com.brp.util.query.email.EmailTemplateQuery;

/**
 * @Author yuchuanshen
 * @Date Created by 2017/3/17
 * @Desc MyBase-com.brp.service
 */
public interface EmailTemplateService {
	void insertEmailTemplate(EmailTemplateEntity emailTemplate);
	void updateEmailTemplate(EmailTemplateEntity emailTemplate);
	EmailTemplateEntity getEmailTemplateById(String id);
	EmailTemplateQuery getEmailTemplatePage(EmailTemplateQuery emailTemplateQuery);
	void switchStatus(String id, Integer status);
}
