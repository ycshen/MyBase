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
	<jsp:param name="module" value="pages/gateway/system/list" />
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
					<span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span>
					接入系统管理
				</div>
				<ul class="main_navbar_tab">
					<jsp:include page="../main_navbar_tab.jsp">
						<jsp:param name="nav" value="system" />
					</jsp:include>
					<li><a href="javascript:void(0)" data-bind="click: addApi"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加系统</a></li>
				</ul>
			</div>

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">接入系统列表<span class="pull-right">
					</span></div>
					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>名称</th>
									<th>域名</th>
									<th>编码</th>
									<th>接口数</th>
									<th>认证方式</th>
									<%--<th>备注</th>--%>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<c:if test="${resultModel.result=='Success'}">
								<tbody>
									<c:forEach items="${resultModel.data.items}" step="1"
										var="apiGroup">
										<tr data-item-id="${apiGroup.id}">
											<td style="border-left1: 0.8em solid gray;">${apiGroup.id}</td>
											<td><a class="aSystemName" data-bind="click:updateSys" href="javascript:void(0)">${apiGroup.groupName}</a></td>
											<td>
											${apiGroup.domainName }</td>
											<td>${apiGroup.groupCode}</td>
											<td><a class="btn btn-default btn-xs btn-success" href="<c:url value="/gateway/apigroup/list?groupid=${apiGroup.id}"></c:url>">${apiGroup.endpointCount}</a></td>
											<td>${apiGroup.authTypeStr}</td>
											<%--<td>${apiGroup.comment}</td>--%>
											<td class="tdstatus"> 已${apiGroup.status.desc}</td>
											<td> 
											<c:choose>
													<c:when test="${apiGroup.status.code == '1'}">
														<a type="button"
															class="btnChangeStatus btn btn-xs btn-danger"
															title="${apiGroup.status.desc}" data-ajax="true"
															data-ajax-method="Post"
															data-ajax-url="saveOrUpdate?id=${apiGroup.id }&status=0&flag=1"
															data-ajax-begin="PAGE.onAjaxStart"
															data-ajax-complete="PAGE.onChangStatusAjaxComplete">
															<span class="glyphicon glyphicon-pause"
															aria-hidden="true"></span> <span class="btn_title">停用</span>
														</a>
													</c:when>
													<c:otherwise>
														<a type="button"
															class="btnChangeStatus btn btn-xs btn-success"
															title="${apiGroup.status.desc}" data-ajax="true"
															data-ajax-method="Post"
															data-ajax-url="saveOrUpdate?id=${apiGroup.id }&status=1&flag=1"
															data-ajax-begin="PAGE.onAjaxStart"
															data-ajax-complete="PAGE.onChangStatusAjaxComplete">
															<span class="glyphicon glyphicon-play" aria-hidden="true"></span>
															<span class="btn_title">启用</span>
														</a>
													</c:otherwise>
												</c:choose>
											
												<a type="button"
													<c:choose>
														<c:when test="${apiGroup.enableDelete }">
															data-ajax="true" data-ajax-confirm="确认要删除该系统吗？"
															data-ajax-method="Post"
															data-ajax-url="del?id=${apiGroup.id}"
															data-ajax-begin="PAGE.onAjaxStart"
															data-ajax-complete="PAGE.onDeleteComplete"
															class="btn btn-danger btn-xs"
														</c:when>
														<c:otherwise>
															data-toggle="tooltip" data-placement="left" title="该网关下关连有接口，清空后才能删除"
															class="btn btn-danger btn-xs" disabled="disabled"
														</c:otherwise>
													</c:choose>>
													<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
													删除
													</a>
														<%-- <a type="button"
															class="btnChangeStatus btn btn-xs btn-success"
															title="分配" data-ajax="true"
															data-ajax-method="Post"
															data-ajax-url="assigned?id=${apiGroup.id }"
															data-ajax-begin="PAGE.onAjaxStart"
															data-ajax-complete="PAGE.onChangStatusAjaxComplete">
															<span class="glyphicon glyphicon-play" aria-hidden="true"></span>
															<span class="btn_title">分配</span>
														</a> --%>
														<%--  <a class="btn btn-xs btn-info" data-bind1="click:assignedSys" href="../apigroup/list?groupid=${apiGroup.id}">
														接口管理
														</a> --%>
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