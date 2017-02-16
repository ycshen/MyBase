package com.brp.base;

import org.springframework.stereotype.Component;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MailConstant.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Component
public class MailConstant {
	/**
	 * 用户注册企家婆发送邮件subject
	 */
	public static final String REGISTER_SUBJECT = "感谢您注册企家婆(www.qijiapo.com),企家婆专业致力于企业管理软件服务";
	public static final String REGISTER_CONTENT = "<div style=\"font: 14px 'Microsoft Yahei', Verdana, 宋体, sans-serif;\">尊敬的${account},您好！<br/>"
			+ "感谢您注册企家婆(<a href=\"http://www.qijiapo.com\" target=\"_blank\">www.qijiapo.com</a>),企家婆专业致力于企业管理软件服务！<br/>"
			+ "企家婆旗下拥有企家婆客户关系管理（CRM)、进销存管理、财务管理、oa管理等各种企业管理软件，我们致力于为客户提供更好的企业管理服务。<br/>"
			+ "请妥善保管好你的账户信息(登录账号：${account})!"
			+ "</div>";
}

