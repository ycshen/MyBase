package com.brp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.EmailConfigEntity;
import com.brp.mapper.EmailConfigMapper;
import com.brp.service.EmailConfigService;
import com.brp.util.query.EmailConfigQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: EmailSendLogServiceImpl.java</p>
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2017 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class EmailConfigServiceImpl implements EmailConfigService{
	@Autowired
	private EmailConfigMapper emailConfigMapper;

	@Override
	public void insertEmailConfig(EmailConfigEntity emailConfig) {
		emailConfigMapper.insertEmailConfig(emailConfig);
	}

	@Override
	public void updateEmailConfig(EmailConfigEntity emailConfig) {
		emailConfigMapper.updateEmailConfig(emailConfig);
	}

	@Override
	public EmailConfigEntity getEmailConfigById(String id) {
		return emailConfigMapper.getEmailConfigById(id);
	}

	@Override
	public EmailConfigQuery getEmailConfigPage(EmailConfigQuery emailConfigQuery) {
		List<EmailConfigEntity> list = emailConfigMapper.getEmailConfigPage(emailConfigQuery);
		emailConfigQuery.setItems(list);
		return emailConfigQuery;
	}

}

