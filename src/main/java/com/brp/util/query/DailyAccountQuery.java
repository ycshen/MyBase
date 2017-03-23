package com.brp.util.query;

import com.brp.entity.DailyAccountEntity;
import com.brp.entity.PositionEntity;
import com.brp.model.pageutil.Page;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: ConfigQuery.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class DailyAccountQuery extends Page<DailyAccountEntity>{
	private String account;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}

