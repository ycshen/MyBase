<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>菜单详细信息</title>

<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/common.css" rel="stylesheet">
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
</head>
<body>
	
	<div class="container">
		<table class="table">
			
			<tr>
				<td style="border:0px;text-align:right;width: 100px;">
					<label >菜单名称：</label>
				</td>
				<td style="border:0px;width: 200px;">
					${menu.menuName}
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;width: 100px;">
					<label >所属系统：</label>
				</td>
				<td style="border:0px;">
					${menu.beyondOfSystem}
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;width: 100px;">
					<label >菜单URL：</label>
				</td>
				<td style="border:0px;">
					${menu.menuUrl}
				</td>
			</tr>
			<%-- <tr>
				<td style="border:0px;text-align:right;width: 100px;">
					<label >备注：</label>
				</td>
				<td style="border:0px;">
					${config.remark}
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;width: 100px;">
					<label >创建人：</label>
				</td>
				<td style="border:0px;">
					${config.createUser}
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;width: 100px;">
					<label >创建时间：</label>
				</td>
				<td style="border:0px;">
					<f:formatDate value="${config.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;width: 100px;">
					<label >更新人：</label>
				</td>
				<td style="border:0px;">
					${config.updateUser}
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;width: 100px;">
					<label >更新时间：</label>
				</td>
				<td style="border:0px;">
					<f:formatDate value="${config.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
			</tr> --%>
		</table>
	</div>
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/js/pages/config/config_edit.js"></script>
</body>
</html>