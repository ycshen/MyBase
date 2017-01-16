package com.brp.api;

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
import com.brp.entity.CompanyEntity;
import com.brp.entity.UserEntity;
import com.brp.service.CompanyService;
import com.brp.service.UserService;
import com.brp.util.JsonUtils;
import com.brp.util.SHA1Utils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.CompanyQuery;
import com.brp.util.query.DepartmentQuery;
import com.brp.util.query.UserQuery;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		
		
		String result = JsonUtils.json2Str(jsonData);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String test(){
		return "test success";
	}
	
	@RequestMapping(value = "/getUserPage", method = RequestMethod.POST)
	@ResponseBody
	public String getUserPage(@RequestBody JSONObject jsonObject){
		JsonData<List<UserEntity>> jsonData = new JsonData<List<UserEntity>>();
		try{
			String companyId = jsonObject.getString("companyId");
			String departmentId = jsonObject.getString("departmentId");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			String pageSize = jsonObject.getString("pageSize");
			String currentPage = jsonObject.getString("currentPage");
			String status = jsonObject.getString("status");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("companyId", companyId);
				maps.put("departmentId", departmentId);
				maps.put("status", status);
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				maps.put("pageSize", pageSize);
				maps.put("currentPage", currentPage);
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
			
			if(auth && StringUtils.isNotBlank(companyId) && TryParseUtils.tryParse(companyId, Integer.class)){
				UserQuery userQuery = new UserQuery();
				userQuery.setCompanyId(companyId);
				if(StringUtils.isNotBlank(departmentId)){
					userQuery.setDepartmentId(departmentId);
				}
				
				if(StringUtils.isBlank(currentPage)){
					currentPage = "1";
				}
				
				userQuery.setPage(Integer.parseInt(currentPage));
				if(StringUtils.isBlank(pageSize)){
					pageSize = "20";
				}
				
				userQuery.setSize(Integer.parseInt(pageSize));
				userQuery.setStatus(Integer.parseInt(status));
				userQuery = userService.getUserList(userQuery);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(userQuery.getItems());
				jsonData.setCount(userQuery.getCount());
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

