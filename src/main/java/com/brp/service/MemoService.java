package com.brp.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.brp.entity.MemoEntity;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MemoEventService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface MemoService {
	void insertMemo(MemoEntity memo);
	List<MemoEntity> getMemoByUserId(Integer userId);
	List<MemoEntity> getTodayMemo(Integer userId);
	List<MemoEntity> getWeekMemo(Integer userId);
	List<MemoEntity> getMonthMemo(Integer userId);
}

