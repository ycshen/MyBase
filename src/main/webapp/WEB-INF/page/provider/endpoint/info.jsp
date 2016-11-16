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
	<jsp:param name="module" value="pages/provider/endpoint/info" />
</jsp:include>

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
								<input type="hidden" id="paramList" name="paramList" data-bind="value:argsJson" />
								<input type="hidden" name="id" value="${endpoint.id }">
								<div class="form-group">
									<label for="name">接口名称</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="name" data-valmsg-replace="true"></span> <input
										id="name" name="name" required="required" type="text"
										class="form-control" placeholder="接口名称"
										value="${endpoint.name }" data-val="true"
										data-val-length="名称 3-50" data-val-length-min="3"
										data-val-length-max="50" data-val-required="名称不能为空" />
								</div>
								<div class="form-group">
									<label for="url">接口地址</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="url" data-valmsg-replace="true"></span> <input
										id="url" name="url" required="required" type="text"
										class="form-control" placeholder="接口地址"
										value="${endpoint.url }" data-val="true"
										data-val-length="地址长度为1-200" data-val-length-min="1"
										data-val-length-max="200" data-val-required="地址不能为空"
										data-val-regex="字线数字和下滑线,字母开头" data-val-regex-pattern="[^\s]*" />
								</div>
								<div class="form-group">
									<label for="requestTypeList">请求类型</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="requestTypeList" data-valmsg-replace="true"></span>
									<select name="requestTypeList" required="required"
										class="js-example-basic-multiple form-control" data-val="true"
										multiple="multiple" data-bind="optionCaption:'请选择'"
										data-val-required="请求类型为空">
										<c:forEach var="item" items="${requestType}">
											<option value="${item.code }"
												<c:forEach var="rt" items="${endpoint.requestTypeList}">
												<c:if test="${rt.code==item.code }">selected="selected"</c:if>
											</c:forEach>>${item.name }</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputName">所属系统</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="systemId" data-valmsg-replace="true"></span>
									<select id="systemChange" data-bind="click:onSystemChanged"
										name="systemId" class="form-control" data-val="true"
										data-val-length-max="100" data-val-required="系统不能为空">
										<c:forEach var="item" items="${systems}">
											<option value="${item.id }"
												<c:if test="${endpoint.module.system.id == item.id }">selected="selected"</c:if>>${item.systemName}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
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
								</div>
								<div class="form-group">
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
								</div>
								<div class="form-group">
									<label for="comment">接口说明</label>
									<span class="text-danger field-validation-valid" data-valmsg-for="comment" data-valmsg-replace="true"></span>					
									<script id="container" name="comment" type="text/plain">
        								${endpoint.comment }
									</script>
								</div>

								<div class="form-group">
									<label for="parm">接口参数</label> <span
										class="text-danger field-validation-valid" 
										data-valmsg-for="parm" data-valmsg-replace="true"></span> <input
										type="button" class="btn btn-info btn-xs" name="add" id="add" data-bind="click:initTable"
										value="增加" />

									<table id="table2" class="table table-bordered">
										<tbody>
											<tr>
												<th>参数</th>
												<th>类型</th>
												<th>说明</th>
												<th>操作</th>
											</tr>
											<c:forEach var="endpointParamer"
												items="${endpoint.endpointParameterList}">
												<tr name="parmtr">
													<td><input class="form-control input-sm" name="parameterName"
														value="${endpointParamer.parameterName}" /></td>
													<td><input class="form-control input-sm" name="parameterType"
														value="${endpointParamer.parameterType}" /></td>
													<td><input class="form-control input-sm" name="parameterDesc"
														value="${endpointParamer.parameterDesc}" /></td>
													<td><button class="btn btn-danger btn-xs"
															onclick="deltr(this)">删除</button></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>

								<div id="Loading" class="text-center" style="display: none;">
								</div>
								<button type="submit" 
									class="btn btn-info btn-block">保存</button>
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