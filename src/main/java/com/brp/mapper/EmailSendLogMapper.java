package com.brp.mapper;

import com.brp.entity.EmailSendLogEntity;
import com.brp.util.query.EmailSendLogQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: EmailSendLogMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface EmailSendLogMapper {
	void insertEmailSendLog(EmailSendLogEntity emailSendLog);
	List<EmailSendLogEntity> getEmailSendLogPage(EmailSendLogQuery emailSendLogQuery);
	EmailSendLogEntity getEmailSendLogById(Integer id);
}

