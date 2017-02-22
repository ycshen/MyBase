package com.brp.util.vo;

import java.util.LinkedList;
import java.util.List;

/** 
 * <p>Project: BRP</p> 
 * <p>Title: ProvinceVO.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class ProvinceVO {
	private String provinceId;
	private String provinceName;
	private List<CityVO> cityList;
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public List<CityVO> getCityList() {
		return cityList;
	}
	public void setCityList(List<CityVO> cityList) {
		this.cityList = cityList;
	}
	
}

