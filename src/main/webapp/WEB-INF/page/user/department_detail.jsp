<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>部门详细信息</title>

<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/common.css" rel="stylesheet">
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
</head>
<body>
	
<div class="container">
		<ul id="myTab" class="nav nav-tabs">
			<li class="active">
				<a href="#home" data-toggle="tab">
					部门信息
				</a>
			</li>
			<li>
				<a href="#userInfo" data-toggle="tab">
					员工信息
				</a>
			</li>
	
			<li>
				<a href="#userInfoTree" data-toggle="tab">员工树形信息</a>
			</li>
		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade in active" id="home">
				<table class="table" style="width: 400px;">
					<tr >
						<td style="width:100px; border:0px;text-align:right;">所属公司：</td>
						<td style="width:200px; border:0px;text-align:left;">${department.companyName}</td>
						
					</tr>
					<tr>
						<td style="width:100px; border:0px;text-align:right;">部门名称：</td>
						<td style="width:200px; border:0px;text-align:left;">${department.departmentName}</td>
						
					</tr>
					<tr>
						<td style="width:100px; border:0px;text-align:right;">部门状态：</td>
						<td style="width:200px; border:0px;text-align:left;">
							<c:if test="${department.status == 0}">正常</c:if>
							<c:if test="${department.status == 1}">停用</c:if>
						
						</td>
						
					</tr>
				</table>
			</div>
			<div class="tab-pane fade" id="userInfo">
				2
			</div>
			<div class="tab-pane fade" id="userInfoTree">
				3
			</div>
			
		</div>
</div>
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/js/pages/config/config_edit.js"></script>
</body>
</html>