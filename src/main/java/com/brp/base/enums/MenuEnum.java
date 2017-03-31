package com.brp.base.enums;

/**
 * <p>Project: MyBase</p> 
 * <p>Title: MenuEnum.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public enum MenuEnum {
	OUTER_SYSTEM(0, "外部系统", "outer-system"), 
	BUTTON(1, "按钮", "button"), 
	A(2, "a标签", "href"),
	URL(3, "菜单", "url"),
	ONCLICK(4, "单击", "onclick"),
	DBCLICK(5, "双击", "dbclick"),
	INNER_SYSTEM(6, "内部系统", "inner-system"),
	TOP_URL(8, "顶部菜单", "top-url"),
	SECOND_URL(7, "二级菜单", "second-url");
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
	
	public static String getMenuTypeName(Integer menuType) {
		for (MenuEnum menu : MenuEnum.values()) {
			if(menuType == menu.getMenuType()){
				return menu.getMenuTypeName();
			}
		}
		return null;
	}
	
	public static String getMenuTypeTag(Integer menuType) {
		for (MenuEnum menu : MenuEnum.values()) {
			if(menuType == menu.getMenuType()){
				return menu.getMenuTypeTag();
			}
		}

		return null;
	}
}

