package com.brp.realm;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class DomainFilter extends FormAuthenticationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		// 如果是访问访问登录页面或是进行登录，则不作处理
		if (isLoginSubmission(request, response) || isLoginRequest(request, response)
				|| getPathWithinApplication(request).contains("logout")) {
			return true;
		}
		// 判断登录是否成功，不成功则返回false，作登录处理
		Object object = SecurityUtils.getSubject().getSession().getAttribute("flag");
		if (null == object) {
			return false;
		}
		// 为true说明当前登录账户为ad类型
		if ("true".equals(object.toString())) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		if (isLoginRequest(request, response) || isLoginSubmission(request, response)) {
			return super.onAccessDenied(request, response);
		}
		Object object = SecurityUtils.getSubject().getSession().getAttribute("flag");
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		// 判断登录是否成功，不成功则返回false,重定向到登录页面
		if (null == object) {
			res.sendRedirect(req.getContextPath() + "/login");
			return false;
		}
		// 如果当前账户不是ad账户，则只能访问domain下的资源
		if (!"true".equals(object.toString())) {
			res.sendRedirect(req.getContextPath() + "/domain/list");
			return false;
		}
		return true;
	}
}
