package com.brp.service;

import java.util.List;

import com.brp.entity.DepartmentEntity;
import com.brp.util.query.DepartmentQuery;

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
	DepartmentEntity getDepartmentById(Integer id);
	boolean isExistDepartment(String departmentName, String companyId);
	List<DepartmentEntity> getListByCompanyId(String companyId);
	List<DepartmentEntity> getDepartmentByParentId(String parentDepartmentId);
}

