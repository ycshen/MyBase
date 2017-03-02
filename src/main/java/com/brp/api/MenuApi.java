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
import com.brp.base.enums.MenuEnum;
import com.brp.entity.CompanyEntity;
import com.brp.entity.DepartmentEntity;
import com.brp.entity.MenuEntity;
import com.brp.entity.RoleEntity;
import com.brp.service.CompanyService;
import com.brp.service.MenuService;
import com.brp.util.JsonUtils;
import com.brp.util.SHA1Utils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.MenuQuery;
import com.brp.util.vo.BTreeVO;
import com.brp.util.vo.MenuTreeVO;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: CompanyApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/api/menu")
public class MenuApi {
	@Autowired
	private MenuService menuService;
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value = "/getMenus", method = RequestMethod.POST)
	@ResponseBody
	public String getMenus(@RequestBody JSONObject jsonObject){
		JsonData<List<MenuEntity>> jsonData = new JsonData<List<MenuEntity>>();
		try{
			String userId = jsonObject.getString("userId");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				maps.put("userId", userId);
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
			
			if(auth && StringUtils.isNotBlank(userId)){
				MenuQuery menuQuery = new MenuQuery();
				String menuType = MenuEnum.URL.getMenuType().toString() + "," +
						MenuEnum.SECOND_URL.getMenuType() + "," + 
						MenuEnum.TOP_URL.getMenuType();
				menuQuery.setMenuType(menuType);
				List<MenuEntity> list = menuService.getMenuList(menuQuery);
				jsonData.setCode(ApiCode.OK);
				jsonData.setData(list);
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
	
	@RequestMapping(value = "/getLoginMenus", method = RequestMethod.POST)
	@ResponseBody
	public String getLoginMenus(@RequestBody JSONObject jsonObject){
		JsonData<List<MenuEntity>> jsonData = new JsonData<List<MenuEntity>>();
		try{
			String definedType = jsonObject.getString("definedType");
			String companyId = jsonObject.getString("companyId");
			String definedCasecaseId = jsonObject.getString("definedCasecaseId");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				maps.put("definedType", definedType);
				maps.put("definedCasecaseId", definedCasecaseId);
				maps.put("companyId", companyId);
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
				String menuType = MenuEnum.URL.getMenuType().toString() + "," +
						MenuEnum.SECOND_URL.getMenuType() + "," + 
						MenuEnum.TOP_URL.getMenuType();
				List<MenuEntity> list = menuService.getLoginMenuList(definedType, menuType, companyId, definedCasecaseId);
				jsonData.setCode(ApiCode.OK);
				jsonData.setData(list);
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
	

	@RequestMapping(value = "/getOuterSystemPage", method = RequestMethod.POST)
	@ResponseBody
	public String getOuterSystemPage(@RequestBody JSONObject jsonObject){
		JsonData<MenuQuery> jsonData = new JsonData<MenuQuery>();
		try{
			String companyId = jsonObject.getString("companyId");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				maps.put("companyId", companyId);
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
				MenuQuery menuQuery = new MenuQuery();
				menuQuery.setMenuType(MenuEnum.OUTER_SYSTEM.getMenuType().toString());
				menuQuery = menuService.getMenuPage(menuQuery);
				
				jsonData.setCode(ApiCode.OK);
				jsonData.setData(menuQuery);
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
	 * 获取所有外部系统菜单
	 * @param jsonObject
	 * @return
	 */
	@RequestMapping(value = "/getAllOutterMenu", method = RequestMethod.POST)
	@ResponseBody
	public String getAllOutterMenu(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String definedType = jsonObject.getString("definedType");
			String casecadeId = jsonObject.getString("casecadeId");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("definedType", definedType);
				maps.put("casecadeId", casecadeId);
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
				String menuType = MenuEnum.OUTER_SYSTEM.getMenuType().toString();
				List<MenuEntity> list = menuService.getDefinedMenuList(definedType, menuType, casecadeId);
				MenuTreeVO menuTree = new MenuTreeVO();
				menuTree.setId("-1");
				menuTree.setName("企家婆(www.qijiapo.com)");
				menuTree.setChecked("true");
				List<MenuTreeVO> children = new LinkedList<MenuTreeVO>();
				if(list != null && list.size() > 0 ){
					for (MenuEntity menu : list) {
						MenuTreeVO menuTreeVO = new MenuTreeVO();
						String id = menu.getId().toString();
						String menuName = menu.getMenuName();
						Integer isDelete = menu.getIsDelete();
						if(isDelete != null && isDelete == 0){
							menuTreeVO.setChecked("true");
						}
						
						menuTreeVO.setId(id);
						menuTreeVO.setName(menuName);
						menuTreeVO.setPid("-1");
						menuTreeVO.setChildren(menuService.getMenuTreeByPid(id, definedType, casecadeId));
						children.add(menuTreeVO);
					}
				}
				
				menuTree.setChildren(children);
				String menuTreeJson = JsonUtils.json2Str(menuTree);
				jsonData.setCode(ApiCode.OK);
				jsonData.setData(menuTreeJson);
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

