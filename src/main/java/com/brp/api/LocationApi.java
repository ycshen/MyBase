package com.brp.api;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.Area;
import com.brp.entity.City;
import com.brp.entity.ConstantEntity;
import com.brp.entity.Province;
import com.brp.service.AreaService;
import com.brp.service.CityService;
import com.brp.service.CompanyService;
import com.brp.service.ConstantService;
import com.brp.service.ProvinceService;
import com.brp.util.JsonUtils;
import com.brp.util.SHA1Utils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.vo.AreaVO;
import com.brp.util.vo.CityVO;
import com.brp.util.vo.ProvinceVO;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: UserApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/api/location")
public class LocationApi {
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private CityService cityService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private ConstantService constantService;
	@RequestMapping(value = "/getProCityArea", method = RequestMethod.POST)
	@ResponseBody
	public String getProCityArea(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				String md5 = SHA1Utils.SHA1(maps);
				if(md5.equals(secret)){
					auth = true;
				}else{
					jsonData.setCode(ApiCode.AUTH_FAIL);
					jsonData.setMessage("验证失败");
				}
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
			
			if(auth){
				String pcaStr = StringUtils.EMPTY;
				String code = "PROVINCE_CITY_AREA";
				ConstantEntity constant = constantService.getConstantByCode(code);
				if(constant != null){
					pcaStr = constant.getConstant();
				}else{
					List<ProvinceVO> list = new LinkedList<ProvinceVO>();
					List<Province> provinceList = provinceService.getAllProvince();
					if(provinceList != null && provinceList.size() > 0){
						for (Province province : provinceList) {
							ProvinceVO provinceVO = new ProvinceVO();
							String provinceId = province.getProvinceId();
							String provinceName = province.getProvinceName();
							provinceVO.setProvinceId(provinceId);
							provinceVO.setProvinceName(provinceName);
							List<City> cityList = cityService.getCityListByProvinceId(provinceId);
							if(cityList != null && cityList.size() > 0){
								List<CityVO> cityVOlist = new LinkedList<CityVO>();
								for (City city : cityList) {
									CityVO cityVO = new CityVO();
									String cityId = city.getCityId();
									String cityName = city.getCityName();
									cityVO.setCityId(cityId);
									cityVO.setCityName(cityName);
									List<Area> areaList = areaService.getAreaListByCityId(cityId);
									if(areaList != null && areaList.size() > 0){
										List<AreaVO> areaVOList = new LinkedList<AreaVO>();
										for (Area area : areaList) {
											AreaVO areaVO = new AreaVO();
											areaVO.setAreaId(area.getAreaId());
											areaVO.setAreaName(area.getAreaName());
											areaVOList.add(areaVO);
										}
										
										cityVO.setAreaList(areaVOList);
									}
									
									cityVOlist.add(cityVO);
								} 
								
								provinceVO.setCityList(cityVOlist);
							}
							
							list.add(provinceVO);
						}
						
						constant = new ConstantEntity();
						pcaStr = JsonUtils.json2Str(list);
						constant.setCode(code);
						constant.setConstant(pcaStr);
						constantService.insertConstant(constant);
					}
				}
				
				
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(pcaStr);
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
		}catch(Exception e){
			e.printStackTrace();
			jsonData.setCode(ApiCode.EXCEPTION);
			jsonData.setMessage("操作失败");
		}
		
		String result = JsonUtils.json2Str(jsonData);
		
		return result;
	}
}

