package com.brp.util.query;

import com.brp.entity.EmailSendLogEntity;
import com.brp.entity.PositionEntity;
import com.brp.model.pageutil.Page;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: EmailSendLogQuery.java</p>
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class EmailSendLogQuery extends Page<EmailSendLogEntity>{
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	private String companyName;
	private String to;
	
}

