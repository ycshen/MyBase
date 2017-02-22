package com.brp.util.vo;

import java.util.LinkedList;
import java.util.List;

/** 
 * <p>Project: BRP</p> 
 * <p>Title: CityVO.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class CityVO {
	private String cityId;
	private String cityName;
	private List<AreaVO> areaList;
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<AreaVO> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<AreaVO> areaList) {
		this.areaList = areaList;
	}	
	
	
}

