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

	<jsp:include page="../share/sea-require.jsp">
		<jsp:param name="module" value="pages/billmanage/billexception" />
	</jsp:include>
	<style type="text/css">
		input select {
			display: none;
		}
	</style>
</head>
<body>
<div id="main" class="container-fluid">
	<div id="main_content" >
		<div id="main_body" style="padding: 0.6em;">
			<div class="panel panel-info">
				<div class="panel-heading">异常面单录入</div>
				<div class="panel-body">
					<form method="post" data-ajax="true"
						  data-ajax-url="<c:url value="/billManage/saveBillException"></c:url>"
						  data-ajax-loading="#Loading" data-ajax-loading-duration="1000"
						  data-ajax-begin="PAGE.onPostBegin"
						  data-ajax-complete="PAGE.onPostComplete">
						<table class="table table-bordered noWrap" style=" border:none;">
							<input type="hidden" id="status" name="status">
							<input type="hidden" id="id" name="id">
							<tr><td align="right">面单号：</td><td><input id="billNumber" name="billNumber"> <button data-bind="click:queryBillInfo" class="btn btn-xs btn-info">查询</button></td></tr>
							<tr><td align="right">面单详情：</td><td><input id="businessName" name="businessName" readonly="readonly"  style="border:0px;"></td></tr>
							<tr><td align="right">当前所在部门：</td><td><input id="billDeptName" name="billDeptName" readonly="readonly"  style="border:0px;"></td></tr>
							<tr><td align="right">面单状态：</td><td>
								<input id="showStatus" name="showStatus" readonly="readonly"  style="border:0px;"></td></tr>
							<tr><td align="right">作废原因：</td><td><input id="invalidReason" name="invalidReason"></td></tr>
							<tr>
								<td align="right">
						<button type="submit"
								class="btn btn-info">确认作废</button></td><td>
						<button type="reset"
								class="btn btn-info">取消</button></td></tr>
							</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>