package com.brp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.ConfigEntity;
import com.brp.mapper.ConfigMapper;
import com.brp.service.ConfigService;
import com.brp.util.query.ConfigQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ConfigService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class ConfigServiceImpl implements ConfigService{
	@Autowired
	private ConfigMapper configMapper;
	@Override
	public void insertConfig(ConfigEntity config) {
		configMapper.insertConfig(config);
	}
	
	@Override
	public ConfigQuery getConfigList(ConfigQuery configQuery) {
		List<ConfigEntity> list = configMapper.getConfigPage(configQuery);
		if(list != null && list.size() > 0){
			configQuery.setItems(list);
		}
		
		return configQuery;
	}

	@Override
	public void updateConfig(ConfigEntity config) {
		configMapper.updateConfig(config);
	}

	@Override
	public ConfigEntity getConfigById(Integer id) {
		ConfigEntity Config = configMapper.getConfigById(id);
		
		return Config;
	}

	@Override
	public List<ConfigEntity> getConfigListByCode(String code) {
		List<ConfigEntity> list = configMapper.getConfigListByCode(code);
		
		return list;
	}

	@Override
	public void deleteConfigById(String id) {
		configMapper.deleteConfigById(id);
	}
}

