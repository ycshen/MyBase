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
	private Integer nodeId;
	private Integer id;
	private String text;
	private String parentId;
    private List<MenuTreeVO> nodes;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<MenuTreeVO> getNodes() {
		return nodes;
	}
	public void setNodes(List<MenuTreeVO> nodes) {
		this.nodes = nodes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	
}

