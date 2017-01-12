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
import com.brp.entity.LogEntity;
import com.brp.service.CompanyService;
import com.brp.service.LogService;
import com.brp.util.DateUtils;
import com.brp.util.JsonUtils;
import com.brp.util.SHA1Utils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.LogQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: CompanyApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/api/log")
public class LogApi {
	@Autowired
	private LogService logService;
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value = "/log", method = RequestMethod.POST)
	@ResponseBody
	public String log(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String logJson = jsonObject.getString("logJson");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("logJson", logJson);
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
				LogEntity log = JSONObject.parseObject(logJson, LogEntity.class);
				String logId = DateUtils.getDateStr(new Date(), "yyyyMMddHHmmss") + SHA1Utils.getSecret();
				log.setId(logId);
				log.setCreateTime(new Date());
				logService.insertLog(log);
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
	
	@RequestMapping(value = "/getAdminLogs", method = RequestMethod.POST)
	@ResponseBody
	public String getAdminLogs(@RequestBody JSONObject jsonObject){
		JsonData<List<LogEntity>> jsonData = new JsonData<List<LogEntity>>();
		try{
			String companyId = jsonObject.getString("companyId");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			String pageSize = jsonObject.getString("pageSize");
			String currentPage = jsonObject.getString("currentPage");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("companyId", companyId);
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
			
			if(auth && StringUtils.isNotBlank(companyId)){
				LogQuery logQuery = new LogQuery();
				if(StringUtils.isBlank(currentPage)){
					currentPage = "1";
				}

				logQuery.setPage(Integer.parseInt(currentPage));
				if(StringUtils.isBlank(pageSize)){
					pageSize = "20";
				}
				
				logQuery.setSize(Integer.parseInt(pageSize));
				logQuery.setCompanyId(companyId);
				logQuery = logService.getLogPage(logQuery);
				jsonData.setCode(ApiCode.OK);
				jsonData.setCount(logQuery.getCount());
				jsonData.setData(logQuery.getItems());
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

