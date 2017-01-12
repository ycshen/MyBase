package com.brp.service;

import java.util.List;

import com.brp.entity.ConfigEntity;
import com.brp.entity.LogEntity;
import com.brp.util.query.ConfigQuery;
import com.brp.util.query.LogQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ConfigService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface LogService {
	void insertLog(LogEntity log);
	LogQuery getLogPage(LogQuery logQuery);
}

