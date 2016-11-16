package com.brp.controller;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.brp.entity.ResultEnum;
import com.brp.model.ResultModel;


@Controller
@RequestMapping("/")
public class HomeController {

	private final static Logger LOG = LoggerFactory.getLogger(HomeController.class);

/*	@RequestMapping("/")
	public String main() {
		return "main";
	}*/

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
	/*	Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated() || null != subject.getSession().getAttribute("account")) {
			return new ModelAndView("redirect:/");
		}*/

		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if (isEmpty(account, password) || !"POST".equalsIgnoreCase(request.getMethod())) {
			return new ModelAndView("login");
		}

		UsernamePasswordToken token = new UsernamePasswordToken(account, password);
		if ("true".equals(request.getParameter("rememberMe"))) {
			token.setRememberMe(true);
		}
		ResultModel<String> result = new ResultModel<String>();
		result.setResult(ResultEnum.Failure);
		try {
			/*subject.login(token);
			Session session = subject.getSession();
			session.setAttribute("account", account);*/
			Pattern pattern = Pattern.compile("^([a-zA-Z\\d][a-zA-Z\\d-_]+\\.)+[a-zA-Z\\d-_][^ ]*$");
			Matcher matcher = pattern.matcher(account);

			// 设置记住密码
			if ("true".equals(request.getParameter("rememberMe"))) {
				Cookie accountC = new Cookie("account", URLEncoder.encode(account, "UTF-8"));
				Cookie passwordC = new Cookie("password", password);

				accountC.setPath("/");
				passwordC.setPath("/");

				accountC.setMaxAge(7 * 24 * 60 * 60);
				passwordC.setMaxAge(7 * 24 * 60 * 60);

				response.addCookie(accountC);
				response.addCookie(passwordC);
			}
			// 设置记住密码

			if (matcher.matches()) {
				// 以下设置代码用于解决区分是域账户登录，还是ad账户登录
				/*session.setAttribute("flag", "false");*/
				return new ModelAndView("redirect:/domain/list");
			} else {
				/*session.setAttribute("flag", "true");*/
				return new ModelAndView("redirect:/");
			}
		} catch (UnknownAccountException uae) {
			result.setMessage("登陆失败，账号密码错误。");
		} catch (IncorrectCredentialsException ice) {
			result.setMessage("登陆失败，账号密码错误。");
		} catch (LockedAccountException lae) {
			result.setMessage("登陆失败，账号已被锁定。");
		} catch (AuthenticationException lae) {
			result.setMessage("登陆失败，账号密码错误。");
		} catch (Exception e) {
			LOG.error("登录出错", e);
			result.setMessage("登陆失败。");
		}
		ModelAndView mv = new ModelAndView();
		// mv.addObject("account", StringEscapeUtils.escapeHtml4(account));
		/*mv.addObject("result", result);*/
		mv.setViewName("login");
		return mv;
	}

	private boolean isEmpty(String account, String password) {
		return StringUtils.isEmpty(account) || StringUtils.isEmpty(password);
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie c : cookies) {
				if ("account".equals(c.getName())) {
					c.setMaxAge(0);
					response.addCookie(c);
				}
				if ("password".equals(c.getName())) {
					c.setMaxAge(0);
					response.addCookie(c);
				}
			}
		}
		Subject subject = SecurityUtils.getSubject();
		subject.getSession().removeAttribute("account");
		subject.logout();
		return new ModelAndView("redirect:login");
	}

	@RequestMapping("/list_demo")
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/gateway/system/list");
		return mv;
	}


}
