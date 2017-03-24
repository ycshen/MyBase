package com.brp.mapper;

import com.brp.entity.EmailTemplateEntity;
import com.brp.util.query.email.EmailTemplateQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: EmailTemplateMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface EmailTemplateMapper {
	void insertEmailTemplate(EmailTemplateEntity emailTemplate);
	void updateEmailTemplate(EmailTemplateEntity emailTemplate);
	EmailTemplateEntity getEmailTemplateById(String id);
	List<EmailTemplateEntity> getEmailTemplatePage(EmailTemplateQuery emailTemplateQuery);
	void switchStatus(@Param("id") String id, @Param("status") Integer status);
	EmailTemplateEntity getEmailTemplateByCode(String code);
}

