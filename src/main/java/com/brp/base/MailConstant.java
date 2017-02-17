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
	public static final String REGISTER_CONTENT = "<div style=\"font: 14px 'Microsoft Yahei', Verdana, 宋体, sans-serif;\">尊敬的QJP_ACCOUNT,您好！<br/>"
			+ "感谢您注册企家婆(<a href=\"http://www.qijiapo.com\" target=\"_blank\">www.qijiapo.com</a>),企家婆专业致力于企业管理软件服务！<br/>"
			+ "企家婆旗下拥有企家婆客户关系管理（CRM)、进销存管理、财务管理、oa管理等各种企业管理软件，我们致力于为客户提供更好的企业管理服务。<br/>"
			+ "请妥善保管好你的账户信息!"
			+ "</div>";
	/**
	 * 分配用户企家婆发送邮件subject
	 */
	public static final String ASSIGN_SUBJECT = "QJP_COMPANYNAME为你分配企家婆账号(www.qijiapo.com),企家婆专业致力于企业管理软件服务";
	public static final String ASSIGN_CONTENT = "<div style=\"font: 14px 'Microsoft Yahei', Verdana, 宋体, sans-serif;\">尊敬的QJP_ACCOUNT,您好！<br/>"
			+ "感谢你加入QJP_COMPANYNAME，您的企家婆账号信息如下：<br/>"
			+ "登录账号：QJP_TELEPHONE 或者您的电子邮箱地址（QJP_EMAIL）<br/>"
			+ "初始化密码： QJP_PASS <br/>"
			+ "部门名称： QJP_DEPARTMENT <br/>"
			+ "请妥善保管好你的账户信息，不要将个人的账号信息透露给他人<br/>"
			+ "企家婆(<a href=\"http://www.qijiapo.com\" target=\"_blank\">www.qijiapo.com</a>),企家婆专业致力于企业管理软件服务！<br/>"
			+ "企家婆旗下拥有企家婆客户关系管理（CRM)、进销存管理、财务管理、oa管理等各种企业管理软件，我们致力于为客户提供更好的企业管理服务。<br/>"
			
			+ "</div>";
}

