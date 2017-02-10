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
import com.brp.entity.AuthorityEntity;
import com.brp.service.AuthorityService;
import com.brp.service.CompanyService;
import com.brp.service.DepartmentService;
import com.brp.service.UserService;
import com.brp.util.JsonUtils;
import com.brp.util.SHA1Utils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.AuthorityQuery;
import com.brp.util.query.AuthorityVOQuery;
import com.brp.util.vo.AuthorityVO;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: AuthorityApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/api/auth")
public class AuthorityApi {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private UserService userService;
	@Autowired
	private AuthorityService authService;
	 
	@RequestMapping(value = "/getAuthPage", method = RequestMethod.POST)
	@ResponseBody
	public String getAuthPage(@RequestBody JSONObject jsonObject){
		JsonData<List<AuthorityVO>> jsonData = new JsonData<List<AuthorityVO>>();
		try{
			String id = jsonObject.getString("id");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			String pageSize = jsonObject.getString("pageSize");
			String currentPage = jsonObject.getString("currentPage");
			String authName = jsonObject.getString("authName");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("id", id);
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				maps.put("pageSize", pageSize);
				maps.put("currentPage", currentPage);
				maps.put("authName", authName);
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
			
			if(auth && StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){
				AuthorityVOQuery authQuery = new AuthorityVOQuery();
				authQuery.setCompanyId(id);
				if(StringUtils.isBlank(currentPage)){
					currentPage = "1";
				}
				
				authQuery.setPage(Integer.parseInt(currentPage));
				if(StringUtils.isBlank(pageSize)){
					pageSize = "20";
				}
				
				authQuery.setSize(Integer.parseInt(pageSize));
				authQuery = authService.getAuthorityVOPage(authQuery);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(authQuery.getItems());
				jsonData.setCount(authQuery.getCount());
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

