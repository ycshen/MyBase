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
import com.brp.base.VipLevel;
import com.brp.entity.CompanyEntity;
import com.brp.entity.DepartmentEntity;
import com.brp.entity.OrganizationEntity;
import com.brp.entity.UserEntity;
import com.brp.service.CompanyService;
import com.brp.service.DepartmentService;
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
 * <p>Title: CompanyApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/api/company")
public class CompanyApi {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrganzationService organzationService;
	 
	@RequestMapping(value = "/getSubCompanyPage", method = RequestMethod.POST)
	@ResponseBody
	public String getSubCompanyPage(@RequestBody JSONObject jsonObject){
		JsonData<List<CompanyEntity>> jsonData = new JsonData<List<CompanyEntity>>();
		try{
			String id = jsonObject.getString("id");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			String pageSize = jsonObject.getString("pageSize");
			String currentPage = jsonObject.getString("currentPage");
			String companyName = jsonObject.getString("companyName");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("id", id);
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				maps.put("pageSize", pageSize);
				maps.put("currentPage", currentPage);
				maps.put("companyName", companyName);
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
				CompanyQuery companyQuery = new CompanyQuery();
				companyQuery.setCompanyId(id);
				if(StringUtils.isBlank(currentPage)){
					currentPage = "1";
				}
				
				companyQuery.setPage(Integer.parseInt(currentPage));
				if(StringUtils.isBlank(pageSize)){
					pageSize = "20";
				}
				
				companyQuery.setSize(Integer.parseInt(pageSize));
				companyQuery = companyService.getSubCompanyPage(companyQuery);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(companyQuery.getItems());
				jsonData.setCount(companyQuery.getCount());
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
	
	@RequestMapping(value = "/getCompanyById", method = RequestMethod.POST)
	@ResponseBody
	public String getCompanyById(@RequestBody JSONObject jsonObject){
		JsonData<CompanyEntity> jsonData = new JsonData<CompanyEntity>();
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
				CompanyEntity company = companyService.getCompanyById(Long.parseLong(id));
				company.setSecret(StringUtils.EMPTY);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(company);
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
	
	@RequestMapping(value = "/getSecretById", method = RequestMethod.POST)
	@ResponseBody
	public String getSecretById(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
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
				CompanyEntity company = companyService.getCompanyById(Long.parseLong(id));
				if(company != null){
					jsonData.setData(company.getSecret());
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
	
	@RequestMapping(value = "/insertCompany", method = RequestMethod.POST)
	@ResponseBody
	public String insertCompany(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String companyJson = jsonObject.getString("companyJson");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("companyJson", companyJson);
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
				CompanyEntity company = JSONObject.parseObject(companyJson, CompanyEntity.class);
				company.setCreateTime(new Date());
				company.setLevel(VipLevel.VIP);		
				company.setSecret(SHA1Utils.getSecret());
				companyService.insertCompany(company);
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
	
	@RequestMapping(value = "/updateCompany", method = RequestMethod.POST)
	@ResponseBody
	public String updateCompany(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String companyJson = jsonObject.getString("companyJson");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("companyJson", companyJson);
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
				CompanyEntity company = JSONObject.parseObject(companyJson, CompanyEntity.class);
				companyService.updateCompany(company);
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
	
	@RequestMapping(value = "/close", method = RequestMethod.POST)
	@ResponseBody
	public String closeCompany(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
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
				
				companyService.deleteCompany(Long.parseLong(id));
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
	
	@RequestMapping(value = "/activate", method = RequestMethod.POST)
	@ResponseBody
	public String activateCompany(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
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
				companyService.activateCompany(Long.parseLong(id));
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
	
	@RequestMapping(value = "/getCompanyStaffTreeById", method = RequestMethod.POST)
	@ResponseBody
	public String getCompanyStaffTreeById(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String companyId = jsonObject.getString("companyId");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("companyId", companyId);
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
			
			if(auth && StringUtils.isNotBlank(companyId) && TryParseUtils.tryParse(companyId, Integer.class)){
				
				String tree = organzationService.getOrgByCompanyId(Integer.parseInt(companyId));
				if(StringUtils.isBlank(tree)){
					OrganizationEntity org = new OrganizationEntity();
					tree = this.getOrgTreeByCompanyId(companyId);
					org.setCompanyId(Long.parseLong(companyId));
					org.setOrgStr(tree);
					organzationService.insertCompanyOrg(org);
				}
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(tree);
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
	
	private String getOrgTreeByCompanyId(String companyId){
		List<BTreeVO> companyTree = new LinkedList<BTreeVO>(); 
		CompanyEntity company = companyService.getCompanyById(Long.parseLong(companyId));
		if(company != null){	
			BTreeVO companyTreeNode = this.getTreeNode(company, CompanyEntity.class);
			//1.子公司
			//2.一级部门
			//3.下级部门
			Long pId = company.getId();
			/*List<CompanyEntity> subCompanyList = companyService.getSubCompanyListByPId(pId.intValue());
			List<BTreeVO> subCompanyChildrens = this.switchCompanyListToTreeList(subCompanyList);
			*/
			List<DepartmentEntity> rootDeparmentList = departmentService.getListByCompanyId(pId.toString());
			List<BTreeVO> companyChildrens = this.switchDepartmentListToTreeList(rootDeparmentList, pId.toString());
			/*companyChildrens.addAll(subCompanyChildrens);*/
			companyTreeNode.setChildren(companyChildrens);
			companyTree.add(companyTreeNode);
		}
		
		String tree = JsonUtils.json2Str(companyTree);
		
		return tree;
	}
	
	private List<BTreeVO> switchDepartmentListToTreeList(List<DepartmentEntity> deparmentList, String cid){
		List<BTreeVO> treeList  = new LinkedList<BTreeVO>();
		if(deparmentList != null && deparmentList.size() > 0){
			BTreeVO tree = null;
			for (DepartmentEntity department : deparmentList) {
				tree = this.getTreeNode(department, DepartmentEntity.class);
				treeList.add(tree);
			}
		}
		
		return treeList;
	}
	
	private List<BTreeVO> switchCompanyListToTreeList(List<CompanyEntity> companyList){
		List<BTreeVO> treeList  = new LinkedList<BTreeVO>();
		if(companyList != null && companyList.size() > 0){
			BTreeVO tree = null;
			CompanyEntity company = null;
			for(int i=0; i< companyList.size(); i++){
				company = companyList.get(i);
				tree = this.getTreeNode(company, CompanyEntity.class);
				treeList.add(tree);
			}
		}
		
		return treeList;
	}
	
	private BTreeVO getTreeNode(Object obj, Class clazz){
		String className = clazz.getName();
		String id = StringUtils.EMPTY;
		String text = StringUtils.EMPTY;
		//1 公司 2.分公司 3.部门 4.用户 5. 菜单
		BTreeVO node = new BTreeVO();
		if("com.brp.entity.CompanyEntity".equals(className)){
			CompanyEntity company = (CompanyEntity)obj;
			text = company.getCompanyName();
			String pCid = company.getParentCompanyId();
			if(StringUtils.isNotBlank(pCid)){
				//分公司
				id = company.getId().intValue() + "_2_" + pCid; 
			}else{
				//总公司
				id = company.getId().intValue() + "_1_n"; 
			}
			
			
			String cid = company.getId().toString();
			List<DepartmentEntity> subDeparmentList = departmentService.getListByCompanyId(cid);
			List<BTreeVO> departmentTreeNode = this.switchDepartmentListToTreeList(subDeparmentList, cid);
			node.setChildren(departmentTreeNode);
		}else if("com.brp.entity.UserEntity".equals(className)){
			UserEntity user = (UserEntity)obj;
			id = user.getId().intValue() + "_4_n"; 
			text = user.getUserName();
		}else if("com.brp.entity.DepartmentEntity".equals(className)){
			DepartmentEntity department = (DepartmentEntity)obj;
			Long idLong = department.getId();
			Long pid = department.getParentDepartmentId();
			if(pid == null){
				id = idLong.intValue() + "_3_n"; 
			}else{
				//总公司
				id = idLong.intValue() + "_3_" + pid; 
			}
			text = department.getDepartmentName();
			List<BTreeVO> subTreeList = departmentService.getDepartmentTreeByPidAndCid(idLong.toString(), department.getCompanyId().toString());
			node.setChildren(subTreeList);
		}
		
		node.setId(id);
		node.setName(text);
		
		return node;
	}
}

