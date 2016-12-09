package com.brp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.brp.entity.UserEntity;
import com.brp.model.BRPUserInfo;
import com.brp.model.LoginUser;
import com.brp.util.CommonUtils;
import com.brp.util.UserUtils;
import com.brp.util.api.PMSApiUtils;
import com.brp.util.cookie.LoggedCookie;

/** 
 * <p>Project: BRP</p> 
 * <p>Title: BaseController.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class BaseController {
	public String getToken(HttpServletRequest request){
		String token = LoggedCookie.checkTokenCookie(request);
		if(StringUtils.isBlank(token) && CommonUtils.getLocalEnv()){
			//token = PMSApiUtils.getLocalToken();
		}
		
		return token;
	}
	
	public UserEntity getLoginUser(HttpServletRequest request){
		UserEntity user = UserUtils.getLoginUser(request);
		return user;
	}
	
}

