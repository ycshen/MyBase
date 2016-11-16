/** * CommonUtils.java 
* Created on 2015年7月20日 上午11:22:10 
*/

package com.brp.util;

import java.io.IOException;
import java.util.Properties;

import com.brp.base.Constant;

/** 
 * <p>Project: BRP</p> 
 * <p>Title: CommonUtils.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class CommonUtils {
	
	/**
	 * 本地环境
	 * @return
	 * @throws IOException
	 */
	public static Boolean getLocalEnv() {
		Boolean isLocal = false;
		Properties prop = null;
		try {
			prop = PropertiesUtils.readConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String env = (String) prop.get("env");
		if (Constant.local.equals(env)) {
			isLocal = true;
		}
		
		return isLocal;
	}
	
	/**
	 * 测试环境
	 * @return
	 * @throws IOException
	 */
	public static Boolean getTestEnv() {
		Boolean isTest = false;
		Properties prop = null;
		try {
			prop = PropertiesUtils.readConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String env = (String) prop.get("env");
		if (Constant.test.equals(env)) {
			isTest = true;
		}
		
		return isTest;
	}
	
	/**
	 * 生产环境
	 * @return
	 * @throws IOException
	 */
	public static Boolean getProdEnv() {
		Boolean isProd = false;
		Properties prop = null;
		try {
			prop = PropertiesUtils.readConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String env = (String) prop.get("env");
		if (Constant.prod.equals(env)) {
			isProd = true;
		}
		
		return isProd;
	}
}
