package com.brp.entity;


/** 
 * <p>Project: MyBase</p> 
 * <p>Title: UserMenuEntity.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class MenuDefinedEntity extends BaseEntity{
	private Long menuId;
	private String cascadeId; //用户id or  部门id  or分公司id  or总部id
	private String cascadeType; //关联id类型（1-用户 2-部门 3-分公司 4-总部）
	private Integer status;
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public String getCascadeId() {
		return cascadeId;
	}
	public void setCascadeId(String cascadeId) {
		this.cascadeId = cascadeId;
	}
	public String getCascadeType() {
		return cascadeType;
	}
	public void setCascadeType(String cascadeType) {
		this.cascadeType = cascadeType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}

