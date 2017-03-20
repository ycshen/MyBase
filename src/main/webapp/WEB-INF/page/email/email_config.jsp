<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>邮件配置信息</title>
<link rel="apple-touch-icon" href="<c:url value="/img/aps.ico"></c:url>">
<link rel="icon" href="<c:url value="/img/aps.ico"></c:url>">
<!--[if IE]><link rel="shortcut icon" href="<c:url value="/img/aps.ico"></c:url>"><![endif]-->
<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/common.css" rel="stylesheet">
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
</head>
<body>

	<div id="main" class="container-fluid">

		<jsp:include page="../share/nav_main.jsp">
			<jsp:param name="nav" value="list_email" />
		</jsp:include>

		<div id="main_content">

			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span>
					邮件配置信息
				</div>
			</div>

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">
						邮件配置信息<span class="pull-right"> </span>
					</div>
					<div class="panel-body">
						<div class="form-inline">
							<table class="table">


								<form method="post" id="emailConfigForm">
									<input type="hidden" name="id" value="${emailConfig.id}"/>
									<tr>
										<td style="border:0px;text-align:right;">
											<label ><span style="color:red;">*</span>发送邮箱：</label>
										</td>
										<td style="border:0px;">
											<input name="fromAddress" id="txtFromAddress"
												   value="${emailConfig.fromAddress}"
												   class="form-control" type="text" placeholder="请输入发送邮箱"
												   style="width: 300px;">
										</td>
									</tr>
									<tr>
										<td style="border:0px;text-align:right;">
											<label ><span style="color:red;">*</span>邮件服务器地址：</label>
										</td>
										<td style="border:0px;">
											<input name="mailServerHost" id="txtMailServerHost"
												   value="${emailConfig.mailServerHost}" maxlength="20"
												   class="form-control" type="text" placeholder="请输入邮件服务器地址"
												   style="width: 300px;">
										</td>
									</tr>
									<tr>
										<td style="border:0px;text-align:right;">
											<label ><span style="color:red;">*</span>邮件服务器端口：</label>
										</td>
										<td style="border:0px;">
											<input name="mailServerPort" id="txtMailServerPort"
												   value="${emailConfig.mailServerPort}" maxlength="20"
												   class="form-control" type="text" placeholder="请输入邮件服务器端口"
												   style="width: 300px;">
										</td>
									</tr>
									<tr>
										<td style="border:0px;text-align:right;">
											<label ><span style="color:red;">*</span>用户名：</label>
										</td>
										<td style="border:0px;">
											<input name="userName" id="txtUserName"
												   value="${emailConfig.userName}" maxlength="30"
												   class="form-control" type="text" placeholder="请输入用户名"
												   style="width: 300px;">
										</td>
									</tr>
									<tr>
										<td style="border:0px;text-align:right;">
											<label ><span style="color:red;">*</span>密码：</label>
										</td>
										<td style="border:0px;">
											<input name="password" id="txtPassword"
												   value="${emailConfig.password}" maxlength="20"
												   class="form-control" type="text" placeholder="请输入密码"
												   style="width: 300px;">
										</td>
									</tr>
									<tr>
										<td style="border:0px;text-align:right;">
											<label ><span style="color:red;">*</span>是否验证：</label>
										</td>
										<td style="border:0px;">
											<input type="radio" name="validate" value="1" checked="checked">是
											<input type="radio" name="validate" value="0">否
										</td>
									</tr>
								</form>
								<tr>
									<td style="border:0px;">

									</td>
									<td style="border:0px;">
										<button onclick="editEmailConfig();" class="btn btn-default">确定</button>
										<button onclick="returnEmailConfig();" class="btn btn-default">返回</button>
									</td>
								</tr>
							</table>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/js/pages/email/email_config.js"></script>

</body>
</html>



