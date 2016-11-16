<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="shortcut icon" href="${pageContext.request.contextPath }/aps.ico" >
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>面单资源管理</title>

<jsp:include page="../share/sea-require.jsp">
	<jsp:param name="module" value="pages/bill/type" />
</jsp:include>

</head>
<body>
	<div id="main" class="container-fluid">

		<jsp:include page="../share/nav_main.jsp">
			<jsp:param name="nav" value="bill_type" />
		</jsp:include>

		<div id="main_content">

			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span>
					面单业务类型维护
				</div>
				<ul class="main_navbar_tab">
					<li><a href="javascript:void(0)" data-bind="click: addType"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加类型</a></li>
				</ul>
			</div>

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">面单业务类型列表<span class="pull-right">
					</span></div>
					<div class="panel-body">
									</div>
					
					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>面单业务类型</th>
									<th>面单代码</th>
									<th>版本号</th>
									<th>面单第一联颜色属性
										(用拾色器选择颜色)
									</th>
									<th>状态</th>
									<%--<th>模板</th>--%>
									<th>操作</th>
								</tr>

								</tr>
							</thead>
								<tbody>
									<c:forEach items="${list}" step="1"
										var="billType">
										<tr data-item-id="${billType.id}">
											<td>${billType.businessName}</td>
											<td>${billType.billCode}</td>
											<td>${billType.version}</td>
											<td>${billType.color}</td>
											<td> ${billType.status eq 1 ?"启用" :"停用"}
											<%--	<c:choose>
													<c:when test="${billType.status==1}">
														启用
													</c:when>
													<c:otherwise>
														停用
													</c:otherwise>
												</c:choose>--%>
</td>
											<%--<td><a href="/billtype/download?id=${billType.id}">查看</a>|<a href="ftp://file.wltest.com/brp/${billType.templateFile}">下载</a></td>--%>
											<td>
												<a class="btn btn-xs btn-info" data-bind="click:updateType" href="javascript:void(0)">
													修改
												</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>