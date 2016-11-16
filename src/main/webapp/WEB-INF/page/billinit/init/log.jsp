<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title></title>

	<jsp:include page="../../share/sea-require.jsp">
		<jsp:param name="module" value="pages/billinit/init/log" />
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
				<div class="panel-heading">面单初始化日志</div>
				<div class="panel-body">
					<form>

						<table border="1">
							<tr>
								<th>起始单号</th>
								<th>结束单号</th>
								<th>单号数量</th>
								<th>操作人</th>
								<th>操作时间</th>
							</tr>
							<c:if test="${resultModel != null }">
								<c:forEach var="billLog" items="${resultModel}">
									<tr>
									<td>${billLog.startNum}</td>
									<td>${billLog.endNum}</td>
									<td>${billLog.amount}</td>
									<td>${billLog.updateUser}</td>
									<td> <fmt:formatDate value="${billLog.updateTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
									</tr>
								</c:forEach>
							</c:if>
							<%--<select id="provinceId" name="provinceId"  class="js-example-basic-single js-states form-control input-sm"
								  data-bind="click:onProvinceChanged"
								  style="font-size: small; width: 90px;" >

								<option value="${provinceVo.id}">${provinceVo.name}</option>

					</select></td>
						<td><label> 城市/区县</label></td>
						<td>
							<select class="js-example-basic-single js-states form-control input-sm"
									id="selectCityId" name="selectCityId" data-bind="click:selectCityId"
									class="form-control"
									style="font-size: small; width: 100px;" >
							</select>
						</td>
								<td>面单业务类型</td>
								<td>
									<select id="selectBusinessType" name="selectBusinessType" data-bind="click:selectBusinessType"
											class="js-example-basic-single js-states form-control input-sm"
											style="font-size: small; width: 100px;">
									</select>
								</td>
								<td>面单类型</td>
								<td>
									<select id="selectBillType" name="selectBillType" data-bind="click:selectBillType"
											class="js-example-basic-single js-states form-control input-sm"
											style="font-size: small; width: 100px;">
										<option value="1" selected="true">纸质面单</option>
										<option value="2">电子面单</option>
									</select>
								</td>
							</tr>--%>
							</table>
						<br/><br/>
						<%--<label>
						<input name="billType" id="billType" type="text" size="3" /></label>
						-
						<label>
						<input name="businessCode"  type="text" size="3" />
						</label>
						-
						<label>
						<input name="district" type="text" size="3" />
						</label>
						-
						<label>
						<input name="startSerialNumber" id="startSerialNumber" type="text" size="10" />
						</label>
						-
						<label>
						<input name="checkCode1" type="text" value="x" size="3" readonly="readonly" /></label><br/>
						<br/>
						<input name="amount" id="amount" size="6" onchange="initEndSerialNumber()" />单
						<br/>
						<br/>
						<label><input name="billType" type="text" size="3" /></label>
						-
						<label><input name="businessCode" type="text" size="3" /></label>
						-
						<label><input name="district" type="text" size="3" /></label>
						-
						<label><input name="endSerialNumber" id="endSerialNumber" type="text" size="10" /></label>
						-
						<label><input name="checkCode2" type="text" value="x" size="3" readonly="readonly" /></label>
						<br/>
						<button type="submit"
								class="btn btn-info">保存</button>
						<button type="le"
								class="btn btn-info">取消</button>--%>
						<%--<fieldset>
							<input type="hidden" name="id"
								   value="${billType.id }">
							<div class="form-group">
								<label for="businessName">面单业务类型</label> <span
									class="field-validation-valid text-danger"
									data-valmsg-for="businessName" data-valmsg-replace="true"></span> <input
									id="businessName" name="businessName" type="text" class="form-control"
									placeholder="面单业务类型" value="${billType.businessName }"
							/>
							</div>
							<div class="form-group">
								<label for="billCode">面单代码</label> <span
									class="field-validation-valid text-danger"
									data-valmsg-for="billCode" data-valmsg-replace="true"></span> <input
									id="billCode" name="billCode" type="text" class="form-control"
									placeholder="面单代码" value="${billType.billCode }"
							/>
							</div>
							<div class="form-group">
								<label for="version">版本号</label> <span
									class="field-validation-valid text-danger"
									data-valmsg-for="version" data-valmsg-replace="true"></span> <input
									id="version" name="version" type="text" class="form-control"
									placeholder="版本号" value="${billType.version }"
							/>
							</div>
							<div class="form-group">
								<label for="color">面单第一联颜色值</label> <span
									class="field-validation-valid text-danger"
									data-valmsg-for="color" data-valmsg-replace="true"></span> <input
									id="color" name="color" type="text" class="form-control"
									placeholder="面单第一联颜色值" value="${billType.version }"/>
							</div>

							<div class="form-group">
								<label >接口状态</label> <span
									class="field-validation-valid text-danger"
									data-valmsg-for="status" data-valmsg-replace="true"></span> <br>
								<c:forEach items="${status}" var="item">
									<label class="radio-inline"> <input type="radio"
																		name="status" value="${item.code }"
																		<c:if test="${billType.status.code==item.code }">checked="checked"</c:if>
																		data-val="true" required="required" data-val-required="请选择状态" />
											${item.desc }
									</label>
								</c:forEach>
							</div>

							<div id="Loading" class="text-center" style="display: none;">
							</div>
							<button type="submit"
									class="btn btn-info btn-block">保存</button>
							<div class="text-center">
								<img id="Loading" class="hide"
									 src="<c:url value="/img/loading.gif"></c:url>" />
							</div>
						</fieldset>--%>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>