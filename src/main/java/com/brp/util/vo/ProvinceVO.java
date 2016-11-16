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
	private String id;
	private String name;
	private List<CityVO> sub;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CityVO> getSub() {
		return sub;
	}
	public void setSub(List<CityVO> sub) {
		this.sub = sub;
	}
}

