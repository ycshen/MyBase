package com.brp.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.lucene.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.brp.entity.DepartmentEntity;
import com.brp.mapper.DepartmentMapper;
import com.brp.service.DepartmentService;
import com.brp.util.query.DepartmentQuery;
import com.brp.util.vo.BTreeVO;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: DepartmentServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentMapper departmentMapper;
	@Override
	public void insertDepartment(DepartmentEntity department) {
		departmentMapper.insertDepartment(department);
	}
	
	@Override
	public DepartmentQuery getDepartmentList(DepartmentQuery departmentQuery) {
		List<DepartmentEntity> list = departmentMapper.getDepartmentPage(departmentQuery);
		if(list != null && list.size() > 0){
			departmentQuery.setItems(list);
		}
		
		return departmentQuery;
	}

	@Override
	public void updateDepartment(DepartmentEntity department) {
		departmentMapper.updateDepartment(department);
	}

	@Override
	public DepartmentEntity getDepartmentById(Integer id) {
		DepartmentEntity department = departmentMapper.getDepartmentById(id);
		
		return department;
	}

	

	@Override
	public List<DepartmentEntity> getListByCompanyId(String companyId) {
		return departmentMapper.getListByCompanyId(companyId);
	}

	@Override
	public List<BTreeVO> getDepartmentTreeByPidAndCid(String pid, String cid) {
		List<BTreeVO> deptVosList = new ArrayList<BTreeVO>();  
        List<DepartmentEntity> departmentList = departmentMapper.getDepartmentTreeByPIdAndCId(pid, cid); 
        if(departmentList != null && departmentList.size() > 0){  
            for(DepartmentEntity deptVo : departmentList){  
            	BTreeVO treeNode = new BTreeVO();
            	treeNode.setId(deptVo.getId().intValue() + "_3_" + pid);  
            	treeNode.setName(deptVo.getDepartmentName());
            	String id = deptVo.getId().toString();
            	if(deptVo.getIsHasSub() != null && deptVo.getIsHasSub() == 1){
                	treeNode.setChildren(getDepartmentTreeByPidAndCid(id, cid));
            	}
            	
            	deptVosList.add(treeNode);  
            }  
        }
        
        return deptVosList; 
	}

	@Override
	public List<DepartmentEntity> getDepartmentListByPId(String pid) {
		return departmentMapper.getDepartmentListByPId(pid);
	}

	@Override
	public boolean isExistDepartment(String departmentName, String companyId, String departmentId) {
		DepartmentEntity department = departmentMapper.getDepartmentByNameAndcompanyId(departmentName, companyId);
		if(department != null && !department.getId().equals(departmentId)){
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean isExistDepartmentByPid(String departmentName, String pId, String departmentId) {
		DepartmentEntity department = departmentMapper.getDepartmentByNameAndPId(departmentName, pId);
		if(department != null && !department.getId().equals(departmentId)){
			return true;
		}
		
		return false;
	}

	@Override
	public List<DepartmentEntity> getNoSubDeptListByCId(String cid) {
		return departmentMapper.getNoSubDeptListByCId(cid);
	}

	@Override
	public void deleteDepartmentById(String id) {
		departmentMapper.deleteDepartmentById(id);
	}

	@Override
	public List<DepartmentEntity> getDepartmentListByPidAndCid(String pid,
			String cid) {
		List<DepartmentEntity> returnList = new LinkedList<DepartmentEntity>();
		List<DepartmentEntity> departmentList = departmentMapper.getDepartmentTreeByPIdAndCId(pid, cid); 
        if(departmentList != null && departmentList.size() > 0){  
            for(DepartmentEntity deptVo : departmentList){  
            	String id = deptVo.getId().toString();
            	if(deptVo.getIsHasSub() != null && deptVo.getIsHasSub() == 1){
            		List<DepartmentEntity> subList = getDepartmentListByPidAndCid(id, cid);
            		if(subList != null && subList.size() > 0){
                		returnList.addAll(subList);
            		}
            	}
            	
            	returnList.add(deptVo);  
            }  
        }
        
        return returnList; 
	}

}

