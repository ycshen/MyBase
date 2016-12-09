package com.brp.base;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** 
 * <p>Project: BRP</p> 
 * <p>Title: Constant.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Component
public class Constant {
	public static final String ZREO = "0";
	public static final String ONE = "1";
	public static final String TWO = "2";
	public static final String THREE = "3";
	public static final String FOUR = "4";
	public static final String RETURN_SUCCESS = "1";
	public static final String RETURN_EXISTCODE = "2";
	public static final String RETURN_EXISTNUM = "3";
	public static final String HK_CODE = "852";
	public static final String MO_CODE = "853";
	public static final Integer AREA_CODE_START = 10;
	public static final Integer AREA_CODE_END = 30;
	
	public static final String[] DIRECT_CONTROLLER_CODE = {"010", "021", "022", "023"}; //直辖市
	public static final String[] DIRECT_CONTROLLER_NAME = {"北京", "上海", "天津", "重庆"}; //直辖市
	public static final String CODE_200 = "200";
	/**
	 * 环境常量
	 */
	public static final String local = "local";
	public static final String test = "test";
	public static final String prod = "prod";
	
}

