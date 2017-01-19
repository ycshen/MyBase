package com.brp.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.brp.entity.PositionEntity;
import com.brp.util.query.PositionQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: PositionMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface PositionMapper {
	void insertPosition(PositionEntity position);
	List<PositionEntity> getPositionList(PositionQuery positionQuery);
	void updatePosition(PositionEntity position);
	PositionEntity getPositionById(Integer id);
	void deletePositionById(String id);
	PositionEntity getPositionByQuery(PositionQuery positionQuery);
}

