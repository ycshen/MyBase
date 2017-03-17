package com.brp.service.impl;

import com.brp.entity.EmailSendLogEntity;
import com.brp.entity.PositionEntity;
import com.brp.mapper.EmailSendLogMapper;
import com.brp.mapper.PositionMapper;
import com.brp.service.EmailSendLogService;
import com.brp.service.PositionService;
import com.brp.util.query.EmailSendLogQuery;
import com.brp.util.query.PositionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: EmailSendLogServiceImpl.java</p>
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2017 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class EmailSendLogServiceImpl implements EmailSendLogService{
	@Autowired
	private EmailSendLogMapper emailSendLogMapper;

	@Override
	public void insertEmailSendLog(EmailSendLogEntity emailSendLog) {
		emailSendLogMapper.insertEmailSendLog(emailSendLog);
	}

	@Override
	public EmailSendLogQuery getEmailSendLogPage(EmailSendLogQuery emailSendLogQuery) {
		List<EmailSendLogEntity> list = emailSendLogMapper.getEmailSendLogPage(emailSendLogQuery);
		if(list != null && list.size() > 0){
			emailSendLogQuery.setItems(list);
		}
		return emailSendLogQuery;
	}

	@Override
	public EmailSendLogEntity getEmailSendLogById(Integer id) {
		return emailSendLogMapper.getEmailSendLogById(id);
	}
}

