<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	Cookie[] cookies = request.getCookies();
	String nav_panel_state = "";
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			// 获得具体的Cookie
			Cookie cookie = cookies[i];
			// 获得Cookie的名称
			String name = cookie.getName();
			if ("nav_panel_state".equals(name)) {
				String value = cookie.getValue();
				nav_panel_state = "nav_panel_" + value;
			}
		}
	}
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>微服务平台</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath }/aps.ico" >

<jsp:include page="../share/sea-require.jsp">
	<jsp:param name="module" value="pages/domain/list" />
</jsp:include>
</head>
<body>
	<div id="main" class="container-fluid">

		<div id="nav_panel" class="text-center <%=nav_panel_state%>">
			<div id="nav_logo">
				<img class="img-responsive" alt="" tabindex="0"
					style="width: 3em; height: 3em;"
					src="<c:url value="/img/logo.png"/>"> <span>微服务平台</span>
			</div>
			<div id="nav_panel_draw">
				<a href="javascript:void(0)"><span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></a>
			</div>

			<div id="nav_panel_goGroup">
				<a href="<c:url value="/"></c:url>"><span
					class="glyphicon glyphicon-home" aria-hidden="true"></span> </a> <span
					class='title'>主菜单</span>
			</div>

			<div id="nav_ext">
				<a href="<c:url value="/logout"></c:url>" data-toggle="tooltip"
					data-placement="auto" title="【user】退出登陆  "><span
					class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
					${sessionScope.account}</a>
			</div>
			<hr>
			<div id="nav_list" class="scrollbar">
				<ul>
					<li <c:if test="${'gateway'=='gateway'}"> class="current"</c:if>><a
						data-toggle="tooltip" href="<c:url value="/domain/list"/>"
						data-placement="auto right" title="服务网关"><span
							class="glyphicon glyphicon-th" aria-hidden="true"></span>服务网关</a></li>
				</ul>
			</div>
		</div>

		<div id="main_content">

			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
					域名列表
				</div>
			</div>

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">
						域名列表<span class="pull-right">${page }</span>
					</div>
					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>域名</th>
									<th>名称</th>
									<th>URL</th>
								</tr>
							</thead>
							<c:if test="${resultModel.result=='Success'}">
								<tbody>
									<c:forEach items="${resultModel.data.items }" step="1"
										var="domain">
										<tr data-item-id="${domain.endpointId}">
											<td style="border-left1: 0.8em solid gray;">${domain.id}</td>
											<td>${domain.domainName }</td>
											<td>${domain.alias}</td>
											<td><a class="aSystemName" data-bind="click:getInfo"
												href="javascript:void(0)">${domain.url}</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</c:if>
						</table>
					</div>

					<div class="panel-footer" style="padding: 0.3em;">
						<nav class="text-center">
							<jsp:include page="../share/page.jsp">
								<jsp:param name="url" value="?page=" />
								<jsp:param name="count" value="${page.count }" />
								<jsp:param name="page" value="${page.page }" />
								<jsp:param name="size" value="${page.size }" />
							</jsp:include>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>