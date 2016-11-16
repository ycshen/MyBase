<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title></title>

	<jsp:include page="../../share/sea-require.jsp">
		<jsp:param name="module" value="pages/billinit/init/init" />
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
				<div class="panel-heading">电子面单初始化</div>
				<div class="panel-body">
					<form method="post" data-ajax="true"
					data-ajax-url="<c:url value="/billinit/saveBillInit"></c:url>"
                    data-ajax-loading="#Loading" data-ajax-loading-duration="1000"
                    data-ajax-begin="PAGE.onPostBegin"
                    data-ajax-complete="PAGE.onPostComplete" >

						<c:if test="${billInitModel==null}">
						<table>
							<tr>
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
							</tr>
							</table>
						</c:if>
						<br/><br/>
						<input type="hidden" id="billInitId" name="billInitId" value="${billInitModel.id}">
						<label>
						<input name="billType" id="billType" type="text" size="3" value="${billInitModel.billType}" readonly="readonly" /></label>
						-
						<label>
						<input name="businessCode" id="businessCode"  type="text" size="3" value="${billInitModel.businessType}" readonly="readonly" />
						</label>
						-
						<label>
						<input name="startSerialNumber" id="startSerialNumber" value="${billInitModel.currentSerial}"  type="text" size="10" readonly="readonly" />
						</label>
						-
						<label>
						<input name="checkCode1" type="text" value="x" size="3" readonly="readonly" /></label><br/>
						<br/>

						<input id="amount" name="amount" required="required"
								type="text" placeholder="数量" data-val="true"
								data-val-length="面单代码不能大于6位数字" data-val-length-min="1"
								data-val-length-max="6" data-val-required="初始化数量不能为空"
							   data-val-regex="只能输入大于0的数字" data-val-regex-pattern="^[0-9]*[1-9][0-9]*"
							   onchange="initEndSerialNumber()" />
						<%--<input name="amount" id="amount" size="6" onchange="initEndSerialNumber()" />--%>单
						<button data-bind="click:countBillNum"  <%--onclick="countBillNum()"--%> class="btn btn-xs btn-info">计算</button>
						<span
								class="field-validation-valid text-danger"
								data-valmsg-for="amount" data-valmsg-replace="true"></span>
						<br/>
						<br/>
						<label><input name="billType" type="text" size="3" value="${billInitModel.billType}" readonly="readonly" /></label>
						-
						<label><input name="businessCode" type="text" size="3"  value="${billInitModel.businessType}" readonly="readonly"/></label>
						<%---
						<label><input name="district" type="text" size="3" value="${billInitModel.cityId}" readonly="readonly" /></label>--%>
						-
						<label><input name="endSerialNumber" id="endSerialNumber" type="text" size="10" readonly="readonly" /></label>
						-
						<label><input name="checkCode2" type="text" value="x" size="3" readonly="readonly" /></label>
						<br/>
						<button type="submit"
								class="btn btn-info">保存</button>
						<button type="reset"
								class="btn btn-info">取消</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>