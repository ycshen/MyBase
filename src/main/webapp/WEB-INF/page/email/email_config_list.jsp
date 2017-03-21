<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>邮件配置管理</title>
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
					邮件配置
				</div>
			</div>

			<div id="main_body" style="padding: 0.6em;">
			<div class="panel panel-default">
					<button onclick="addEmailConfig();" class="btn btn-default">新增配置</button>
			</div>
				<div class="panel panel-default">
					<div class="panel-heading">邮件配置信息</div>

					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>操作</th>
									<th>状态</th>
									<th>发送邮箱</th>
									<th>邮件服务器地址</th>
									<th>邮件服务器端口</th>
									<th>用户名</th>
									<th>密码</th>
									<th>是否校验</th>
								</tr>
							</thead>
							<tbody >
								<c:forEach items="${emailConfigQuery.items}" var="emailConfig">
									<tr>
										<td style="display: none;">${emailConfig.id}</td>
										<td>
										<a  href="#" onclick="modifyEmailConfig('${emailConfig.id}')">修改</a>
										<a  href="#" onclick="switchStatus('${emailConfig.id}','${emailConfig.status}')">切换状态</a>
										<a  href="#" onclick="deleteConfig('${emailConfig.id}')">发送测试邮箱</a>
										</td>
										<td id="status${emailConfig.id}">
											<c:choose>
												<c:when test="${emailConfig.status == 1 }">
													<span class="btn btn-success">启用</span>
												</c:when>
												<c:otherwise>
													<span class="btn btn-warning">禁用</span>
												</c:otherwise>
											</c:choose>
										</td>
										<td>${emailConfig.fromAddress }</td>
										<td>${emailConfig.mailServerHost}</td>
										<td>${emailConfig.mailServerPort}</td>
										<td>${emailConfig.userName}</td>
										<td>${emailConfig.password}</td>
										<td>
											<c:choose>
												<c:when test="${emailConfig.validate == 1 }">
													是
												</c:when>
												<c:otherwise>
													否
												</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="panel-footer" style="padding: 0.3em;">
						<nav class="text-center">
							<jsp:include page="../share/page.jsp">
								<jsp:param name="url"
									value="?page=" />
								<jsp:param name="count" value="${emailConfigQuery.count }" />
								<jsp:param name="page" value="${emailConfigQuery.page }" />
								<jsp:param name="size" value="${emailConfigQuery.size }" />
							</jsp:include>
							
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/js/pages/email/email_config_list.js"></script>

</body>
</html>



