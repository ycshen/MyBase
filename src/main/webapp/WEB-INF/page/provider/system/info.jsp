<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>系统信息</title>

<jsp:include page="../../share/sea-require.jsp">
	<jsp:param name="module" value="pages/provider/system/info" />
</jsp:include>

</head>
<body>
	<div id="main" class="container-fluid">
		<div id="main_content">

			<div id="main_body" style="padding: 0.6em;">

				<div class="panel panel-info">
					<div class="panel-heading">系统信息</div>
					<div class="panel-body">

						<form method="post" data-ajax="true"
							data-ajax-url="<c:url value="/provider/system/save"></c:url>"
							data-ajax-loading="#Loading" data-ajax-loading-duration="1000"
							data-ajax-begin="PAGE.onPostBegin"
							data-ajax-complete="PAGE.onPostComplete">

							<fieldset>
								<input type="hidden" name="id" value="${model.id }">
								<div class="form-group">
									<label for="exampleInputAccount">系统名称</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="systemName" data-valmsg-replace="true"></span><input
										id="exampleInputAccount" name="systemName" required="required"
										type="text" class="form-control" placeholder="系统名称"
										value="${model.systemName }" data-val="true"
										data-val-length="系统名称 1-50字符" data-val-length-min="1"
										data-val-length-max="50" data-val-required="系统名称字段是必需的">
								</div>
								<div class="form-group">
									<label for="exampleInputName">系统编码</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="systemCode" data-valmsg-replace="true"></span><input
										id="exampleInputName" name="systemCode" required="required"
										type="text" class="form-control" placeholder="系统编码"
										value="${model.systemCode }" data-val="true"
										data-val-length="系统编码 1-100个字符" data-val-length-min="1"
										data-val-length-max="100" data-val-required="系统编码字段是必需的"
										data-val-regex="字线数字和下滑线,字母开头"
										data-val-regex-pattern="^[a-zA-Z][a-zA-Z0-9_]{0,49}$">
								</div>
								<div class="form-group">
									<label for="exampleInputDesc">系统状态</label> <br>
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