package com.brp.base;
/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ResponseStatus.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class ResponseStatus {
	/**
	 * 初始化成功
	 */
	public static final Integer INIT = 1;
	/**
	 * 插入成功
	 */
	public static final Integer INSERT_SUCCESS = 1;
	/**
	 * 更新成功
	 */
	public static final Integer UPDATE_SUCCESS = 2;
	
	/**
	 * 操作异常
	 */
	public static final Integer ERROR = 3;
	/**
	 * 已存在
	 */
	public static final Integer EXIST = 4;
	
}

