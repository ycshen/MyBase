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
	public void insertDepartment(DepartmentEntity Department) {
		departmentMapper.insertDepartment(Department);
	}
	
	@Override
	public DepartmentQuery getDepartmentList(DepartmentQuery DepartmentQuery) {
		List<DepartmentEntity> list = departmentMapper.getDepartmentList(DepartmentQuery);
		if(list != null && list.size() > 0){
			DepartmentQuery.setItems(list);
		}
		
		return DepartmentQuery;
	}

	@Override
	public void updateDepartment(DepartmentEntity Department) {
		departmentMapper.updateDepartment(Department);
	}

	@Override
	public DepartmentEntity getDepartmentById(Integer id) {
		DepartmentEntity Department = departmentMapper.getDepartmentById(id);
		
		return Department;
	}
}

