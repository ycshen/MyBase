package com.brp.util;
/** 
 * <p>Project: MyBase</p> 
 * <p>Title: TryParseUtils.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class TryParseUtils {
	public static boolean tryParse(Object value, Class clazz){
		boolean result = false;
		try{
			String className = clazz.getName();
			System.out.println(className);
			if("java.lang.Integer".equals(className)){
				Integer.parseInt(value.toString());
				result = true;
			}else if("java.lang.Long".equals(className)){
				Long.parseLong(value.toString());
				result = true;
			}else{
				result = false;
			}
			
			
		}catch(Exception e){
			result = false;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		tryParse(1, Long.class);
	}
	
}

