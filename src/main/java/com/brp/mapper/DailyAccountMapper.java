package com.brp.mapper;

import com.brp.entity.DailyAccountEntity;
import com.brp.util.query.DailyAccountQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: DailyAccountMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2017 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface DailyAccountMapper {
	void insertDailyAccount(DailyAccountEntity dailyAccount);
	List<DailyAccountEntity> getDailyAccountList(DailyAccountQuery dailyAccountQuery);
	void updateDailyAccount(DailyAccountEntity dailyAccount);
	DailyAccountEntity getDailyAccountById(String id);
	void deleteDailyAccountById(String id);
	DailyAccountEntity getDailyAccountByQuery(DailyAccountQuery dailyAccountQuery);
	List<DailyAccountEntity> getDailyAccountPage(DailyAccountQuery dailyAccountQuery);
	DailyAccountEntity getDailyAccountByIdWithoutIsdelete(String id);
	
}

