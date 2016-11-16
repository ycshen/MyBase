package com.brp.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;


public class JdbcRealm extends org.apache.shiro.realm.jdbc.JdbcRealm {


	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken tk = (UsernamePasswordToken) token;
		String account = tk.getPrincipal().toString();
		String password = String.valueOf(tk.getPassword());
		boolean login = false;//dNameService.login(account, password);
		if (login) {
			return new SimpleAuthenticationInfo(account, password, getName());
		} else {
			throw new AuthenticationException("用户名密码错误");
		}
	}
}
