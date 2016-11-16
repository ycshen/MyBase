<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>用户登陆</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<jsp:include page="./share/sea-require.jsp">
	<jsp:param name="module" value="pages/login/main" />
</jsp:include>
<link href="<c:url value="sea-modules/pages/login/style.css"/>" rel="stylesheet">
</head>
<body>

	<!--[if lt IE 9]>
    <div style="background:yellow;text-align:center;padding:10px;">
        您正在使用 Internet Explorer 低版本的过时浏览器访问本页面。
        <br />为更好的浏览本系统，建议您将浏览器升级到
        <a href="http://windows.microsoft.com/en-US/internet-explorer/downloads/ie/" target="_blank">IE9+</a>
        或以下浏览器：<a href="http://www.google.cn/chrome" target="_blank"> Chrome</a>
        / <a href="http://www.firefox.com.cn/download/" target="_blank">Firefox</a>
        / <a href="http://www.apple.com.cn/safari/" target="_blank">Safari</a> / <a href="http://www.Opera.com/">Opera</a>
        <br />如继续使用本浏览器进行访问，如给您带来生理上的不适，作者概不负责！
    </div>
    <![endif]-->

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">面单资源管理</a>
			</div>
		</div>
	</nav>

	<div class="container">
		<form class="form-signin" method="POST" action="login">
			<div class="text-center">
				<img alt="" src='<c:url value="/img/logo.png"/>' style="width: 5em">
			</div>
			<h2 class="form-signin-heading text-center">用户登陆</h2>
			<hr />
			<label for="inputAccount" class="sr-only">用户名</label> <input
				type="text" id="inputAccount" name="account" class="form-control"
				placeholder="用户名" value="${account}" required autofocus> <label
				for="inputPassword" class="sr-only">密码</label> <input
				type="password" id="inputPassword" name="password"
				class="form-control" placeholder="密码" required>
			<div class="checkbox">
				<label> <input type="checkbox" name="remember" value="true">
					记住我
				</label>
			</div>

			<button class="btn btn-lg btn-primary btn-block" type="submit">登
				陆</button>
			<!-- <button class="btn btn-lg btn-primary btn-block" type="submit">登
				陆</button> -->
			<br />
			<c:if test="${result.message != null && result.message != ''}">
				<div class="alert alert-warning" role="alert">${result.message}</div>
			</c:if>
		</form>
	</div>

</body>
</html>