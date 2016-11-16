<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>模块信息</title>

<jsp:include page="../../share/sea-require.jsp">
	<jsp:param name="module" value="pages/provider/module/info" />
</jsp:include>

</head>
<body>
	<div id="main" class="container-fluid">
		<div id="main_content">
			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-info">
					<div class="panel-heading">模块信息</div>
					<div class="panel-body">
						<form method="post" data-ajax="true"
							data-ajax-url="<c:url value="/provider/module/save"></c:url>"
							data-ajax-loading="#Loading" data-ajax-loading-duration="1000"
							data-ajax-begin="PAGE.onPostBegin"
							data-ajax-complete="PAGE.onPostComplete">

							<fieldset>
								<input type="hidden" name="id" value="${model.id }">
								<div class="form-group">
									<label for="exampleInputAccount">模块名称</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="groupName" data-valmsg-replace="true"></span><input
										id="exampleInputAccount" name="groupName" required="required"
										type="text" class="form-control" placeholder="模块名称"
										value="${model.groupName }" data-val="true"
										data-val-length="模块名称 3-40" data-val-length-min="3"
										data-val-length-max="40" data-val-required="模块名称是必需的">
								</div>
								<div class="form-group">
									<label for="exampleInputName">所属系统</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="systemId" data-valmsg-replace="true"></span>
									<select name="systemId" class="form-control" data-val="true"
										data-val-length="系统ID必须至少包含 2 个字符" data-val-length-min="1"
										data-val-length-max="100" data-val-required="系统不能为空"
										data-bind="options:tickets,optionsCaption:'请选择',optionsText:'systemName',value:chosenTicket">
										<c:forEach var="item" items="${system}">
											<option value="${item.id }"
												<c:if test="${model.system.id==item.id }">selected="selected"</c:if>
											>${item.systemName }</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputDesc">模块状态</label> <br>
									<c:forEach items="${status}" var="item">
										<label class="radio-inline"> <input type="radio"
											name="status" value="${item.code }"
											<c:if test="${model.status.code==item.code }">checked="checked"</c:if>
											data-val="true" required="required" data-val-required="请选择状态">
											${item.desc }
										</label>
									</c:forEach>
									<span class="field-validation-valid text-danger"
										data-valmsg-for="status" data-valmsg-replace="true"></span>
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