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
import com.brp.entity.RoleEntity;
import com.brp.entity.RoleUserEntity;
import com.brp.service.CompanyService;
import com.brp.service.DepartmentService;
import com.brp.service.RoleService;
import com.brp.service.RoleUserService;
import com.brp.service.UserService;
import com.brp.util.JsonUtils;
import com.brp.util.SHA1Utils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.RoleVOQuery;
import com.brp.util.vo.RoleVO;
import com.brp.util.vo.UserRoleVO;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: RoleApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @roleor <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
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
	private RoleService roleService;
	@Autowired
	private RoleUserService roleUserService;
	@RequestMapping(value = "/getRolePage", method = RequestMethod.POST)
	@ResponseBody
	public String getRolePage(@RequestBody JSONObject jsonObject){
		JsonData<List<RoleVO>> jsonData = new JsonData<List<RoleVO>>();
		try{
			String query = jsonObject.getString("query");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean role = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("query", query);
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				String md5 = SHA1Utils.SHA1(maps);
				if(md5.equals(secret)){
					role = true;
				}else{
					jsonData.setCode(ApiCode.AUTH_FAIL);
					jsonData.setMessage("验证失败");
				}
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
			
			if(role && StringUtils.isNotBlank(query)){
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
	
	@RequestMapping(value = "/getRoleById", method = RequestMethod.POST)
	@ResponseBody
	public String getRoleById(@RequestBody JSONObject jsonObject){
		JsonData<RoleEntity> jsonData = new JsonData<RoleEntity>();
		try{
			String id = jsonObject.getString("id");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean role = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("id", id);
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				String md5 = SHA1Utils.SHA1(maps);
				if(md5.equals(secret)){
					role = true;
				}else{
					jsonData.setCode(ApiCode.AUTH_FAIL);
					jsonData.setMessage("验证失败");
				}
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
			
			if(role && StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Long.class)){
				RoleEntity roleority = roleService.getRoleById(Integer.parseInt(id));
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(roleority);
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
	
	@RequestMapping(value = "/insertRole", method = RequestMethod.POST)
	@ResponseBody
	public String insertRole(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String roleUserJson = jsonObject.getString("roleUserJson");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean role = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("roleUserJson", roleUserJson);
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				String md5 = SHA1Utils.SHA1(maps);
				if(md5.equals(secret)){
					role = true;
				}else{
					jsonData.setCode(ApiCode.AUTH_FAIL);
					jsonData.setMessage("验证失败");
				}
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
			
			if(role){
				List<RoleUserEntity> roleoritys = JSONObject.parseArray(roleUserJson, RoleUserEntity.class);
				if(roleoritys != null && roleoritys.size() > 0){
					for (RoleUserEntity roleUser : roleoritys) {
						roleUserService.insertRoleUser(roleUser);
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
	
	@RequestMapping(value = "/cancelRole", method = RequestMethod.POST)
	@ResponseBody
	public String cancelRole(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String roleUserJson = jsonObject.getString("roleUserJson");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean role = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("roleUserJson", roleUserJson);
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				String md5 = SHA1Utils.SHA1(maps);
				if(md5.equals(secret)){
					role = true;
				}else{
					jsonData.setCode(ApiCode.AUTH_FAIL);
					jsonData.setMessage("验证失败");
				}
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
			
			if(role){
				List<RoleUserEntity> roleoritys = JSONObject.parseArray(roleUserJson, RoleUserEntity.class);
				if(roleoritys != null && roleoritys.size() > 0){
					String idList = "";
					for (RoleUserEntity roleUser : roleoritys) {
						idList += roleUser.getId() + ",";
					}
					
					if(StringUtils.isNotBlank(idList)){
						idList = idList.substring(0, idList.length() - 1);
					}
		
					if(StringUtils.isNotBlank(idList)){
						String companyId = roleoritys.get(0).getCompanyId().toString();
						roleUserService.cancelRole(idList, companyId);
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
	
	@RequestMapping(value = "/batchRole", method = RequestMethod.POST)
	@ResponseBody
	public String batchRole(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String companyId = jsonObject.getString("companyId");
			String roleId = jsonObject.getString("roleId");
			String roleUserIdArray = jsonObject.getString("roleUserIdArray");
			String notRoleUserIdArray = jsonObject.getString("notRoleUserIdArray");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean role = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("roleId", roleId);
				maps.put("companyId", companyId);
				maps.put("roleUserIdArray", roleUserIdArray);
				maps.put("notRoleUserIdArray", notRoleUserIdArray);
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				String md5 = SHA1Utils.SHA1(maps);
				if(md5.equals(secret)){
					role = true;
				}else{
					jsonData.setCode(ApiCode.AUTH_FAIL);
					jsonData.setMessage("验证失败");
				}
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
			
			if(role && StringUtils.isNotBlank(roleId)){
				if(StringUtils.isNotBlank(notRoleUserIdArray)){
					String[] notRoleArr = notRoleUserIdArray.split("\\^");
					String userIdArr = "";
					for (String notRole : notRoleArr) {
						userIdArr += notRole + ",";
					}
					
					if(StringUtils.isNotBlank(userIdArr)){
						userIdArr = userIdArr.substring(0, userIdArr.length() - 1);
					}
					
					roleUserService.batchCancelRole(userIdArr, companyId, roleId);
				}
				
				if(StringUtils.isNotBlank(roleUserIdArray)){
					String[] roleArr = roleUserIdArray.split("\\^");
					List<String> roleUserIdList = new LinkedList<String>();
					for (String roleUser : roleArr) {
						roleUserIdList.add(roleUser);
					}

					List<UserRoleVO> list = userService.getRoleUserByCompanyIdAndRoleId(companyId, roleId);
					if(list != null && list.size() > 0){
						for (UserRoleVO userRoleVO : list) {
							String userId = userRoleVO.getId().toString();
							if(roleUserIdList.contains(userId)){
								roleUserIdList.remove(userId);
							}
						}
					}
					
					for (String userId : roleUserIdList) {
						RoleUserEntity roleUser = new RoleUserEntity();
						roleUser.setRoleId(Integer.parseInt(roleId));
						roleUser.setCompanyId(Integer.parseInt(companyId));
						roleUser.setIsDelete(0);
						roleUser.setUserId(Integer.parseInt(userId));
						roleUserService.insertRoleUser(roleUser);
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

