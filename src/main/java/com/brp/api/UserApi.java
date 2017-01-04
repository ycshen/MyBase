package com.brp.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.UserEntity;
import com.brp.service.CompanyService;
import com.brp.service.UserService;
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
@RequestMapping("/api/user")
public class UserApi {
	@Autowired
	private UserService userService;
	@Autowired
	private CompanyService companyService;
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody JSONObject jsonObject){
		JsonData<UserEntity> jsonData = new JsonData<UserEntity>();
		try{
			String account = jsonObject.getString("account");
			String password = jsonObject.getString("password");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("account", account);
				maps.put("password", password);
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				String md5 = SHA1Utils.SHA1(maps);
				if(md5.equals(secret)){
					auth = true;
				}else{
					jsonData.setCode(ApiCode.AUTH_FAIL);
					jsonData.setMessage("登录失败");
				}
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("登录参数异常");
			}
			
			if(auth && StringUtils.isNotBlank(account) && StringUtils.isNotBlank(password)){
				UserEntity userInfo = userService.login(account, password);
				if(userInfo != null){
					jsonData.setCode(ApiCode.OK);
					jsonData.setMessage("登录成功");
					userInfo.setPassword(StringUtils.EMPTY);
					userInfo.setCreateTime(null);
					userInfo.setUpdateTime(null);
					jsonData.setData(userInfo);
				}else{
					jsonData.setCode(ApiCode.SUCCESS);
					jsonData.setMessage("登录失败");
				}
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("登录参数异常");
			}
		}catch(Exception e){
			e.printStackTrace();
			jsonData.setCode(ApiCode.EXCEPTION);
			jsonData.setMessage("登录失败");
		}
		
		String result = new Gson().toJson(jsonData);
		
		return result;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String test(){
		return "test success";
	}
}

