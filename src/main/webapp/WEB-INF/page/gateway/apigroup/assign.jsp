<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>接口信息</title>

<jsp:include page="../../share/sea-require.jsp">
	<jsp:param name="module" value="pages/gateway/apigroup/assign" />
</jsp:include>

</head>
<body>
	<div id="main" class="container-fluid">
		<div id="main_content">
			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-info">
					<div class="panel-heading">接口信息</div>
					<div class="panel-body">
						<form method="post" data-ajax="true"
							data-ajax-url="<c:url value="/gateway/apigroup/save"></c:url>"
							data-ajax-loading="#Loading" data-ajax-loading-duration="1000"
							data-ajax-begin="PAGE.onPostBegin"
							data-ajax-complete="PAGE.onPostComplete">

							<fieldset>
								<input type="hidden" name="id" value="${model.id }">
								<%--<input type="hidden" name="endpointId" value="${model.endpointId }">
								<input type="hidden" name="groupId" value="${model.groupId }">--%>
								<c:if test="${model.id>0 }">
									<div class="form-group">
										<label for="groupName">接入系统</label> <input disabled="disabled"
											id="groupName" name="groupName" type="text"
											class="form-control" value="${model.groupName}" />
									</div>
									<div class="form-group">
										<label for="endpointName">业务接口</label> <input
											disabled="disabled" id="endpointName" name="endpointName"
											type="text" class="form-control" value="${model.url}" />
									</div>
								</c:if>
								<c:if test="${model.id==null}">
									<div class="form-group">
										<label for="groupId">接入系统</label> <span
											class="field-validation-valid text-danger"
											data-valmsg-for="groupId" data-valmsg-replace="true"></span><select
											id="groupId" name="groupId" class="form-control"
											data-val="true" data-val-length-max="100"
											data-val-required="接入系统不能为空">
											<option value="">请选择</option>
											<c:forEach var="item" items="${apiGroup}">
												<option value="${item.id }"
													<c:if test="${groupid == item.id }">selected="selected"</c:if>>${item.groupName}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label for="systemId">业务系统</label> <span
											class="field-validation-valid text-danger"
											data-valmsg-for="systemId" data-valmsg-replace="true"></span>
										<select id="systemId"
											data-bind="value:choosenSystem,event: { change: onSystemChanged}"
											name="systemId" class="form-control" data-val="true"
											data-val-length-max="100" data-val-required="业务系统不能为空">
											<c:forEach var="item" items="${systems}">
												<option value="${item.id }"
													<c:if test="${endpoint.module.system.id == item.id }">selected="selected"</c:if>>${item.systemName}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label for="moduleId">业务模块</label> <span
											class="field-validation-valid text-danger"
											data-valmsg-for="moduleId" data-valmsg-replace="true"></span>

										<select id="moduleId"
											data-bind="options: moduleArray,
							                       optionsText: 'groupName',
							                       optionsValue: 'id',
							                       value: choosenModule,
							                       optionsCaption: '请选择',
							                       event: { change: onModuleChanged}"
											name="moduleId" class="form-control" data-val="true"
											data-val-required="业务模块不能为空">
											<c:forEach var="module" items="${modules }">
												<option value="${module.id }"
													<c:if test="${endpoint.module.id == module.id }">selected="selected"</c:if>>${module.groupName }</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label for="endpointId">业务接口</label> <span
											class="field-validation-valid text-danger"
											data-valmsg-for="endpointId" data-valmsg-replace="true"></span>

										<select id="endpointId"
											data-bind="options: endpointArray,
							                       optionsText: 'url',
							                       optionsValue: 'id',
							                       value: choosenEndpoint,
							                       optionsCaption: '请选择',
							                       event: { change: onEntityChanged}"
											name="endpointId" class="form-control" data-val="true"
											data-val-required="业务接口不能为空">
											<c:forEach var="module" items="${modules }">
											<%--<c:forEach var="endpointParamer" items="${module.endpointConfigList}">
											${endpointParamer}
											</c:forEach>--%>
												<option value="${module.id }"
													<c:if test="${endpoint.module.id == module.id }">selected="selected"</c:if>>${module.groupName}</option>
											</c:forEach>
										</select>
									</div>
								</c:if>
								<div class="form-group">
									<label for="alais">匹配正则表达式</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="alias" data-valmsg-replace="true"></span> <input
										id="alias" name="alias" required="required" type="text"
										class="form-control" placeholder="匹配正则表达式" value="${model.alias}"
										data-val="true" data-val-length="长度范围1-255"
										data-val-length-min="1" data-val-length-max="255"
										data-val-required="匹配正则表达式不能为为空"/>
								</div>

								<div class="form-group">
									<label for="document">接口说明文档</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="document" data-valmsg-replace="true"></span>
									<script id="document" name="document" type="text/plain">
        								${model.document}
									</script>
								</div>
								<div class="form-group">
									<label for="parm">接口参数</label> <span
										class="text-danger field-validation-valid"
										data-valmsg-for="parm" data-valmsg-replace="true"></span>
									<table id="table2" class="table table-bordered">
										<tbody>

										<c:if test="${model.id>0 }">
											<tr>
												<th>参数</th>
												<th>类型</th>
												<th>说明</th>
											</tr>
										<c:forEach var="endpointParamer" items="${endpoint.endpointParameterList}">
											<tr name="parmtr">
												<td>${endpointParamer.parameterName}</td>
												<td>${endpointParamer.parameterType}</td>
												<td>${endpointParamer.parameterDesc}</td>
											</tr>
										</c:forEach>
										</c:if>
										</tbody>
									</table>
								</div>

								<div id="Loading" class="text-center" style="display: none;">
									<!-- <img src='img/loading.gif' /> -->
								</div>

								<button type="submit" class="btn btn-info btn-block">保存</button>
								<div class="text-center">
									<img id="Loading" class="hide"
										src="<c:url value="/img/loading.gif"></c:url>" />
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>