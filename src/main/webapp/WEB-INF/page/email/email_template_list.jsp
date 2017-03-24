<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>邮件模板管理</title>
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
			<jsp:param name="nav" value="list_etemplate" />
		</jsp:include>

		<div id="main_content">

			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span>
					邮件模板
				</div>
			</div>

			<div id="main_body" style="padding: 0.6em;">
			<div class="panel panel-default">

				<form class="form-inline">
					<div class="form-group">
						<label for="txtEmail">测试邮件地址:</label>
						<input type="text" class="form-control" id="txtEmail" placeholder="发送测试邮件地址">
					</div>
					<button onclick="addEmailTemplate();" class="btn btn-default">新增模板</button>
				</form>
			</div>
				<div class="panel panel-default">
					<div class="panel-heading">邮件模板信息</div>

					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>操作</th>
									<th>状态</th>
									<th>模板编号</th>
									<th>模板名称</th>
									<th>模板内容</th>
									<th>主题</th>
									<th>备注</th>
								</tr>
							</thead>
							<tbody >
								<c:forEach items="${emailTemplateQuery.items}" var="emailTemplate">
									<tr>
										<td style="display: none;">${emailTemplate.id}</td>
										<td>
										<a  href="#" onclick="modifyEmailTemplate('${emailTemplate.id}')">修改</a>
										<a  href="#" onclick="switchStatus('${emailTemplate.id}','${emailTemplate.status}')">切换状态</a>
										<a  href="#" onclick="testEmail('${emailTemplate.templateCode}')">发送测试邮箱</a>
										</td>
										<td id="status${emailTemplate.id}">
											<c:choose>
												<c:when test="${emailTemplate.status == 0 }">
													<span class="btn btn-success">启用</span>
												</c:when>
												<c:otherwise>
													<span class="btn btn-warning">禁用</span>
												</c:otherwise>
											</c:choose>
										</td>
										<td>${emailTemplate.templateCode }</td>
										<td>${emailTemplate.templateName}</td>
										<td>
											<a  href="#" onclick="viewTemplateContent('${emailTemplate.id}')">查看模板内容</a>
										</td>
										<td>${emailTemplate.subject}</td>
										<td>${emailTemplate.remark}</td>
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
								<jsp:param name="count" value="${emailTemplateQuery.count }" />
								<jsp:param name="page" value="${emailTemplateQuery.page }" />
								<jsp:param name="size" value="${emailTemplateQuery.size }" />
							</jsp:include>
							
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/js/pages/email/email_template_list.js"></script>

</body>
</html>



