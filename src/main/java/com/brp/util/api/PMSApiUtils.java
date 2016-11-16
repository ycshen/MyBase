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
		if(CommonUtils.getProdEnv()){
			return Constant.PMS_PROD;
		}else {
			return Constant.PMS_TEST ;
		}
	}
	
	/**
	 * 获取所有省份
	 * @return
	 */
	public static String getAllProvince(){
		String url = getPMSUrl() + Constant.PMS_GET_PROVINCE;
		String result = HttpUtils.get(url);
		
		return result;
	}
	
	/**
	 * 根据大区id获取所有省份
	 * @return
	 */
	public static String getProvinceByDictrictId(String id){
		String districtUrl = Constant.PMS_GET_PROVINCE_DISTRICT;
		if(StringUtils.isNotBlank(districtUrl)){
			districtUrl = districtUrl.replace("REPLACE_ID", id);
		}
		
		String url = getPMSUrl() + districtUrl;
		String result = HttpUtils.get(url);
		
		return result;
	}
	
	/**
	 * 获取所有的大区
	 * @return
	 */
	public static String getAllDistrict(){
		String url = getPMSUrl() + Constant.PMS_DISTRICT;
		String result = HttpUtils.get(url);
		
		return result;
	}

	/**
	 * 根据省份id获取城市
	 * @param id
	 * @return
	 */
	public static String getCityByProvinceId(String id){
		String districtUrl = Constant.PMS_GETCITY_PROVINCEID;
		if(StringUtils.isNotBlank(districtUrl)){
			districtUrl = districtUrl.replace("REPLACE_ID", id);
		}
		
		String url = getPMSUrl() + districtUrl;
		String result = HttpUtils.get(url);
		
		return result;
	}
	
	/**
	 * 根据城市id获取区县
	 * @param id
	 * @return
	 */
	public static String getAreaByCityId(String id){
		String districtUrl = Constant.PMS_GETAREA_CITYID;
		if(StringUtils.isNotBlank(districtUrl)){
			districtUrl = districtUrl.replace("REPLACE_ID", id);
		}
		
		String url = getPMSUrl() + districtUrl;
		String result = HttpUtils.get(url);
		
		return result;
	}
	
	/**
	 * 获取省市区级联字符串
	 * @return
	 */
	public static String getCasecadeAddress(){
		String url = getPMSUrl() + Constant.PMS_DISTRICT_TREE;
		String result = HttpUtils.get(url);
		
		return result;
	}
	
	/**
	 * 获取省市区
	 * @return
	 */
	public static String getDistrictList(){
		String url = getPMSUrl() + Constant.PMS_ALLDISTRICT;
		String result = HttpUtils.get(url);
		
		return result;
	}
	
	/**
	 * 获取子类型部门信息接口
	 * @param type (多个值以逗号分开 eg: 1,2,3)
	 * @return
	 */
	public static String getSubDepartmentInfo(String type, String areaId){
		String subUrl = Constant.PMS_SUBTYPE;
		if(StringUtils.isNotBlank(subUrl)){
			subUrl = subUrl.replace("REPLCACE_TYPE", type);
			if(StringUtils.isNotBlank(areaId)){
				subUrl = subUrl.replace("REPLCACE_AREAID", areaId);
			}else{
				subUrl = subUrl.replace("/REPLCACE_AREAID", "");
			}
		}
		
		
		String url = getPMSUrl() + subUrl;
		String result = HttpUtils.get(url);
		
		return result;
	}
	
	/**
	 * 根据类型获取部门信息接口
	 * @param type
	 * @return
	 */
	public static String getDepartmentInfo(String type, String areaId){
		String subUrl = Constant.PMS_DEPTYPE;
		if(StringUtils.isNotBlank(subUrl)){
			subUrl = subUrl.replace("REPLCACE_TYPE", type);
			if(StringUtils.isNotBlank(areaId)){
				subUrl = subUrl.replace("REPLCACE_AREAID", areaId);
			}else{
				subUrl = subUrl.replace("/REPLCACE_AREAID", "");
			}
		}
		
		String url = getPMSUrl() + subUrl;
		System.out.println(url);
		String result = HttpUtils.get(url);
		
		return result;
	}

    /**
     * 查询面单是否存在
     * @param startNum
     * @param endNum
     * @return
     */
    public static String queryBillNumExist(String startNum,String endNum){
        String subUrl = Constant.DPS_PROD+Constant.DPS_GETBILLNO;
        String url=subUrl+"?startno="+startNum+"&endno="+endNum;
        String result = HttpUtils.get(url);
        return result;
    }


	/**
	 * 查询用户信息ID
	 * @param token
	 * @return
	 */
	public static String getUserId(String token){
		String  url = com.brp.entity.Constant.MICRO_USRER_TEST_URL;
		if(CommonUtils.getProdEnv()){
			url =com.brp.entity.Constant.MICRO_USRER_SERVER_URL;
		}
		String result = HttpUtils.get(url+token);
		return result;
	}


	/**
	 * 查询用户信息
	 * @param userId
	 * @return
	 */
	public static String queryUserInfo(String userId){
		String url=getPMSUrl()+"/employee/"+userId+"/employee";
		String result = HttpUtils.get(url);
		return result;
	}

	/**
	 * 验证URL
	 * @param url
	 * @return
	 */
	public static String checkURL(String url){
		String realURL=getPMSUrl()+url;
		String result = HttpUtils.get(realURL);
		return result;
	}
	
	public static String getAllBigArea(String token){
		String url = getPMSUrl() + Constant.PMS_GETALLBIGAREA;
		url = url.replace("TOKEN", token);
		String result = HttpUtils.get(url);
		
		return result;
	}

	public static String getBrpUserInfo(String userId, String token){
		String url = getPMSUrl() + Constant.PMS_BRMEMPLOYEE;
		url = url.replace("TOKEN", token).replace("ID", userId);
		String result = HttpUtils.get(url);
		
		return result;
	}
	
	/**
	 * 本地环境才能使用！！！！！！！！！
	 */
	public static String getLocalToken(){
		String token = "本地环境才能使用！！！！！！！！！！！！！！！！！！！！！！！！";
		//本地环境才能使用
		if(CommonUtils.getLocalEnv()){
			String url = "http://micro.wltest.com/open/oauth2/token";
			String data = "{\"client_id\": \"brp\",\"client_secret\": \"173b3704-ecd9-4ca2-8c43-53b4635105c9\","
					+ "\"grant_type\": \"credential\","
							+ "\"scope\": \"scope\"}";
			String result = HttpUtils.postUrl(url, data);
			JSONObject jsonObj = JSONObject.parseObject(result);
			if(jsonObj != null){
				token = jsonObj.getString("access_token");
			}
				
		}
		
		return token;
	}

}

