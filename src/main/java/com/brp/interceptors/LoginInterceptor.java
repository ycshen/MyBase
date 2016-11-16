package com.brp.interceptors;


import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.brp.model.BRPUserInfo;
import com.brp.model.LoginUser;
import com.brp.util.CommonUtils;
import com.brp.util.api.PMSApiUtils;
import com.brp.util.cookie.LoggedCookie;
import com.google.gson.Gson;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        String token =LoggedCookie.checkTokenCookie(request);
        HttpSession seesion = request.getSession();
        if (CommonUtils.getProdEnv() || CommonUtils.getTestEnv()) {
            if (StringUtils.isBlank(token)) { // 未登陆时跳转到登录页
                if(CommonUtils.getProdEnv()){
                    response.sendRedirect("https://login2.wuliusys.com");
                    return true;
                } else if (CommonUtils.getTestEnv()) {
                    response.sendRedirect("http://login2.wltest.com");
                    return true;
                }
            }

            // 菜单权限判断

            String menuUrl = request.getRequestURL().toString();
            String url ="/v2/rights/" + token + "/url?url=" + menuUrl;
            LOG.info("url: " + url);

            String result=PMSApiUtils.checkURL(url);
            JSONObject jsonObj = JSONObject.parseObject(result);
            String code = jsonObj.getString("code");
            LOG.info("code: " + code + "; message: " + jsonObj.getString("message"));
            if ("404".equals(code) || "44".equals(code)) {
                if(CommonUtils.getProdEnv()){
                    response.sendRedirect("https://login2.wuliusys.com");
                    return true;
                } else if (CommonUtils.getTestEnv()) {
                    response.sendRedirect("http://login2.wltest.com");
                    return true;
                }
            }
        }

        String employee=PMSApiUtils.getUserId(token);
        JSONObject userIDObj = JSONObject.parseObject(employee);
        String code = userIDObj.getString("code");
        String userId = userIDObj.getString("user_id");
        if("0".equals(code)){
        	String result = PMSApiUtils.getBrpUserInfo(userId, token);
        	Gson gson = new Gson();
        	//brp用户信息
        	BRPUserInfo brpUserInfo = gson.fromJson(result, BRPUserInfo.class);
        	seesion.setAttribute("brpUserInfo",brpUserInfo);
        	//风云用户信息
        	String fyUserInfo = PMSApiUtils.queryUserInfo(userId);
        	LoginUser loginUser = gson.fromJson(fyUserInfo, LoginUser.class);
        	seesion.setAttribute("loginUser",loginUser);
        }

        return true;

    }


}
