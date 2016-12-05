package com.brp.base;
/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MenuEnum.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public enum MenuEnum {
	SYSTEM(0, "系统", "system"), 
	BUTTON(1, "按钮", "button"), 
	A(2, "<a>标签", "<a></a>"),
	URL(3, "链接", "url"),
	ONCLICK(4, "单击", "onclick"),
	DBCLICK(5, "双击", "dbclick");
	private Integer menuType; 
	private String menuTypeName;
	private String menuTypeTag;
	private MenuEnum(Integer menuType, String menuTypeName, String menuTypeTag)  
    {  
        this.menuType = menuType;  
        this.menuTypeName = menuTypeName;  
        this.menuTypeTag = menuTypeTag; 
    }
	public Integer getMenuType() {
		return menuType;
	}
	public String getMenuTypeName() {
		return menuTypeName;
	}
	public String getMenuTypeTag() {
		return menuTypeTag;
	}
	
	
}

