package com.brp.interceptors;


import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.brp.entity.UserEntity;
import com.brp.model.BRPUserInfo;
import com.brp.model.LoginUser;
import com.brp.service.UserService;
import com.brp.util.CommonUtils;
import com.brp.util.api.PMSApiUtils;
import com.brp.util.cookie.LoggedCookie;
import com.google.gson.Gson;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/3/23.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        super.preHandle(request,response,o);
        HttpSession seesion = request.getSession();
        //response.sendRedirect("login");
        UserEntity loginUser = (UserEntity) seesion.getAttribute("loginUser");
        if(loginUser == null){
        	response.sendRedirect("/login");
			return false;
        	
        }
        
        return true;

    }


}
