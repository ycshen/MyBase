package com.brp.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.brp.entity.ConfigEntity;
import com.brp.util.query.ConfigQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ConfigMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface ConfigMapper {
	void insertConfig(ConfigEntity config);
	List<ConfigEntity> getConfigPage(ConfigQuery ConfigQuery);
	void updateConfig(ConfigEntity Config);
	ConfigEntity getConfigById(Integer id);
	List<ConfigEntity> getConfigListByCode(String code);
	void deleteConfigById(String id);
}

