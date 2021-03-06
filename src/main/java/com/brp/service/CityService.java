package com.brp.service;

import java.util.List;

import com.brp.entity.City;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ProvinceService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface CityService {
	void insertCity(City city);
	List<City> getCityListByProvinceId(String provinceId);
}

