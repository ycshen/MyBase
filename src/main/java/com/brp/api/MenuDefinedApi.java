package com.brp.api;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.brp.base.Constant;
import com.brp.base.Status;
import com.brp.base.VipLevel;
import com.brp.entity.CompanyEntity;
import com.brp.entity.DepartmentEntity;
import com.brp.entity.MenuDefinedEntity;
import com.brp.entity.OrganizationEntity;
import com.brp.entity.UserEntity;
import com.brp.service.CompanyService;
import com.brp.service.DepartmentService;
import com.brp.service.MenuDefinedService;
import com.brp.service.OrganzationService;
import com.brp.service.UserService;
import com.brp.util.JsonUtils;
import com.brp.util.SHA1Utils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.CompanyQuery;
import com.brp.util.query.UserQuery;
import com.brp.util.vo.BTreeVO;
import com.google.gson.Gson;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MenuDefinedApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/api/menuDefined")
public class MenuDefinedApi {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private MenuDefinedService mdService;

	
	@RequestMapping(value = "/insertMenuDefined", method = RequestMethod.POST)
	@ResponseBody
	public String insertMenuDefined(@RequestBody JSONObject jsonObject){
		JsonData<Long> jsonData = new JsonData<Long>();
		try{
			String mdJson = jsonObject.getString("mdJson");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("mdJson", mdJson);
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
				List<MenuDefinedEntity> mdList = JSONObject.parseArray(mdJson, MenuDefinedEntity.class);
				if(mdList != null && mdList.size() > 0){
					for (MenuDefinedEntity menuDefined : mdList) {
						menuDefined.setCreateTime(new Date());
						mdService.insertMenuDefined(menuDefined);
					}
				}
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
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

