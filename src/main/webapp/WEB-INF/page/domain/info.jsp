<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>接口信息</title>

<jsp:include page="../share/sea-require.jsp">
	<jsp:param name="module" value="pages/domain/info" />
</jsp:include>
<style type="text/css">
input select {
	display: none;
}
</style>
</head>
<body>
	<div id="main" class="container-fluid">
		<div id="main_content">
			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-info">
					<div class="panel-heading">接口信息</div>
					<div class="panel-body">
						<form method="post" data-ajax="true" data-bind="submit: preData"
							data-ajax-url="<c:url value="/provider/endpoint/save"></c:url>"
							data-ajax-loading="#Loading" data-ajax-loading-duration="1000"
							data-ajax-begin="PAGE.onPostBegin"
							data-ajax-complete="PAGE.onPostComplete">

							<fieldset>
								<input type="hidden" id="paramList" name="paramList"
									data-bind="value:argsJson" /> <input type="hidden" name="id"
									value="${endpoint.id }">
								<div class="form-group">
									<label for="name">接口名称</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="name" data-valmsg-replace="true"></span> <input
										id="name" name="name" type="text" class="form-control"
										placeholder="接口名称" value="${endpoint.name }"
										disabled="disabled" />
								</div>
								<div class="form-group">
									<label for="url">接口地址</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="url" data-valmsg-replace="true"></span> <input
										id="url" name="url" type="text" class="form-control"
										placeholder="接口地址" value="${endpoint.url }"
										disabled="disabled" />
								</div>
								<div class="form-group">
									<label for="requestTypeList">请求类型</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="requestTypeList" data-valmsg-replace="true"></span>
									<select name="requestTypeList"
										class="js-example-basic-multiple form-control"
										disabled="disabled" multiple="multiple">
										<c:forEach var="rt" items="${endpoint.requestTypeList}">
											<option selected="selected">${rt.name }</option>
										</c:forEach>
									</select>
								</div>
								<%-- <div class="form-group">
									<label for="exampleInputName">所属系统</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="systemId" data-valmsg-replace="true"></span>
									<select id="systemChange" data-bind="click:loadModule"
										name="systemId" class="form-control" data-val="true"
										data-val-length-max="100" data-val-required="系统不能为空">
										<c:forEach var="item" items="${systems}">
											<option value="${item.id }"
												<c:if test="${endpoint.module.system.id == item.id }">selected="selected"</c:if>>${item.systemName}</option>
										</c:forEach>
									</select>
								</div> --%>
								<%-- <div class="form-group">
									<label for="exampleInputName">所属模块</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="moduleId" data-valmsg-replace="true"></span>

									<select id="moduleId" name="moduleId" class="form-control"
										data-val="true" data-val-required="所属模块不能为空">
										<c:forEach var="module" items="${modules }">
											<option value="${module.id }"
												<c:if test="${endpoint.module.id == module.id }">selected="selected"</c:if>>${module.groupName }</option>
										</c:forEach>
									</select>
								</div> --%>
								<%-- <div class="form-group">
									<label for="exampleInputDesc">接口状态</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="status" data-valmsg-replace="true"></span> <br>
									<c:forEach items="${status}" var="item">
										<label class="radio-inline"> <input type="radio"
											name="status" value="${item.code }"
											<c:if test="${endpoint.status.code==item.code }">checked="checked"</c:if>
											data-val="true" required="required" data-val-required="请选择状态" />
											${item.desc }
										</label>
									</c:forEach>
								</div> --%>
								<div class="form-group">
									<label for="comment">接口说明</label> <span
										class="text-danger field-validation-valid"
										data-valmsg-for="comment" data-valmsg-replace="true"></span>
									<script id="container" name="comment" type="text/plain">
        								${endpoint.comment }
									</script>
								</div>

								<div class="form-group">
									<label for="parm">接口参数</label> <span
										class="text-danger field-validation-valid"
										data-valmsg-for="parm" data-valmsg-replace="true"></span>
									<!-- <input
										type="button" class="btn btn-info btn-xs" name="add" id="add" data-bind="click:initTable"
										value="增加" /> -->

									<table id="table2" style="width: 700px;border: solid #31708f 1px;">
										<tbody>
											<tr>
												<th>参数</th>
												<th>类型</th>
												<th>说明</th>
											</tr>
											<c:forEach var="endpointParamer"
												items="${endpoint.endpointParameterList}">
												<tr name="parmtr">
													<td>${endpointParamer.parameterName}</td>
													<td>${endpointParamer.parameterType}</td>
													<td>${endpointParamer.parameterDesc}</td>
													<!-- <td><button class="btn btn-danger btn-xs"
															onclick="deltr(this)">删除</button></td> -->
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>

								<div id="Loading" class="text-center" style="display: none;">
								</div>
								<!-- <button type="submit" 
									class="btn btn-info btn-block">保存</button> -->
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