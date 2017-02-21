package com.brp.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.brp.entity.Area;
import com.brp.entity.City;
import com.brp.entity.Province;
import com.brp.service.AreaService;
import com.brp.service.CityService;
import com.brp.service.ProvinceService;
import com.brp.util.HttpUtils;
import com.google.gson.Gson;

/** 
 * <p>Project: BRP</p> 
 * <p>Title: TestController.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
public class TestController {
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private CityService cityService;
	@Autowired
	private AreaService areaService;
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(){
		System.out.println("aaaaaa");
	}
	
	@RequestMapping(value = "/initArea", method = RequestMethod.GET)
	public void initArea() throws Exception{
		String html = HttpUtils.get("http://zhengjinfan.cn/js/area.js");
		byte[] utf = html.getBytes("iso8859-1");  
		String s1 = new String(utf, "utf-8");
		String jsonStr = s1.split("\\=")[1];
		jsonStr = jsonStr.substring(0, jsonStr.length() - 1);
		JSONArray jsonArr = JSONObject.parseArray(jsonStr);
		for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			String provinceCode= jsonObj.get("provinceCode").toString();
			String provinceName= jsonObj.get("provinceName").toString();
			Province province = new Province();
			province.setProvinceId(provinceCode);
			province.setProvinceName(provinceName);
			provinceService.insertProvince(province);
			String mallCityList= jsonObj.get("mallCityList").toString();
			JSONArray jsonArrCity = JSONObject.parseArray(mallCityList);
			for (int j = 0; j < jsonArrCity.size(); j++) {
				JSONObject jsonObjCity = jsonArrCity.getJSONObject(j);
				String cityCode= jsonObjCity.get("cityCode").toString();
				String cityName= jsonObjCity.get("cityName").toString();
				City city = new City();
				city.setCityId(cityCode);
				city.setCityName(cityName);
				city.setProvinceId(provinceCode);
				cityService.insertCity(city);
				Object areaListObj = jsonObjCity.get("mallAreaList");
				if(areaListObj != null){
					String mallAreaList= jsonObjCity.get("mallAreaList").toString();
					JSONArray jsonArrArea = JSONObject.parseArray(mallAreaList);
					for (int k = 0; k < jsonArrArea.size(); k++) {
						JSONObject jsonObjArea = jsonArrArea.getJSONObject(k);
						String areaCode= jsonObjArea.get("areaCode").toString();
						String areaName= jsonObjArea.get("areaName").toString();
						Area area = new Area();
						area.setAreaId(areaCode);
						area.setAreaName(areaName);
						area.setCityId(cityCode);
						areaService.insertArea(area);
					}
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String html = HttpUtils.get("http://zhengjinfan.cn/js/area.js");
		byte[] utf = html.getBytes("iso8859-1");  
		String s1 = new String(utf, "utf-8");
		String jsonStr = s1.split("\\=")[1];
		jsonStr = jsonStr.substring(0, jsonStr.length() - 1);
		JSONArray jsonArr = JSONObject.parseArray(jsonStr);
		for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			String provinceCode= jsonObj.get("provinceCode").toString();
			String provinceName= jsonObj.get("provinceName").toString();
			//System.out.println(provinceCode + "-" + provinceName);
			String mallCityList= jsonObj.get("mallCityList").toString();
			JSONArray jsonArrCity = JSONObject.parseArray(mallCityList);
			for (int j = 0; j < jsonArrCity.size(); j++) {
				JSONObject jsonObjCity = jsonArrCity.getJSONObject(j);
				String cityCode= jsonObjCity.get("cityCode").toString();
				String cityName= jsonObjCity.get("cityName").toString();
				Object areaListObj = jsonObjCity.get("mallAreaList");
				if(areaListObj != null){
					String mallAreaList= jsonObjCity.get("mallAreaList").toString();
					JSONArray jsonArrArea = JSONObject.parseArray(mallAreaList);
					for (int k = 0; k < jsonArrArea.size(); k++) {
						JSONObject jsonObjArea = jsonArrArea.getJSONObject(k);
						String areaCode= jsonObjArea.get("areaCode").toString();
						String areaName= jsonObjArea.get("areaName").toString();
						System.out.println(provinceName + "-" + cityCode + "-" + cityName + "-" + areaCode + "-" + areaName);
					}
				}
				
			}
		}
	}
}

