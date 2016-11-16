<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>面单申请确认</title>

<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>

<jsp:include page="../share/sea-require.jsp">
	<jsp:param name="module" value="pages/billapprove/confirm" />
</jsp:include>
</head>
<body style="background-color1: #fff;">

	<div class="container">
		<table class="table">
			<tr>
				<td style="text-align: right; width: 150px;border:0px;"></td>
				<td style="border:0px;"></td>
			</tr
			<tr>
				<td style="text-align: right; width: 150px;border:0px;">申请编号</td>
				<td style="border:0px;">${approve.id}</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 150px;border:0px;">申请部门:</td>
				<td style="border:0px;">${approve.approveDepartment}</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 150px;border:0px;">面单类型:</td>
				<td style="border:0px;">${approve.billTypeName}</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 150px;border:0px;">面单业务类型:</td>
				<td style="border:0px;">${approve.billBussinessTypeName}</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 150px;border:0px;">申请面单数:</td>
				<td style="border:0px;">${approve.billNum}单</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 150px;border:0px;">当前库存:</td>
				<td style="border:0px;">${reserveNum}单</td>
			</tr>
			<tr>
				<td style="text-align: right; width: 150px;border:0px;"></td>
				<td style="border:0px;">
					<input type="button" value="取    消" class="btn btn-default" style="width:100px;" onclick="PAGE.cancelConfirm()"/>
					<input type="button" value="确    认" class="btn btn-default"  style="width:100px;" onclick="PAGE.confirmApprove('${approve.id}','${approve.bigAreaId}','${approve.bigAreaName}')"/>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>