package com.brp.api;

import java.util.Date;
import java.util.HashMap;
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
import com.brp.base.VipLevel;
import com.brp.entity.CompanyEntity;
import com.brp.entity.ConfigEntity;
import com.brp.entity.MemoEntity;
import com.brp.entity.MemoEventEntity;
import com.brp.entity.UserEntity;
import com.brp.service.CompanyService;
import com.brp.service.ConfigService;
import com.brp.service.MemoEventService;
import com.brp.service.MemoService;
import com.brp.service.UserService;
import com.brp.util.JsonUtils;
import com.brp.util.SHA1Utils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.google.gson.Gson;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: UserApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/api/config")
public class ConfigApi {
	@Autowired
	private ConfigService configService;
	@Autowired
	private CompanyService companyService;
	@RequestMapping(value = "/getConfigListByCode", method = RequestMethod.POST)
	@ResponseBody
	public String getConfigListByCode(@RequestBody JSONObject jsonObject){
		JsonData<List<ConfigEntity>> jsonData = new JsonData<List<ConfigEntity>>();
		try{
			String code = jsonObject.getString("code");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("code", code);
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
			
			if(auth && StringUtils.isNotBlank(code)){
				List<ConfigEntity> list = configService.getConfigListByCode(code);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(list);
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

