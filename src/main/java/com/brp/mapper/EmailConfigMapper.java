package com.brp.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.brp.entity.EmailConfigEntity;
import com.brp.util.query.EmailConfigQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: EmailConfigMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface EmailConfigMapper {
	void insertEmailConfig(EmailConfigEntity emailConfig);
	void updateEmailConfig(EmailConfigEntity emailConfig);
	EmailConfigEntity getEmailConfigById(String id);
	List<EmailConfigEntity> getEmailConfigPage(EmailConfigQuery emailConfigQuery);
}

