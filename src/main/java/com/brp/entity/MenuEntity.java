package com.brp.entity;
/** 
 * <p>Project: MyBase</p> 
 * <p>Title: UserEntity.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class MenuEntity extends BaseEntity{
	private String menuName;
	private Integer menuType; 
	private String menuTypeName;
	private String menuTypeTag;
	private String menuUrl;
	private String parentMenuId;
	private String beyondOfSystem; //所属系统
	private String beyondOfSystemId; //所属系统
	private Integer isDelete;
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Integer getMenuType() {
		return menuType;
	}
	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}
	public String getMenuTypeName() {
		return menuTypeName;
	}
	public void setMenuTypeName(String menuTypeName) {
		this.menuTypeName = menuTypeName;
	}
	public String getMenuTypeTag() {
		return menuTypeTag;
	}
	public void setMenuTypeTag(String menuTypeTag) {
		this.menuTypeTag = menuTypeTag;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(String parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	public String getBeyondOfSystem() {
		return beyondOfSystem;
	}
	public void setBeyondOfSystem(String beyondOfSystem) {
		this.beyondOfSystem = beyondOfSystem;
	}
	
	public String getBeyondOfSystemId() {
		return beyondOfSystemId;
	}
	public void setBeyondOfSystemId(String beyondOfSystemId) {
		this.beyondOfSystemId = beyondOfSystemId;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
}

