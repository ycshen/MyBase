package com.brp.api;

import com.alibaba.fastjson.JSONObject;
import com.brp.base.Constant;
import com.brp.base.Status;
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
import com.brp.util.query.UserQuery;
import com.brp.util.vo.BTreeVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: CompanyApi.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/api/department")
public class DepartmentApi {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private OrganzationService organzationService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/getDepByCompanyId", method = RequestMethod.POST)
	@ResponseBody
	public String getDepByCompanyId(@RequestBody JSONObject jsonObject){
		JsonData<List<DepartmentEntity>> jsonData = new JsonData<List<DepartmentEntity>>();
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
				List<DepartmentEntity> departmentList = departmentService.getListByCompanyId(id);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(departmentList);
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


	@RequestMapping(value = "/getAllDepByCompanyId", method = RequestMethod.POST)
	@ResponseBody
	public String getAllDepByCompanyId(@RequestBody JSONObject jsonObject){
		JsonData<List<DepartmentEntity>> jsonData = new JsonData<List<DepartmentEntity>>();
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
				List<DepartmentEntity> departmentList = departmentService.getAllDeptListByCompanyId(id);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(departmentList);
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

	@RequestMapping(value = "/getNoSubDepListByCId", method = RequestMethod.POST)
	@ResponseBody
	public String getNoSubDepListByCId(@RequestBody JSONObject jsonObject){
		JsonData<List<DepartmentEntity>> jsonData = new JsonData<List<DepartmentEntity>>();
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
				List<DepartmentEntity> departmentList = departmentService.getNoSubDeptListByCId(id);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(departmentList);
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
	
	@RequestMapping(value = "/getSubDepIdList", method = RequestMethod.POST)
	@ResponseBody
	public String getSubDepIdList(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String companyId = jsonObject.getString("companyId");
			String departmentId = jsonObject.getString("departmentId");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("companyId", companyId);
				maps.put("departmentId", departmentId);
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
				List<String> idList = departmentService.getDepartmentIdListByPidAndCid(departmentId, companyId);
				String idStr = departmentId;
				if(idList != null && idList.size() > 0){
					for (String id : idList) {
						idStr += id + ",";
					}
					
					if(idStr.contains(",")){
						idStr = idStr.substring(0, idStr.length() - 1);
					}
				}
				
				
				
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(idStr);
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
	
	@RequestMapping(value = "/getDepById", method = RequestMethod.POST)
	@ResponseBody
	public String getDepById(@RequestBody JSONObject jsonObject){
		JsonData<DepartmentEntity> jsonData = new JsonData<DepartmentEntity>();
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
			
			if(auth && StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Integer.class)){
				DepartmentEntity department = departmentService.getDepartmentById(Integer.parseInt(id));
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
				jsonData.setData(department);
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
	
	@RequestMapping(value = "/insertDepartment", method = RequestMethod.POST)
	@ResponseBody
	public String insertDepartment(@RequestBody JSONObject jsonObject){
		JsonData<Long> jsonData = new JsonData<Long>();
		try{
			String departmentJson = jsonObject.getString("departmentJson");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("departmentJson", departmentJson);
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
				DepartmentEntity department = JSONObject.parseObject(departmentJson, DepartmentEntity.class);
				department.setCreateTime(new Date());
				department.setStatus(Status.NORMAL);
				department.setIsHasSub(0);
				departmentService.insertDepartment(department);
				Long companyId = department.getCompanyId();
				this.initDeptTree(companyId.toString());
				
				Long parentDeptId = department.getParentDepartmentId();
				DepartmentEntity parentDept = departmentService.getDepartmentById(parentDeptId.intValue());
				if(parentDept != null && 0 == parentDept.getIsHasSub()){
					parentDept.setIsHasSub(1);
					departmentService.updateDepartment(parentDept);
				}
				
				jsonData.setData(department.getId());
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
	
	@RequestMapping(value = "/updateDepartment", method = RequestMethod.POST)
	@ResponseBody
	public String updateDepartment(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String departmentJson = jsonObject.getString("departmentJson");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("departmentJson", departmentJson);
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
				DepartmentEntity department = JSONObject.parseObject(departmentJson, DepartmentEntity.class);
				departmentService.updateDepartment(department);
				Long companyId = department.getCompanyId();
				this.initDeptTree(companyId.toString());
				
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
	
	@RequestMapping(value = "/isExistDepartment", method = RequestMethod.POST)
	@ResponseBody
	public String isExistDepartment(@RequestBody JSONObject jsonObject){
		JsonData<Boolean> jsonData = new JsonData<Boolean>();
		try{
			String id = jsonObject.getString("id");
			String departmentId = jsonObject.getString("departmentId");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			String departmentName = jsonObject.getString("departmentName");
			String isCompany = jsonObject.getString("isCompany");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("id", id);
				maps.put("departmentId", departmentId);
				maps.put("secret", mybaseSecret);
				maps.put("cId", cId);
				maps.put("departmentName", departmentName);
				maps.put("isCompany", isCompany);
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
				Boolean isExist = true;
				if(Constant.TRUE.equals(isCompany)){
					isExist = departmentService.isExistDepartment(departmentName, id, departmentId);
				}else{
					isExist = departmentService.isExistDepartmentByPid(departmentName, id, departmentId);
				}
				
				jsonData.setData(isExist);
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
	
	@RequestMapping(value = "/deleteDepartmentById", method = RequestMethod.POST)
	@ResponseBody
	public String deleteDepartmentById(@RequestBody JSONObject jsonObject){
		JsonData<String> jsonData = new JsonData<String>();
		try{
			String companyId = jsonObject.getString("companyId");
			String id = jsonObject.getString("id");
			String secret = jsonObject.getString("secret");
			String cId = jsonObject.getString("cId");
			
			boolean auth = false;
			if(StringUtils.isNotBlank(cId) && TryParseUtils.tryParse(cId, Long.class)){
				String mybaseSecret = companyService.getSecretById(Long.parseLong(cId));
				Map<String,Object> maps = new HashMap<String, Object>();
				maps.put("id", id);
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
			
			if(auth && StringUtils.isNotBlank(id) && TryParseUtils.tryParse(id, Integer.class)){
				departmentService.deleteDepartmentById(id);
				this.freeUser(companyId, id);
				List<DepartmentEntity> deptList = departmentService.getDepartmentListByPidAndCid(id, companyId);
				if(deptList != null && deptList.size() > 0){
					for (DepartmentEntity department : deptList) {
						Long subDeptId = department.getId();
						this.freeUser(companyId, subDeptId.toString());
						departmentService.deleteDepartmentById(subDeptId.toString());
					}
				}
				
				this.initDeptTree(companyId);
				jsonData.setCode(ApiCode.OK);
				jsonData.setMessage("操作成功");
			}else{
				jsonData.setCode(ApiCode.ARGS_EXCEPTION);
				jsonData.setMessage("参数异常");
			}
		}catch(Exception e){
			System.out.println("促物");
			e.printStackTrace();
			jsonData.setCode(ApiCode.EXCEPTION);
			jsonData.setMessage("操作失败");
		}
		
		String result = JsonUtils.json2Str(jsonData);
		
		return result;
	}
	
	private void initDeptTree(String companyId){
		OrganizationEntity org = new OrganizationEntity();
		String tree = this.getOrgTreeByCompanyId(companyId.toString());
		org.setCompanyId(Long.parseLong(companyId));
		org.setOrgStr(tree);
		String deptTree = organzationService.getOrgByCompanyId(Integer.parseInt(companyId));
		if(StringUtils.isBlank(deptTree)){
			organzationService.insertCompanyOrg(org);
		}else{
			organzationService.updateCompnayOrg(org);
		}
	}
	
	private void freeUser(String companyId, String departmentId){
		UserQuery userQuery = new UserQuery();
		userQuery.setCompanyId(companyId);
		userQuery.setDepartmentId(departmentId);
		List<UserEntity> list = userService.getUserListByCompanyIdAndDeptId(userQuery);
		if(list != null && list.size() > 0){
			for (UserEntity userEntity : list) {
				userEntity.setDepartmentId(-1);
				userService.updateUser(userEntity);
			}
		}
	}
}

