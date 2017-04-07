package com.brp.service;

import com.brp.entity.DepartmentEntity;
import com.brp.util.query.DepartmentQuery;
import com.brp.util.vo.BTreeVO;

import java.util.List;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ConfigService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface DepartmentService {
	void insertDepartment(DepartmentEntity department);
	DepartmentQuery getDepartmentList(DepartmentQuery departmentQuery);
	void updateDepartment(DepartmentEntity department);
	void deleteDepartmentById(String id);
	DepartmentEntity getDepartmentById(Integer id);
	boolean isExistDepartment(String departmentName, String companyId, String departmentId);
	boolean isExistDepartmentByPid(String departmentName, String pId, String departmentId);
	
	List<DepartmentEntity> getListByCompanyId(String companyId);
	List<BTreeVO> getDepartmentTreeByPidAndCid(String pid, String cid);
	List<String> getDepartmentIdListByPidAndCid(String pid, String cid);
	List<DepartmentEntity> getDepartmentListByPId(String pid);
	List<DepartmentEntity> getNoSubDeptListByCId(String cid);
	List<DepartmentEntity> getDepartmentListByPidAndCid(String pid, String cid);
	List<DepartmentEntity> getAllDeptListByCompanyId(String companyId);
}

