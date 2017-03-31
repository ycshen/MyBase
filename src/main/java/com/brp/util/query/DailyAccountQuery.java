package com.brp.util.query;

import com.brp.entity.DailyAccountEntity;
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
	private String userId;
	private String companyId;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}

