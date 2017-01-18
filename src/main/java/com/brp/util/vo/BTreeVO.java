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
public class BTreeVO {
	private String id;  //id_type_pid eg: 1_2_n  1_n_n 2_2_995 //type:1 公司 2.分公司 3.部门 4.用户 5. 菜单  n:空  pid: n为空
	private String name;
	private String pid;
    private List<BTreeVO> children;
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
	public List<BTreeVO> getChildren() {
		return children;
	}
	public void setChildren(List<BTreeVO> children) {
		this.children = children;
	}
	
	
	
}

