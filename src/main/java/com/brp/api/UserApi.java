package com.brp.api;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.brp.service.*;
import com.brp.util.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.brp.base.MailConstant;
import com.brp.base.UserStatus;
import com.brp.base.VipLevel;
import com.brp.base.enums.MenuEnum;
import com.brp.entity.AuthorityEntity;
import com.brp.entity.AuthorityUserEntity;
import com.brp.entity.CompanyEntity;
import com.brp.entity.DepartmentEntity;
import com.brp.entity.MenuDefinedEntity;
import com.brp.entity.MenuEntity;
import com.brp.entity.RoleEntity;
import com.brp.entity.RoleUserEntity;
import com.brp.entity.UserEntity;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.MenuQuery;
import com.brp.util.query.UserAuthQuery;
import com.brp.util.query.UserQuery;
import com.brp.util.query.UserRoleQuery;
import com.brp.util.vo.UserAuthVO;
import com.brp.util.vo.UserRoleVO;

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
	private MenuService menuService;
	@Autowired
	private MenuDefinedService mdService;
	@Autowired
	private UserService userService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private AuthorityUserService authUserService;
	@Autowired
	private RoleUserService roleUserService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private AuthorityService authService;
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
				password = SHA1Utils.getSecretPassword(password);
				UserEntity userInfo = userService.login(account, password);
				if(userInfo != null){
					jsonData.setCode(ApiCode.OK);
					jsonData.setMessage("登录成功");
					userInfo.setPassword(StringUtils.EMPTY);
					userInfo.setCreateTime(null);
					userInfo.setUpdateTime(null);
					String userId = userInfo.getId().toString();
					List<RoleEntity> roleList = roleService.getRoleListByUserId(userId);
					userInfo.setRoleList(roleList);
					List<AuthorityEntity> authList = authService.getAuthListByUserId(userId);
					userInfo.setAuthList(authList);
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
			String userName = jsonObject.getString("userName");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("companyId", companyId);
				maps.put("departmentId", departmentId);
				maps.put("userName", userName);
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
			
			if(auth){
				UserQuery userQuery = new UserQuery();
				userQuery.setCompanyId(companyId);
				if(StringUtils.isNotBlank(departmentId)){
					List<DepartmentEntity> deptList = departmentService.getDepartmentListByPidAndCid(departmentId, companyId);
					if(deptList != null && deptList.size() > 0){
						String deptStr = "";
						for (DepartmentEntity department : deptList) {
							deptStr += department.getId() + ",";
						}
						
						deptStr = deptStr.substring(0, deptStr.length() - 1);
						userQuery.setDepartmentId(deptStr);
					}else{
						userQuery.setDepartmentId(departmentId);
					}
					
				}
				
				if(StringUtils.isBlank(currentPage)){
					currentPage = "1";
				}
				
				userQuery.setPage(Integer.parseInt(currentPage));
				if(StringUtils.isBlank(pageSize)){
					pageSize = "20";
				}
				
				userQuery.setSize(Integer.parseInt(pageSize));
				if(StringUtils.isNotBlank(userName)){
					userQuery.setUserName("%" + userName +"%");
				}
				
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
	
	@RequestMapping(value = "/isExistTelephone", method = RequestMethod.POST)
	@ResponseBody
	public String isExistTelephone(@RequestBody JSONObject jsonObject){
		JsonData<Integer> jsonData = new JsonData<Integer>();
		try{
			String telephone = jsonObject.getString("telephone");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("telephone", telephone);
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
				
				
				Integer isExist = userService.isExistTelephone(telephone);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(isExist);
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
	
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	@ResponseBody
	public String insertUser(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String userJson = jsonObject.getString("userJson");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("userJson", userJson);
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
				UserEntity user = JSONObject.parseObject(userJson, UserEntity.class);
				user.setCreateTime(new Date());
				String initPass = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
				try{
					user.setPassword(SHA1Utils.getSecretPassword(initPass));
				}catch(Exception e){
					e.printStackTrace();
				}
				
				Long companyId = user.getCompanyId();
				CompanyEntity company = companyService.getCompanyById(companyId);
				if(company != null){
					user.setCompanyName(company.getCompanyName());
				}
				
				Integer departmentId = user.getDepartmentId();
				DepartmentEntity department = departmentService.getDepartmentById(departmentId);
				if(department != null){
					user.setDepartmentName(department.getDepartmentName());
				}
				
				user.setIsLoginMybase(0);
				user.setMenuDefinedType(4);
				userService.insertUser(user);
				String email = user.getEmail();
				if(StringUtils.isNotBlank(email)){
					this.sendAssignEmail(user, initPass);
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
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public String updateUser(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String userJson = jsonObject.getString("userJson");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("userJson", userJson);
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
				UserEntity user = JSONObject.parseObject(userJson, UserEntity.class);
				userService.updateUser(user);
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
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	@ResponseBody
	public String resetPassword(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String password = jsonObject.getString("password");
			String email = jsonObject.getString("email");
			String resetType = jsonObject.getString("resetType"); //1-输入密码 2-邮箱随机重置
			String id = jsonObject.getString("id");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("password", password);
				maps.put("resetType", resetType);
				maps.put("email", email);
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
			
			if(auth){
				UserEntity user = userService.getUserById(Integer.parseInt(id));
				if("2".equals(resetType)){
					//邮箱随机重置
					String initPassword = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
					password = SHA1Utils.getSecretPassword(initPassword);
					this.sendResetPassEmail(user.getUserName(), initPassword, email);
				}else if("1".equals(resetType)){
					//手动输入重置
					password = SHA1Utils.getSecretPassword(password);
				}

				user.setPassword(password);
				userService.updateUser(user);
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
	
	@RequestMapping(value = "/forbidUser", method = RequestMethod.POST)
	@ResponseBody
	public String forbidUser(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String id = jsonObject.getString("id");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			String updateUser = jsonObject.getString("updateUser");
			String status = jsonObject.getString("status");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("id", id);
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				maps.put("status", status);
				maps.put("updateUser", updateUser);
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
				UserEntity user = userService.getUserById(Integer.parseInt(id));
				//user.setStatus(UserStatus.FORBIDDEN_INT);
				user.setUpdateUser(updateUser);
				user.setUpdateTime(new Date());
				user.setStatus(Integer.parseInt(status));
				userService.updateUser(user);
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
	
	@RequestMapping(value = "/getUserById", method = RequestMethod.POST)
	@ResponseBody
	public String getUserById(@RequestBody JSONObject jsonObject){
		JsonData<UserEntity> jsonData = new JsonData<UserEntity>();
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
			
			if(auth){
				UserEntity user = userService.getUserById(Integer.parseInt(id));
				user.setPassword(StringUtils.EMPTY);
				jsonData.setData(user);
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
	
	@RequestMapping(value = "/getUserListByCompanyId", method = RequestMethod.POST)
	@ResponseBody
	public String getUserListByCompanyId(@RequestBody JSONObject jsonObject){
		JsonData<List<UserEntity>> jsonData = new JsonData<List<UserEntity>>();
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
			
			if(auth){
				List<UserEntity> userList = userService.getUserListByCompanyId(id);
				jsonData.setData(userList);
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
	
	
	@RequestMapping(value = "/changeCollapse", method = RequestMethod.POST)
	@ResponseBody
	public String changeCollapse(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String userId = jsonObject.getString("userId");
			String isCollapseMenu = jsonObject.getString("isCollapseMenu");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("userId", userId);
				maps.put("isCollapseMenu", isCollapseMenu);
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
				UserEntity user = userService.getUserById(Integer.parseInt(userId));
				if(user != null){
					Integer isCollapse = user.getIsCollapseMenu();
					if(isCollapse == 1){
						isCollapseMenu = "0";
					}else{
						isCollapseMenu = "1";
					}
				}
				
				userService.changeCollapse(userId, isCollapseMenu);
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
	@RequestMapping(value = "/getAuthUserByCidAndAuthId", method = RequestMethod.POST)
	@ResponseBody
	public String getAuthUserByCidAndAuthId(@RequestBody JSONObject jsonObject){
		JsonData<List<UserAuthVO>> jsonData = new JsonData<List<UserAuthVO>>();
		try{
			String companyId = jsonObject.getString("companyId");
			String isAuth = jsonObject.getString("isAuth");
			String authId = jsonObject.getString("authId");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("companyId", companyId);
				maps.put("authId", authId);
				maps.put("isAuth", isAuth);
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
				List<UserAuthVO> list = null;
				if("1".equals(isAuth)){
					list = userService.getAuthUserByCompanyIdAndAuthId(companyId, authId);
				}else if("2".equals(isAuth)){
					list = userService.getNotAuthUserByCompanyIdAndAuthId(companyId, authId);
				}else if("3".equals(isAuth)){
					list = userService.getUserByCompanyIdAndAuthId(companyId, authId);
				}

				jsonData.setData(list);
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
	
	
	@RequestMapping(value = "/getRoleUserByCidAndRoleId", method = RequestMethod.POST)
	@ResponseBody
	public String getRoleUserByCidAndRoleId(@RequestBody JSONObject jsonObject){
		JsonData<List<UserRoleVO>> jsonData = new JsonData<List<UserRoleVO>>();
		try{
			String companyId = jsonObject.getString("companyId");
			String isRole = jsonObject.getString("isRole");
			String roleId = jsonObject.getString("roleId");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("companyId", companyId);
				maps.put("roleId", roleId);
				maps.put("isRole", isRole);
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
				List<UserRoleVO> list = null;
				if("1".equals(isRole)){
					list = userService.getRoleUserByCompanyIdAndRoleId(companyId, roleId);
				}else if("2".equals(isRole)){
					list = userService.getNotRoleUserByCompanyIdAndRoleId(companyId, roleId);
				}else if("3".equals(isRole)){
					list = userService.getUserByCompanyIdAndRoleId(companyId, roleId);
				}

				jsonData.setData(list);
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
	
	@Autowired
	private MailSenderInfo mailSenderInfo;
	@RequestMapping(value = "/testEmail", method = RequestMethod.GET)
	public void testEmail(){
		mailSenderInfo.setSubject("aaa");
		mailSenderInfo.setContent("ceshi");
		SimpleMailSender.sendHtmlMail(mailSenderInfo);
	}
	
	@RequestMapping(value = "/getUserListByAuthId", method = RequestMethod.POST)
	@ResponseBody
	public String getUserListByAuthId(@RequestBody JSONObject jsonObject){
		JsonData<List<UserAuthVO>> jsonData = new JsonData<List<UserAuthVO>>();
		try{
			String companyId = jsonObject.getString("companyId");
			String authId = jsonObject.getString("authId");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			String pageSize = jsonObject.getString("pageSize");
			String currentPage = jsonObject.getString("currentPage");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("authId", authId);
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
			
			if(auth){
				UserAuthQuery userAuthQuery = new UserAuthQuery();
				userAuthQuery.setAuthId(authId);
				if(StringUtils.isBlank(currentPage)){
					currentPage = "1";
				}
				
				userAuthQuery.setPage(Integer.parseInt(currentPage));
				if(StringUtils.isBlank(pageSize)){
					pageSize = "5";
				}
				
				userAuthQuery.setCompanyId(companyId);
				userAuthQuery = userService.getUserListByAuthIdPage(userAuthQuery);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(userAuthQuery.getItems());
				jsonData.setCount(userAuthQuery.getCount());
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
	
	@RequestMapping(value = "/getUserListByRoleId", method = RequestMethod.POST)
	@ResponseBody
	public String getUserListByRoleId(@RequestBody JSONObject jsonObject){
		JsonData<List<UserRoleVO>> jsonData = new JsonData<List<UserRoleVO>>();
		try{
			String companyId = jsonObject.getString("companyId");
			String roleId = jsonObject.getString("roleId");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			String pageSize = jsonObject.getString("pageSize");
			String currentPage = jsonObject.getString("currentPage");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("roleId", roleId);
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
			
			if(auth){
				UserRoleQuery userRoleQuery = new UserRoleQuery();
				userRoleQuery.setRoleId(roleId);
				if(StringUtils.isBlank(currentPage)){
					currentPage = "1";
				}
				
				userRoleQuery.setPage(Integer.parseInt(currentPage));
				if(StringUtils.isBlank(pageSize)){
					pageSize = "5";
				}
				
				userRoleQuery.setCompanyId(companyId);
				userRoleQuery = userService.getUserListByRoleIdPage(userRoleQuery);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(userRoleQuery.getItems());
				jsonData.setCount(userRoleQuery.getCount());
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
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String register(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String userJson = jsonObject.getString("userJson");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("userJson", userJson);
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
				UserEntity user = JSONObject.parseObject(userJson, UserEntity.class);
				if(user != null){
					String companyName = user.getCompanyName();
					String telephone = user.getTelphone();
					if(StringUtils.isNotBlank(companyName) && StringUtils.isNotBlank(telephone)){
						CompanyEntity company = new CompanyEntity();
						company.setCompanyName(companyName);
						company.setCompanyTelephone(telephone);
						company.setCreateTime(new Date());
						company.setLevel(VipLevel.VIP);
						company.setStatus(0);
						companyService.insertCompany(company);
						Long companyId = company.getId();
						user.setCompanyId(companyId);
						//首次注册用户 部门id默认为公司id的负数，以便区分
						user.setDepartmentId(0 - company.getId().intValue());
						user.setCreateUser("企家婆注册");
						user.setStatus(UserStatus.NORMAL_INT);
						user.setCreateTime(new Date());
						user.setIsLoginMybase(0);
						try{
							user.setPassword(SHA1Utils.getSecretPassword(user.getPassword()));
						}catch(Exception e){
							e.printStackTrace();
						}
						user.setIsLoginMybase(0);
						user.setMenuDefinedType(4);
						user.setIsCollapseMenu(0);
						userService.insertUser(user);
						
						MenuQuery menuQuery = new MenuQuery();
						String menuType = MenuEnum.URL.getMenuType().toString() + "," +
								MenuEnum.SECOND_URL.getMenuType() + "," + 
								MenuEnum.TOP_URL.getMenuType();
						menuQuery.setMenuType(menuType);
						List<MenuEntity> list = menuService.getMenuList(menuQuery);
						if(list != null && list.size() > 0){
							MenuDefinedEntity md = null;
							for (MenuEntity menu : list) {
								md = new MenuDefinedEntity();
								md.setCompanyId(user.getCompanyId().toString());
								md.setCreateTime(new Date());
								md.setCreateUser(user.getUserName());
								//为系统管理员，暂定为1
								md.setDefinedCasecaseId("1");
								md.setDefinedType(4);
								md.setIsDelete(0);
								md.setMenuId(menu.getId().toString());
								md.setParentMenuId(menu.getParentMenuId());
								mdService.insertMenuDefined(md);
							}
							
						}
						
						AuthorityUserEntity authUser = new AuthorityUserEntity();
						authUser.setAuthId(1);
						authUser.setCompanyId(user.getCompanyId().intValue());
						authUser.setIsDelete(0);
						authUser.setUserId(user.getId().intValue());
						authUserService.insertAuthorityUser(authUser);
						
						RoleUserEntity roleUser = new RoleUserEntity();
						roleUser.setRoleId(1);
						roleUser.setCompanyId(user.getCompanyId().intValue());
						roleUser.setIsDelete(0);
						roleUser.setUserId(user.getId().intValue());
						roleUserService.insertRoleUser(roleUser);
						String email = user.getEmail();
						if(StringUtils.isNotBlank(email)){
							this.sendRegisterEmail(user.getUserName(), email);
						}
						
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

	/**
	 * 发送注册邮件
	 * @param registerAccount 注册账号
	 * @return
	 */
	private boolean sendRegisterEmail(String registerAccount, String email){
		try {
			MailUtils.sendRegisterEmail(registerAccount, email);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
	
	/**
	 * 发送分配员工邮件
	 * @param registerAccount 注册账号
	 * @return
	 */
	private boolean sendAssignEmail(UserEntity user, String initPass){
		SimpleMailSender sms = new SimpleMailSender();
		String content = MailConstant.ASSIGN_CONTENT.replaceAll("QJP_ACCOUNT", user.getUserName());
		content = content.replaceAll("QJP_COMPANYNAME", user.getCompanyName());
		content = content.replaceAll("QJP_TELEPHONE", user.getTelphone());
		content = content.replaceAll("QJP_EMAIL", user.getEmail());
		content = content.replaceAll("QJP_PASS", initPass);
		content = content.replaceAll("QJP_DEPARTMENT", user.getDepartmentName());
		
		mailSenderInfo.setContent(content);
		String subject = MailConstant.ASSIGN_SUBJECT.replaceAll("QJP_COMPANYNAME", user.getCompanyName());
		mailSenderInfo.setSubject(subject);
		mailSenderInfo.setToAddress(user.getEmail());
		boolean isSend = sms.sendHtmlMail(mailSenderInfo);
		
		return isSend;
	}
	
	/**
	 * 发送分配员工邮件
	 * @param registerAccount 注册账号
	 * @return
	 */
	private boolean sendResetPassEmail(String account, String initPass, String email){
		SimpleMailSender sms = new SimpleMailSender();
		String content = MailConstant.RESETPASS_CONTENT.replaceAll("QJP_ACCOUNT", account);
		content = content.replaceAll("QJP_PASS", initPass);
		
		mailSenderInfo.setContent(content);
		mailSenderInfo.setSubject(MailConstant.RESETPASS_SUBJECT);
		mailSenderInfo.setToAddress(email);
		boolean isSend = sms.sendHtmlMail(mailSenderInfo);
		
		return isSend;
	}
	public static void main(String[] args) {
		String pass = "";
		try {
			pass = SHA1Utils.getSecretPassword("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pass);
	}
}

