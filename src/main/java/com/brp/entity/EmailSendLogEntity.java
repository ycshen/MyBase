package com.brp.entity;

import java.util.Date;

/**
 * <p>Project: MYBASE</p> 
 * <p>Title: EmailSendLogEntity.java</p>
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class EmailSendLogEntity {
	private String id;
	private String to; //发送给
	private String emailType; //邮件类型（注册邮件、激活邮件等等）
	private Integer isSuccess; //是否成功
	private Date sendTime; //发送时间
}

