<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<jsp:param name="module" value="pages/provider/endpoint/list" />
</jsp:include>

</head>
<body>
	<div id="main" class="container-fluid">

		<jsp:include page="../../share/nav_main.jsp">
			<jsp:param name="nav" value="provider" />
		</jsp:include>

		<div id="main_content">
			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-indent-right" aria-hidden="true"></span>
					接口管理
				</div>

				<ul class="main_navbar_tab">

					<jsp:include page="../main_navbar_tab.jsp">
						<jsp:param name="nav" value="endpoint" />
					</jsp:include>
					<li><a href="javascript:void(0)"
						data-bind="click: addEndpoint"><span
							class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加接口</a></li>
				</ul>
			</div>

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">
						接口列表 <c:if test="${not empty resultModel.data.params.systemName }">[${resultModel.data.params.systemName }]</c:if>
								<c:if test="${not empty resultModel.data.params.moduleName }">- [${resultModel.data.params.moduleName }]</c:if>
						 <span class="pull-right"> ${page}</span>
					</div>
					<div class="table-responsive">
						<table id="endpointlist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>系统名称</th>
									<th>模块名称</th>
									<th>URL</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<c:if test="${resultModel.result=='Success'}">
								<tbody>
									<c:forEach items="${resultModel.data.items }" step="1"
										var="endpoint">
										<tr data-item-id="${endpoint.id }">
											<td style="border-left1: 0.8em solid gray;">${endpoint.id }</td>
											<td><a href="list?systemId=${endpoint.module.system.id }">${endpoint.module.system.systemName }</a></td>
											<td><a href="list?moduleId=${endpoint.module.id }">${endpoint.module.groupName}</a></td>
											<td><a class="aModule" data-bind="click:updateEndpoint"
												href="javascript:void(0)">${endpoint.url }</a></td>
											<td class="tdstatus">已${endpoint.status.desc}</td>
											<td><c:choose>
													<c:when test="${endpoint.status.code == '1'}">
														<a type="button"
															class="btnChangeStatus btn btn-xs btn-danger"
															title="${endpoint.status.desc}" data-ajax="true"
															data-ajax-method="Post"
															data-ajax-url="change/${endpoint.id}?status=0"
															data-ajax-begin="PAGE.onAjaxStart"
															data-ajax-complete="PAGE.onChangStatusAjaxComplete">
															<span class="glyphicon glyphicon-pause"
															aria-hidden="true"></span> <span class="btn_title">停用</span>
														</a>
													</c:when>
													<c:otherwise>
														<a type="button"
															class="btnChangeStatus btn btn-xs btn-success"
															title="${endpoint.status.desc}" data-ajax="true"
															data-ajax-method="Post"
															data-ajax-url="change/${endpoint.id}?status=1"
															data-ajax-begin="PAGE.onAjaxStart"
															data-ajax-complete="PAGE.onChangStatusAjaxComplete">
															<span class="glyphicon glyphicon-play" aria-hidden="true"></span>
															<span class="btn_title">启用</span>
														</a>
													</c:otherwise>
												</c:choose> <a type="button"
												<c:choose>
														<c:when test="${endpoint.enableDelete }">
															class="btn btn-danger btn-xs"
															data-ajax="true"
															data-ajax-confirm="确认要删除该接口吗？" data-ajax-method="Post"
															data-ajax-url="del/${endpoint.id}"
															data-ajax-begin="PAGE.onAjaxStart"
															data-ajax-complete="PAGE.onDeleteComplete"
														</c:when>
														<c:otherwise>
															class="btn btn-danger btn-xs" disabled="disabled"
															data-toggle="tooltip" data-placement="left"
																 title="该接口使用中，不能删除"
														</c:otherwise>
													</c:choose>>
													<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
													删除
											</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</c:if>
						</table>
					</div>

					<div class="panel-footer" style="padding: 0.3em;">
						<nav class="text-center">
							<jsp:include page="../../share/page.jsp">
								<jsp:param name="url" value="?systemId=${page.params.systemId}&page=" />
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