package com.brp.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.brp.entity.LogEntity;
import com.brp.util.query.LogQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: LogMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface LogMapper {
	void insertLog(LogEntity log);
	List<LogEntity> getLogPage(LogQuery logQuery);
}

