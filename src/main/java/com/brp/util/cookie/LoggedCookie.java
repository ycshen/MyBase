package com.brp.util.cookie;

import com.alibaba.fastjson.JSON;

import com.brp.model.LoginUserInfo;
import com.brp.util.ConfigUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author luoning
 * @date 2016年3月21日
 */
public class LoggedCookie {
	
	private static final Logger log = LoggerFactory.getLogger(LoggedCookie.class);
	private static final String loggedCookieName="LoginUserInfo";
	private static final String access_token="access_token";

	public static ThreadLocal<LoginUserInfo> loggedUserLocal = new ThreadLocal<>();

	public static LoginUserInfo CheckLoginViaCookie(HttpServletRequest request){
		Cookie cookie = CookieUtils.getCookie(request, loggedCookieName);
		if(cookie==null || StringUtils.isBlank(cookie.getValue())){
			return null;
		}

		String ecryptedCookieValue = cookie.getValue();
		String cookieValue="";
		try {
			cookieValue = RFDEncrypt.decrypt(ecryptedCookieValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(StringUtils.isBlank(cookieValue)){
			return null;
		}
		LoginUserInfo loginUserInfo=JSON.parseObject(cookieValue, LoginUserInfo.class);
		loggedUserLocal.set(loginUserInfo);

		return loginUserInfo;
	}



	public static String checkTokenCookie(HttpServletRequest request){
		Cookie cookie = CookieUtils.getCookie(request, access_token);
		if(cookie==null || StringUtils.isBlank(cookie.getValue())){
			return null;
		}

		String cookieValue = cookie.getValue();

		if(StringUtils.isBlank(cookieValue)){
			return null;
		}

		return cookieValue;
	}



	public static LoginUserInfo getCurrentLoggedUser(){
		return loggedUserLocal.get();
	}


	


}
