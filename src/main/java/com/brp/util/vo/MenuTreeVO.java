package com.brp.util.vo;

import java.util.List;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MenuTreeVO.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class MenuTreeVO {
	private String id;  
	private String name;
	private String pid;
    private List<MenuTreeVO> children;
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
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public List<MenuTreeVO> getChildren() {
		return children;
	}
	public void setChildren(List<MenuTreeVO> children) {
		this.children = children;
	}
	
	
	
}

