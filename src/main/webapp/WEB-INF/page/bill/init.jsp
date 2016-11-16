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
			<jsp:param name="nav" value="bill_init" />
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
					<table class="table table-bordered noWrap">
										<tbody><tr>
											<td class="label_td" style="width: 100px;">
												<select class="form-control " style="width: 120px;" name="numtitle">
													<option value="1">运单号</option>
													<option value="2">订单号</option>
													<option value="3">手机号</option>
													<option value="4">工单号</option>
												</select>
											</td>
											<td style="width: 230px;">
												<textarea rows="1" class="form-control" style="width: 200px;" id="name" name="num" placeholder="请选择一种方式"></textarea>
											</td>
											<td class="label_td"><label for="firstname" class="col-sm-2 control-label"> 创建部门</label></td>
											<td>
												<span class="select2 select2-container select2-container--default" dir="ltr" style="width: 200px;"><span class="selection"><span class="select2-selection select2-selection--single" role="combobox" aria-autocomplete="list" aria-haspopup="true" aria-expanded="false" tabindex="0" aria-labelledby="select2-createDep-container"><span class="select2-selection__rendered" id="select2-createDep-container" title="--请选择--"><span class="select2-selection__clear">×</span>--请选择--</span><span class="select2-selection__arrow" role="presentation"><b role="presentation"></b></span></span></span><span class="dropdown-wrapper" aria-hidden="true"></span></span>
											</td>
											<td class="label_td"><label for="firstname" class="col-sm-2 control-label">工单负责人</label></td>
											<td>
												<select class="js-example-basic-single js-states  form-control input-sm select2-hidden-accessible" style="font-size: small; width: 200px;" name="manageUser" tabindex="-1" aria-hidden="true">
													<option value="0">--请选择--</option>

														<option value="546">刘国帅</option>

														<option value="2196661">李佳佳</option>

												</select>
											</td>
										</tr>
										<tr>
										 	<td class="label_td"><label for="firstname" class="col-sm-2 control-label"> 大区</label></td>
                                            <td>
                                                <select id="bindAreaClassify1" class="js-example-basic-single js-states form-control input-sm" style="font-size: small; width: 200px;" name="bindAreaId" selvalue="">
                                                    <option value="-1">请选择大区-</option>
                                                <option value="中南大区">中南大区</option><option value="华东大区">华东大区</option><option value="华中大区">华中大区</option><option value="华北大区">华北大区</option><option value="华南大区">华南大区</option><option value="西北大区">西北大区</option></select>
                                            </td>
                                           <td class="label_td"><label for="firstname" class="col-sm-2 control-label"> 省</label></td>
                                            <td>
                                                <select id="bindPro1" class="js-example-basic-single js-states form-control input-sm" style="font-size: small; width: 200px;" name="provinceId" selvalue="">
                                                    <option value="-1">-请选择省-</option>
                                                </select>
                                            </td>
                                            <td class="label_td"><label for="firstname" class="col-sm-2 control-label"> 市</label></td>
                                            <td>
                                                <select id="bindCity1" class="js-example-basic-single js-states form-control input-sm" style="font-size: small; width: 200px;" name="cityId" selvalue="">
                                                    <option value="-1">-请选择市-</option>
                                                </select>
                                            </td>
                                        </tr>
									</tbody></table>
									</div>

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
								<c:forEach items="${resultModel.data.items}" step="1" var="billInit" >
								<tr data-item-id="${billInit.id}">
									<td style="border-left1: 0.8em solid gray;">${billInit.id}</td>
									<td>${billInit.billType}</td>
									<td>${billInit.businessType}</td>
									<td>${billInit.provinceId}</td>
									<td>${billInit.cityId}</td>
									<td>${billInit.currentBillNum}</td>
									<td>${billInit.surplusAmount}</td>
								</tr>


									<%--<c:forEach items="${resultModel.data.items}" step="1"
										var="apiGroup">
										<tr data-item-id="${apiGroup.id}">
											<td style="border-left1: 0.8em solid gray;">${apiGroup.id}</td>
											<td><a class="aSystemName" data-bind="click:updateSys" href="javascript:void(0)">${apiGroup.groupName}</a></td>
											<td>
											${apiGroup.domainName }</td>
											<td>${apiGroup.groupCode}</td>
											<td><a class="btn btn-default btn-xs btn-success" href="<c:url value="/gateway/apigroup/list?groupid=${apiGroup.id}"></c:url>">${apiGroup.endpointCount}</a></td>
											<td>${apiGroup.authTypeStr}</td>
											&lt;%&ndash;<td>${apiGroup.comment}</td>&ndash;%&gt;
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
														&lt;%&ndash; <a type="button"
															class="btnChangeStatus btn btn-xs btn-success"
															title="分配" data-ajax="true"
															data-ajax-method="Post"
															data-ajax-url="assigned?id=${apiGroup.id }"
															data-ajax-begin="PAGE.onAjaxStart"
															data-ajax-complete="PAGE.onChangStatusAjaxComplete">
															<span class="glyphicon glyphicon-play" aria-hidden="true"></span>
															<span class="btn_title">分配</span>
														</a> &ndash;%&gt;
														&lt;%&ndash;  <a class="btn btn-xs btn-info" data-bind1="click:assignedSys" href="../apigroup/list?groupid=${apiGroup.id}">
														接口管理
														</a> &ndash;%&gt;
													</td>
										</tr>--%>
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