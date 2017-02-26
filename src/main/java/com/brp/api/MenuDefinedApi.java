package com.brp.api;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.brp.base.Constant;
import com.brp.base.Status;
import com.brp.base.VipLevel;
import com.brp.entity.CompanyEntity;
import com.brp.entity.DepartmentEntity;
import com.brp.entity.MenuDefinedEntity;
import com.brp.entity.OrganizationEntity;
import com.brp.entity.UserEntity;
import com.brp.service.CompanyService;
import com.brp.service.DepartmentService;
import com.brp.service.MenuDefinedService;
import com.brp.service.OrganzationService;
import com.brp.service.UserService;
import com.brp.util.JsonUtils;
import com.brp.util.SHA1Utils;
import com.brp.util.TryParseUtils;
import com.brp.util.api.model.ApiCode;
import com.brp.util.api.model.JsonData;
import com.brp.util.query.CompanyQuery;
import com.brp.util.query.UserQuery;
import com.brp.util.vo.BTreeVO;
import com.google.gson.Gson;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MenuDefinedApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/api/menuDefined")
public class MenuDefinedApi {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private MenuDefinedService mdService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "/insertMenuDefined", method = RequestMethod.POST)
	@ResponseBody
	public String insertMenuDefined(@RequestBody JSONObject jsonObject){
		JsonData<Long> jsonData = new JsonData<Long>();
		try{
			String mdJson = jsonObject.getString("mdJson");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("mdJson", mdJson);
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
				List<MenuDefinedEntity> mdList = JSONObject.parseArray(mdJson, MenuDefinedEntity.class);
				if(mdList != null && mdList.size() > 0){
					MenuDefinedEntity example = mdList.get(0);
					String companyId = example.getCompanyId();
					String definedType = example.getDefinedType().toString();
					String casecadeId = example.getDefinedCasecaseId();
					
					List<MenuDefinedEntity> existMdList = mdService.getMenuDefinedList(companyId, definedType, casecadeId);
					if(existMdList != null && existMdList.size() > 0){
						List<MenuDefinedEntity> deleteList = new LinkedList<MenuDefinedEntity>();
						List<MenuDefinedEntity> updateList = new LinkedList<MenuDefinedEntity>();
						for (MenuDefinedEntity existMD : existMdList) {
							if(this.listContainsMD(mdList, existMD)){
								if(existMD.getIsDelete() == 1){
									updateList.add(existMD);
								}
							}else{
								if(existMD.getIsDelete() == 0){
									deleteList.add(existMD);
								}
							}
						}
						
						mdService.batchUpdateIsDelete(1, deleteList);
						mdService.batchUpdateIsDelete(0, updateList);
						
						List<MenuDefinedEntity> notExistList = new LinkedList<MenuDefinedEntity>();
						for (MenuDefinedEntity newMD : mdList) {
							if(!this.listContainsMD(existMdList, newMD)){
								notExistList.add(newMD);
							}
						}
						
						mdService.batchInsertMenuDefined(notExistList);
						
					}else{
						mdService.batchInsertMenuDefined(mdList);
					}
					
					if("3".equals(definedType)){
						//按照部门定义
						List<DepartmentEntity> subDeptList = departmentService.getDepartmentListByPidAndCid(casecadeId, companyId);
						String deptIdStr = casecadeId;
						if(subDeptList != null && subDeptList.size() > 0){
							for (DepartmentEntity department : subDeptList) {
								deptIdStr += department.getId() + ",";
							}
							
							deptIdStr = deptIdStr.substring(0, deptIdStr.length() - 1);
						}
						
						userService.batchUpdateUserDefineType(definedType, companyId, deptIdStr);
					}else if("4".equals(definedType)){
						//按照角色定义

						List<String> userIdList = userService.getUserIdListByAuthIdForRole(casecadeId);
						if(userIdList != null && userIdList.size() > 0){
							String userIdStr = "";
							for (String userId : userIdList) {
								userIdStr += userId + ",";
							}
							
							if(StringUtils.isNotBlank(userIdStr)){
								userIdStr = userIdStr.substring(0, userIdStr.length() - 1);
								userService.batchUpdateDefineTypeForRole(userIdStr);
							}
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
	
	private boolean listContainsMD(List<MenuDefinedEntity> list , MenuDefinedEntity md){
		String companyId = md.getCompanyId();
		String casecaseId = md.getDefinedCasecaseId();
		Integer definedType = md.getDefinedType();
		String menuId = md.getMenuId();
		boolean isContains = false;
		if(list != null && list.size() > 0){
			for (MenuDefinedEntity listMD : list) {
				if(menuId.equals(listMD.getMenuId()) && companyId.equals(listMD.getCompanyId()) && casecaseId.equals(listMD.getDefinedCasecaseId()) && definedType == listMD.getDefinedType()){
					isContains = true;
					break;
				}
			}
		}
		
		return isContains;
	}
	
}

