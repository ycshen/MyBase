<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<title>用户登陆</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/common.css" rel="stylesheet">
<link href="${ctx}/js/pages/login/style.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">企家婆</a>
			</div>
		</div>
	</nav>

	<div class="container">
		<form class="form-signin" method="POST" action="login">
			<div class="text-center">
				<img alt="" src='<c:url value="/img/logo.png"/>' style="width: 5em">
			</div>
			<h2 class="form-signin-heading text-center">用户登陆</h2>
			<table class="table">
				<tr>
					<td style="padding-top: 20px;font-size: 18px;">用户名</td>
					<td> <input type="text" id="inputAccount" name="account" class="form-control"
						placeholder="用户名" value="${account}" required autofocus></td>
				</tr>
				<tr>
					<td style="padding-top: 20px;font-size: 18px;">密码</td>
					<td> <input type="password" id="inputPassword" name="password"
						class="form-control" placeholder="密码" required></td>
				</tr>
				<tr>
					<td> <div class="checkbox">
							<label> <input type="checkbox" name="remember" value="true">
								记住我
							</label>
						</div>
					 </td>
					<td style="text-align: center;"> 
					</span>
						<button class="btn btn-success" type="submit" style="width: 200px;">登 陆</button>
					</td>
				</tr>
			</table>
			
			<br />
			<c:if test="${msg != null && msg != ''}">
				<div class="alert alert-warning" role="alert" style="text-align:center;">${msg}</div>
			</c:if>
		</form>
	</div>

</body>
</html>