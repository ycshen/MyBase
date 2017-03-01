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
import com.brp.entity.AuthorityEntity;
import com.brp.entity.AuthorityUserEntity;
import com.brp.service.AuthorityService;
import com.brp.service.AuthorityUserService;
import com.brp.service.CompanyService;
import com.brp.service.DepartmentService;
import com.brp.service.RoleService;
import com.brp.service.UserService;
import com.brp.util.JsonUtils;
import com.brp.util.SHA1Utils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.AuthorityVOQuery;
import com.brp.util.query.RoleVOQuery;
import com.brp.util.vo.AuthorityVO;
import com.brp.util.vo.RoleVO;
import com.brp.util.vo.UserAuthVO;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: AuthorityApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/api/role")
public class RoleApi {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private UserService userService;
	@Autowired
	private AuthorityService authService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private AuthorityUserService authUserService;
	@RequestMapping(value = "/getRolePage", method = RequestMethod.POST)
	@ResponseBody
	public String getRolePage(@RequestBody JSONObject jsonObject){
		JsonData<List<RoleVO>> jsonData = new JsonData<List<RoleVO>>();
		try{
			String query = jsonObject.getString("query");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("query", query);
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
			
			if(auth && StringUtils.isNotBlank(query)){
				RoleVOQuery roleQuery = JSONObject.parseObject(query, RoleVOQuery.class);
				Integer page = roleQuery.getPage();
				if(page == null){
					roleQuery.setPage(1);
				}
				
				Integer size = roleQuery.getSize();
				if(size == null){
					roleQuery.setSize(10);
				}
				
				roleQuery = roleService.getRoleVOPage(roleQuery);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(roleQuery.getItems());
				jsonData.setCount(roleQuery.getCount());
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
	
	@RequestMapping(value = "/getAuthById", method = RequestMethod.POST)
	@ResponseBody
	public String getAuthById(@RequestBody JSONObject jsonObject){
		JsonData<AuthorityEntity> jsonData = new JsonData<AuthorityEntity>();
		try{
			String id = jsonObject.getString("id");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("id", id);
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
			
			if(auth && StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){
				AuthorityEntity authority = authService.getAuthorityById(Integer.parseInt(id));
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(authority);
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
	
	@RequestMapping(value = "/insertAuth", method = RequestMethod.POST)
	@ResponseBody
	public String insertAuth(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String authUserJson = jsonObject.getString("authUserJson");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("authUserJson", authUserJson);
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
				List<AuthorityUserEntity> authoritys = JSONObject.parseArray(authUserJson, AuthorityUserEntity.class);
				if(authoritys != null && authoritys.size() > 0){
					for (AuthorityUserEntity authUser : authoritys) {
						authUserService.insertAuthorityUser(authUser);
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
	
	@RequestMapping(value = "/cancelAuth", method = RequestMethod.POST)
	@ResponseBody
	public String cancelAuth(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String authUserJson = jsonObject.getString("authUserJson");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("authUserJson", authUserJson);
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
				List<AuthorityUserEntity> authoritys = JSONObject.parseArray(authUserJson, AuthorityUserEntity.class);
				if(authoritys != null && authoritys.size() > 0){
					String idList = "";
					for (AuthorityUserEntity authUser : authoritys) {
						idList += authUser.getId() + ",";
					}
					
					if(StringUtils.isNotBlank(idList)){
						idList = idList.substring(0, idList.length() - 1);
					}
		
					if(StringUtils.isNotBlank(idList)){
						String companyId = authoritys.get(0).getCompanyId().toString();
						authUserService.cancelAuthority(idList, companyId);
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
	
	@RequestMapping(value = "/batchAuth", method = RequestMethod.POST)
	@ResponseBody
	public String batchAuth(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String companyId = jsonObject.getString("companyId");
			String authId = jsonObject.getString("authId");
			String authUserIdArray = jsonObject.getString("authUserIdArray");
			String notAuthUserIdArray = jsonObject.getString("notAuthUserIdArray");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("authId", authId);
				maps.put("companyId", companyId);
				maps.put("authUserIdArray", authUserIdArray);
				maps.put("notAuthUserIdArray", notAuthUserIdArray);
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
			
			if(auth && StringUtils.isNotBlank(authId)){
				if(StringUtils.isNotBlank(notAuthUserIdArray)){
					String[] notAuthArr = notAuthUserIdArray.split("\\^");
					String userIdArr = "";
					for (String notAuth : notAuthArr) {
						userIdArr += notAuth + ",";
					}
					
					if(StringUtils.isNotBlank(userIdArr)){
						userIdArr = userIdArr.substring(0, userIdArr.length() - 1);
					}
					
					authUserService.batchCancelAuth(userIdArr, companyId, authId);
				}
				
				if(StringUtils.isNotBlank(authUserIdArray)){
					String[] authArr = authUserIdArray.split("\\^");
					List<String> authUserIdList = new LinkedList<String>();
					for (String authUser : authArr) {
						authUserIdList.add(authUser);
					}

					List<UserAuthVO> list = userService.getAuthUserByCompanyIdAndAuthId(companyId, authId);
					if(list != null && list.size() > 0){
						for (UserAuthVO userAuthVO : list) {
							String userId = userAuthVO.getId().toString();
							if(authUserIdList.contains(userId)){
								authUserIdList.remove(userId);
							}
						}
					}
					
					for (String userId : authUserIdList) {
						AuthorityUserEntity authUser = new AuthorityUserEntity();
						authUser.setAuthId(Integer.parseInt(authId));
						authUser.setCompanyId(Integer.parseInt(companyId));
						authUser.setIsDelete(0);
						authUser.setUserId(Integer.parseInt(userId));
						authUserService.insertAuthorityUser(authUser);
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

