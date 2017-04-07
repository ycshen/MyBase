package com.brp.mapper;

import com.brp.entity.DepartmentEntity;
import com.brp.util.query.DepartmentQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: DeparmentMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface DepartmentMapper {
	void insertDepartment(DepartmentEntity department);
	List<DepartmentEntity> getDepartmentPage(DepartmentQuery departmentQuery);
	void updateDepartment(DepartmentEntity department);
	DepartmentEntity getDepartmentById(Integer id);
	DepartmentEntity getDepartmentByNameAndcompanyId(@Param("departmentName")String departmentName,@Param("companyId") String companyId);
	DepartmentEntity getDepartmentByNameAndPId(@Param("departmentName")String departmentName,@Param("pId") String pId);
	List<DepartmentEntity> getListByCompanyId(String companyId);
	List<DepartmentEntity> getAllDeptListByCompanyId(String companyId);
	List<DepartmentEntity> getDepartmentTreeByPIdAndCId(@Param("pid") String pid, @Param("cid") String cid);
	List<DepartmentEntity> getDepartmentListByPId(String pid);
	List<DepartmentEntity> getNoSubDeptListByCId(String cid);
	void deleteDepartmentById(String id);
	List<String> getDepartmentIdListByPIdAndCId(@Param("pid") String pid, @Param("cid") String cid);
}

