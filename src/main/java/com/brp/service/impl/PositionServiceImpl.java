package com.brp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.PositionEntity;
import com.brp.mapper.PositionMapper;
import com.brp.service.PositionService;
import com.brp.util.query.PositionQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: PositionServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class PositionServiceImpl implements PositionService{
	@Autowired
	private PositionMapper positionMapper;

	@Override
	public void insertPosition(PositionEntity position) {
		positionMapper.insertPosition(position);
	}

	@Override
	public List<PositionEntity> getPositionList(PositionQuery positionQuery) {
		return positionMapper.getPositionList(positionQuery);
	}

	@Override
	public void updatePosition(PositionEntity position) {
		positionMapper.updatePosition(position);
	}

	@Override
	public PositionEntity getPositionById(Integer id) {
		return positionMapper.getPositionById(id);
	}

	@Override
	public void deletePositionById(String id) {
		positionMapper.deletePositionById(id);
	}

	@Override
	public PositionEntity getPositionByQuery(PositionQuery positionQuery) {
		return positionMapper.getPositionByQuery(positionQuery);
	}
	
}

