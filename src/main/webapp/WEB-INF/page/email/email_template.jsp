<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>邮件模板信息</title>
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
					邮件模板信息
				</div>
			</div>

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">
						邮件模板信息<span class="pull-right"> </span>
					</div>
					<div class="panel-body">
						<div class="form-inline">
							<table class="table">


								<form method="post" id="emailTemplateForm">
									<input type="hidden" name="id" value="${emailTemplate.id}"/>
									<tr>
										<td style="border:0px;text-align:right;">
											<label ><span style="color:red;">*</span>模板编号：</label>
										</td>
										<td style="border:0px;">
											<input name="templateCode" id="txtTemplateCode"
												   value="${emailTemplate.templateCode}"
												   class="form-control" type="text" placeholder="请输入模板编号"
												   style="width: 600px;"
											<c:if test="${emailTemplate.id != null && emailTemplate.id  != ''}">disabled="disabled"</c:if>>
										</td>
									</tr>
									<tr>
										<td style="border:0px;text-align:right;">
											<label ><span style="color:red;">*</span>模板名称：</label>
										</td>
										<td style="border:0px;">
											<input name="templateName" id="txtTemplateName"
												   value="${emailTemplate.templateName}" maxlength="20"
												   class="form-control" type="text" placeholder="请输入模板名称"
												   style="width: 600px;">
										</td>
									</tr>
									<tr>
										<td style="border:0px;text-align:right;">
											<label ><span style="color:red;">*</span>模板内容：</label>
										</td>
										<td style="border:0px;">
											<textarea style="width: 600px;height:300px;" name="templateContent" class="form-control" placeholder="请输入模板内容">${emailTemplate.templateContent}</textarea>
										</td>
									</tr>
									<tr>
										<td style="border:0px;text-align:right;">
											<label ><span style="color:red;">*</span> 模板主题：</label>
										</td>
										<td style="border:0px;">
											<textarea style="width: 600px;" name="subject" class="form-control" placeholder="请输入模板主题">${emailTemplate.subject}</textarea>
										</td>
									</tr>
									<tr>
										<td style="border:0px;text-align:right;">
											<label ><span style="color:red;">*</span> 备注：</label>
										</td>
										<td style="border:0px;">
											<textarea style="width: 600px;" name="remark" class="form-control" placeholder="请输入备注">${emailTemplate.remark}</textarea>
										</td>
									</tr>

									<tr>
										<td style="border:0px;text-align:right;">
											<label ><span style="color:red;">*</span>状态：</label>
										</td>
										<td style="border:0px;">
											<input type="radio" name="status" value="0" checked="checked">启用
											<input type="radio" name="status" value="1">停用
										</td>
									</tr>
								</form>
								<tr>
									<td style="border:0px;">

									</td>
									<td style="border:0px;">
										<button onclick="editEmailTemplate();" class="btn btn-default">确定</button>
										<button onclick="returnEmailTemplate();" class="btn btn-default">返回</button>
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
<script type="text/javascript" src="${ctx}/js/pages/email/email_template.js"></script>

</body>
</html>



