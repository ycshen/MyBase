package com.brp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brp.entity.MemoEntity;
import com.brp.entity.MemoEventEntity;
import com.brp.entity.MenuEntity;
import com.brp.mapper.MemoEventMapper;
import com.brp.mapper.MemoMapper;
import com.brp.mapper.MenuMapper;
import com.brp.service.MemoEventService;
import com.brp.service.MemoService;
import com.brp.service.MenuService;
import com.brp.util.DateUtils;
import com.brp.util.query.MenuQuery;
import com.brp.util.vo.BTreeVO;
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
public class MemoServiceImpl implements MemoService{
	@Autowired
	private MemoMapper memoMapper;

	@Override
	public void insertMemo(MemoEntity memo) {
		memoMapper.insertMemo(memo);
	}

	@Override
	public List<MemoEntity> getMemoByUserId(Integer userId) {
		return memoMapper.getMemoByUserId(userId);
	}

	@Override
	public List<MemoEntity> getTodayMemo(Integer userId) {
		String startTime = DateUtils.getCurrentDate("yyyy-MM-dd") + " 00:00";
		String endTime = DateUtils.getCurrentDate("yyyy-MM-dd") + " 24:00";
		List<MemoEntity> list = memoMapper.getMemoList(startTime, endTime, userId);
		
		return list;
	}
	
	@Override
	public List<MemoEntity> getWeekMemo(Integer userId) {
		String format = "yyyy-MM-dd";
		String now = DateUtils.getCurrentDate("yyyy-MM-dd");
		List<MemoEntity> list = null;
		try {
			String startTime = DateUtils.getFirstDayForWeek(format, now) + "00:00";
			String endTime = DateUtils.getLastDayForWeek(format, now) + " 24:00";
			list = memoMapper.getMemoList(startTime, endTime, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<MemoEntity> getMonthMemo(Integer userId) {
		String format = "yyyy-MM";
		List<MemoEntity> list = null;
		try {
			String startTime = DateUtils.getCurrentDate(format)  + "-01 00:00:00";
			String endTime = DateUtils.getDateStr(DateUtils.addMonths(DateUtils.str2date(startTime, "yyyy-MM-dd HH:mm:ss"), 1), "yyyy-MM-dd HH:mm:ss");
			list = memoMapper.getMemoList(startTime, endTime, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		String format = "yyyy-MM";
		String startTime = DateUtils.getCurrentDate(format)  + "-01 00:00:00";
		System.out.println(startTime);
		Date date = DateUtils.str2date(startTime, "yyyy-MM-dd HH:mm:ss");
		System.out.println("sss");
		String endTime = DateUtils.getDateStr(DateUtils.addMonths(date, 1), "yyyy-MM-dd HH:mm:ss");
		System.out.println(endTime);
	}

}

