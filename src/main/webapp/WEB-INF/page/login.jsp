<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<title>用户登陆</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link href="${ctx}/js/pages/login/style.css" rel="stylesheet">
</head>
<body>
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
				placeholder="用户名" value="${account}" required autofocus>
				<br/>
				 <label
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