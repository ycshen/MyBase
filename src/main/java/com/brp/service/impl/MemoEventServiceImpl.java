package com.brp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.MemoEventEntity;
import com.brp.entity.MenuEntity;
import com.brp.mapper.MemoEventMapper;
import com.brp.mapper.MenuMapper;
import com.brp.service.MemoEventService;
import com.brp.service.MenuService;
import com.brp.util.query.MenuQuery;
import com.brp.util.vo.MenuTreeVO;
import com.google.gson.Gson;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MemoEventServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class MemoEventServiceImpl implements MemoEventService{
	@Autowired
	private MemoEventMapper memoEventMapper;

	@Override
	public void insertMemoEvent(MemoEventEntity memoEvent) {
		memoEventMapper.insertMemoEvent(memoEvent);
	}
	
}

