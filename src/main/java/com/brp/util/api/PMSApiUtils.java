package com.brp.util.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.util.ConfigUtils;
import com.brp.util.PropertiesUtils;

import org.apache.commons.lang3.StringUtils;

import com.brp.base.Constant;
import com.brp.util.CommonUtils;
import com.brp.util.HttpUtils;

import java.io.IOException;
import java.util.Properties;

/** 
 * <p>Project: BRP</p> 
 * <p>Title: PMSApiUtils.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class PMSApiUtils {
	/**
	 * 获取pms地址
	 * @return
	 */
	private static String getPMSUrl(){
		return "";
		/*if(CommonUtils.getProdEnv()){
			return Constant.PMS_PROD;
		}else {
			return Constant.PMS_TEST ;
		}*/
	}
	

}

