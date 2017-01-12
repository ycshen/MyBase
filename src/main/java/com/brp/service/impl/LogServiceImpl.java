package com.brp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.ConfigEntity;
import com.brp.entity.LogEntity;
import com.brp.mapper.ConfigMapper;
import com.brp.mapper.LogMapper;
import com.brp.service.ConfigService;
import com.brp.service.LogService;
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
@Service
public class LogServiceImpl implements LogService{
	@Autowired
	private LogMapper logMapper;

	@Override
	public void insertLog(LogEntity log) {
		logMapper.insertLog(log);
	}

	@Override
	public LogQuery getLogPage(LogQuery logQuery) {
		List<LogEntity> list = logMapper.getLogPage(logQuery);
		if(list != null && list.size() > 0){
			logQuery.setItems(list);
		}
		
		return logQuery;
	}
	
}

