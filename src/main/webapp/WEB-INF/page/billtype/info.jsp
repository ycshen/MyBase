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
	<jsp:param name="module" value="pages/billtype/info" />
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
					<div class="panel-heading">面单类型</div>
					<div class="panel-body">
						<form method="post" <%--action="<c:url value="/bill/type/saveOrUpdate"></c:url>"--%>
							data-ajax-url="<c:url value="/bill/type/saveOrUpdate"></c:url>"
							  data-ajax="true"
							data-ajax-loading="#Loading" data-ajax-loading-duration="1000"
							data-ajax-begin="PAGE.onPostBegin"
							data-ajax-complete="PAGE.onPostComplete"> <%--enctype="multipart/form-data" >--%>

							<fieldset>
								 <input type="hidden" name="id"
									value="${billType.id }">
								<div class="form-group">
									<label for="businessName">面单业务类型</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="businessName" data-valmsg-replace="true"></span><input
										id="businessName" name="businessName" required="required"
										type="text" class="form-control" placeholder="面单业务类型"
										value="${billType.businessName }" data-val="true"
										data-val-length="面单业务类型 1-30字符" data-val-length-min="1"
										data-val-length-max="30" data-val-required="面单业务类型不能为空"/>


									<%--<label for="businessName">面单业务类型</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="businessName" data-valmsg-replace="true" data-val="true"
										data-val-length-max="30" data-val-required="面单业务类型"></span> <input
										id="businessName" name="businessName" type="text" required="required"
										class="form-control" value="${billType.businessName }"
										data-val-length="面单业务类型 1-30字符" data-val-length-min="1"
										data-val-length-max="30" data-val-required="面单业务类型不能为空"
										placeholder="面单业务类型"/>--%>
								</div>
								<div class="form-group">
									<label for="billCode">面单代码</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="billCode" data-valmsg-replace="true"></span><input
										id="billCode" name="billCode" required="required"
										type="text" class="form-control" placeholder="面单代码"
										value="${billType.billCode }" data-val="true" readonly="readonly"
										data-val-length="面单代码只能输入1位数字" data-val-length-min="1"
										data-val-length-max="1" data-val-required="面单代码不能为空"/>
									<%--<label for="billCode">面单代码</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="billCode" data-valmsg-replace="true"></span> <input
										id="billCode" name="billCode" type="text" class="form-control"
										placeholder="面单代码" value="${billType.billCode }"
										 />--%>
								</div>
								<div class="form-group">
									<label for="version">版本号</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="version" data-valmsg-replace="true"></span> <input
										id="version" name="version" type="text" class="form-control" readonly="readonly"
										placeholder="版本号" value="${billType.version }"
										 />
								</div>
								<div class="form-group">
									<label for="color">面单第一联颜色值</label>
									<span
										class="field-validation-valid text-danger"
										data-valmsg-for="color" data-valmsg-replace="true"></span>
									<table id="table" class="table table-bordered">
											<tr>
												<td><input class="text-danger" name="color" readonly="readonly"
														   placeholder="面单第一联颜色值" id="222"
														   type="text"  value="${billType.color}" style="background-color: ${billType.color}" />
														   <input id="color" style="position:absolute;left:3000px;" type="color"/>
													<input type="button" data-bind="click:selectColor"  value="选择颜色" />
													<%--<button id="aa" data-bind="click:selectColor">选择颜色</button>--%></td>
											</tr>

									</table>
								</div>



								<%--<div class="form-group">
									<label for="color">模板</label>
										<span class="field-validation-valid text-danger"
												data-valmsg-for="picture" data-valmsg-replace="true"></span>
									<input id="picture" name="picture" type="file" class="form-control"
												placeholder="" value="${billType.templatePicture }"/>
										&lt;%&ndash;<input name="picture" class="itl-input" type="file">&ndash;%&gt;
										<span>请选.jpg或.png文件</span>
								<label class="lb itl-lb"></label>
								<span class="field-validation-valid text-danger"
									  data-valmsg-for="compress" data-valmsg-replace="true"></span>
									<input id="compress" name="compress" type="file" class="form-control"
										   placeholder="" value="${billType.templateFile }"/>
									&lt;%&ndash;<input name="compress" class="itl-input" type="file">&ndash;%&gt;
									<span>请选择.psd文件</span>
								</li>
								</div>--%>

								<div class="form-group">

									<label for="status">状态</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="status" data-valmsg-replace="true"></span> <br>
										<c:if test="${billType.id != null}">
										<input type="hidden" name="status" value="${billType.status}" />
										</c:if>
											<c:forEach items="${status}" var="item">
												<label class="radio-inline">
													<input type="radio"	name="status" value="${item.code }"
													<c:if test="${billType.id != null}"> disabled="disabled" </c:if>
														   <c:if test="${billType.status==item.code }">checked="checked"</c:if>
														   data-val="true" required="required" data-val-required="请选择状态">
													${item.desc }
											</label>
											</c:forEach>
									<%--<span class="field-validation-valid text-danger"
										  data-valmsg-for="status" data-valmsg-replace="true"></span>--%>
										<%--<label class="radio-inline">
											<input value="1" name="status" type="radio" data-val="true" required="required" data-val-required="请选择状态">
											<label >启用</label>
											<input value="0" name="status" class="itl-input" type="radio">
											<label >禁用</label>
										</label>--%>

								</div>

								<%--<div class="form-group">
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
								</div>--%>
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
							<%--	<div class="form-group">
									<label for="comment">接口说明</label> <span
										class="text-danger field-validation-valid"
										data-valmsg-for="comment" data-valmsg-replace="true"></span>
									<script id="container" name="comment" type="text/plain">
        								${endpoint.comment }
									</script>
								</div>--%>


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
<%--<script type="text/javascript">
	document.getElementById('btn').onclick = function(){
		document.getElementById('color').click();
	};

	document.getElementById('color').onchange = function(){
		document.body.style.background = this.value;
	};

</script>--%>

</html>