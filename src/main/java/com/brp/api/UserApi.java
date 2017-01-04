package com.brp.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.brp.entity.UserEntity;
import com.brp.service.UserService;
import com.brp.util.SHA1Utils;
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
@RequestMapping("api/user")
public class UserApi {
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(JSONObject jsonObject){
		JsonData<UserEntity> jsonData = new JsonData<UserEntity>();
		try{
			String account = jsonObject.getString("account");
			String password = jsonObject.getString("password");
			String secret = jsonObject.getString("secret");
			if(StringUtils.isNotBlank(account) && StringUtils.isNotBlank(password) && StringUtils.isNotBlank(secret)){
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("account", account);
				maps.put("password", password);
				maps.put("", secret);
				String baseSecret = SHA1Utils.SHA1(maps);
				System.out.println(baseSecret);
				System.out.println(secret);
				if(baseSecret.equals(secret)){
					UserEntity userInfo = userService.login(account, password);
					if(userInfo != null){
						jsonData.setCode(ApiCode.OK);
						jsonData.setMessage("登录成功");
						userInfo.setPassword(StringUtils.EMPTY);
						jsonData.setData(userInfo);
					}else{
						jsonData.setCode(ApiCode.SUCCESS);
						jsonData.setMessage("登录失败");
					}
				}else{
					jsonData.setCode(ApiCode.AUTH_FAIL);
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
}

