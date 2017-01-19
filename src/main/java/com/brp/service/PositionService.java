package com.brp.service;

import java.util.List;

import com.brp.entity.PositionEntity;
import com.brp.util.query.PositionQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: PositionService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface PositionService {
	void insertPosition(PositionEntity position);
	List<PositionEntity> getPositionList(PositionQuery positionQuery);
	void updatePosition(PositionEntity position);
	PositionEntity getPositionById(Integer id);
	void deletePositionById(String id);
	PositionEntity getPositionByQuery(PositionQuery positionQuery);
}

