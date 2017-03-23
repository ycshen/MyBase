package com.brp.service;

import com.brp.entity.DailyAccountEntity;
import com.brp.util.query.DailyAccountQuery;

import java.util.List;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: DailyAccountService.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public interface DailyAccountService {
	void insertDailyAccount(DailyAccountEntity dailyAccount);
	List<DailyAccountEntity> getDailyAccountList(DailyAccountQuery dailyAccountQuery);
	void updateDailyAccount(DailyAccountEntity dailyAccount);
	DailyAccountEntity getDailyAccountById(String id);
	void deleteDailyAccountById(String id);
	DailyAccountEntity getDailyAccountByQuery(DailyAccountQuery dailyAccountQuery);
	DailyAccountQuery getDailyAccountPage(DailyAccountQuery dailyAccountQuery);
	DailyAccountEntity getDailyAccountByIdWithoutIsdelete(String id);
	
	
}

