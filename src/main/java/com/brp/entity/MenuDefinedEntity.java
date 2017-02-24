package com.brp.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/** 
 * <p>Project: MyBase</p> 
 * <p>Title: UserEntity.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class MenuDefinedEntity extends BaseEntity{
	private String companyId;  //公司id
	private String definedCasecaseId; //定义id 用户id  职位id 部门id   角色id
	private Integer definedType;  //定义类型  1-按照用户定义 2-按照职位定义  3-按照部门定义 4-按照角色定义
	private String menuId; //菜单id
	private Long parentMenuId;  //父菜单id
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getDefinedCasecaseId() {
		return definedCasecaseId;
	}
	public void setDefinedCasecaseId(String definedCasecaseId) {
		this.definedCasecaseId = definedCasecaseId;
	}
	public Integer getDefinedType() {
		return definedType;
	}
	public void setDefinedType(Integer definedType) {
		this.definedType = definedType;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public Long getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(Long parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
}

