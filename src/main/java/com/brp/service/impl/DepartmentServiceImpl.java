package com.brp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.DepartmentEntity;
import com.brp.mapper.DepartmentMapper;
import com.brp.service.DepartmentService;
import com.brp.util.query.DepartmentQuery;

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
	public boolean isExistDepartment(String departmentName, String companyId) {
		DepartmentEntity department = departmentMapper.getDepartmentByNameAndcompanyId(departmentName, companyId);
		if(department != null){
			return true;
		}
		
		return false;
	}

	@Override
	public List<DepartmentEntity> getListByCompanyId(String companyId) {
		return departmentMapper.getListByCompanyId(companyId);
	}

	@Override
	public List<DepartmentEntity> getDepartmentByParentId(
			String parentDepartmentId) {
		// TODO Auto-generated method stub
		return departmentMapper.getDepartmentByParentId(parentDepartmentId);
	}
}

