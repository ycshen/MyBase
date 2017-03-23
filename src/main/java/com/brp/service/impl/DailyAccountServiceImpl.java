package com.brp.service.impl;

import com.brp.entity.DailyAccountEntity;
import com.brp.mapper.DailyAccountMapper;
import com.brp.service.DailyAccountService;
import com.brp.util.query.DailyAccountQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: DailyAccountServiceImpl.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Service
public class DailyAccountServiceImpl implements DailyAccountService{
	@Autowired
	private DailyAccountMapper dailyAccountMapper;

	@Override
	public void insertDailyAccount(DailyAccountEntity dailyAccount) {
		dailyAccountMapper.insertDailyAccount(dailyAccount);
	}

	@Override
	public List<DailyAccountEntity> getDailyAccountList(DailyAccountQuery dailyAccountQuery) {
		return dailyAccountMapper.getDailyAccountList(dailyAccountQuery);
	}

	@Override
	public void updateDailyAccount(DailyAccountEntity dailyAccount) {
		dailyAccountMapper.updateDailyAccount(dailyAccount);
	}

	@Override
	public DailyAccountEntity getDailyAccountById(String id) {
		return dailyAccountMapper.getDailyAccountById(id);
	}

	@Override
	public void deleteDailyAccountById(String id) {
		dailyAccountMapper.deleteDailyAccountById(id);
	}

	@Override
	public DailyAccountEntity getDailyAccountByQuery(DailyAccountQuery dailyAccountQuery) {
		return dailyAccountMapper.getDailyAccountByQuery(dailyAccountQuery);
	}

	@Override
	public DailyAccountQuery getDailyAccountPage(DailyAccountQuery dailyAccountQuery) {
		List<DailyAccountEntity> list = dailyAccountMapper.getDailyAccountPage(dailyAccountQuery);
		dailyAccountQuery.setItems(list);
		return dailyAccountQuery;
	}

	@Override
	public DailyAccountEntity getDailyAccountByIdWithoutIsdelete(String id) {
		return dailyAccountMapper.getDailyAccountByIdWithoutIsdelete(id);
	}
	
}

