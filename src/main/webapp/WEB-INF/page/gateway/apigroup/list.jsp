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
<title>微服务平台</title>

<jsp:include page="../../share/sea-require.jsp">
	<jsp:param name="module" value="pages/gateway/apigroup/list" />
</jsp:include>
</head>
<body>
	<div id="main" class="container-fluid">

		<jsp:include page="../../share/nav_main.jsp">
			<jsp:param name="nav" value="gateway" />
		</jsp:include>

		<div id="main_content">

			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-indent-right" aria-hidden="true"></span>
					关连接口列表
				</div>
				<ul class="main_navbar_tab">
					<jsp:include page="../main_navbar_tab.jsp">
						<jsp:param name="nav" value="api" />
					</jsp:include>
					<li><a href="javascript:void(0)" data-bind="click: assigned"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>关连接口</a></li>
				</ul>
			</div>

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">接口系统列表<c:if test="${not empty resultModel.data.params.groupName }">[${resultModel.data.params.groupName }]</c:if>
					<span class="pull-right">${page}</span></div>
					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>域名</th>
									<th>别名</th>
									<th>名称</th>
									<th>请求方式</th>
									<th>调用情况：成功-失败-总次</th>
									<th>操作</th>
								</tr>
							</thead>
							<c:if test="${resultModel.result=='Success'}">
								<tbody class="tbody">
									<c:forEach items="${resultModel.data.items}" step="1"
										var="apiModel">
										 <tr data-item-id="${apiModel.id}">
											<td style="border-left1: 0.8em solid gray;" class="td">${apiModel.id}</td>
											<td > <a title="${ apiModel.url}" class="aSystemName" data-bind="click:updateSys" href="javascript:void(0)"> 
											${apiModel.domainName }</a></td>
											<%-- <td  >${apiModel.apiGroup.groupCode}</td> --%>
											<td>${apiModel.alias}</td>
											<td>${apiModel.groupName}</td>
											<td>${apiModel.requestTypeList}</td>
											<td>5次</td>
											<%-- <td class="tdstatus"> 已${apiGroup.status.desc}</td> --%>
											<td>
											<a type="button"
													data-ajax="true" data-ajax-confirm="确认要删除该系统接口吗？"
													data-ajax-method="Post"
													data-ajax-url="del?id=${apiModel.id}"
													data-ajax-begin="PAGE.onAjaxStart"
													data-ajax-complete="PAGE.onDeleteComplete"
													class="btn btn-danger btn-xs">
													<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
													删除
													</a> 
											</td>
											</tr>
									</c:forEach>
								</tbody>
							</c:if>
						</table>
					</div>
					<div class="panel-footer" style="padding: 0.3em;">
						<nav class="text-center">
							<jsp:include page="../../share/page.jsp">
								<jsp:param name="url" value="?groupid=${page.params.groupId}&page=" />
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