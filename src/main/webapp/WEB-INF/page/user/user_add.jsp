<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>部门信息编辑</title>

<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/common.css" rel="stylesheet">
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
</head>
<body>
	
	<div class="container">
		<table class="table">
	<form method="post" id="userForm">
			<input type="hidden" value="${department.companyId}" name="companyId"/>
			<input type="hidden" value="${department.id}" name="departmentId"/>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>公司名称：</label>
				</td>
				<td style="border:0px;">
					<input name="companyName" id="txtcompanyName"
							value="${department.companyName}" maxlength="20"
							class="form-control" type="text"
							style="width: 300px;" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>部门名称：</label>
				</td>
				<td style="border:0px;">
					<input name="departmentName" id="txtdepartmentName"
							value="${department.departmentName}" maxlength="20"
							class="form-control" type="text" placeholder="请输入部门名称"
							style="width: 300px;" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>用户名：</label>
				</td>
				<td style="border:0px;">
					<input name="userName" id="txtuserName"
							 maxlength="20"
							class="form-control" type="text" placeholder="请输入用户名"
							style="width: 300px;">
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>联系电话：</label>
				</td>
				<td style="border:0px;">
					<input name="telphone" id="txttelphone"
							 maxlength="20"
							class="form-control" type="text" placeholder="请输入联系电话"
							style="width: 300px;">
				</td>
			</tr>
			
		</form>
			<tr>
				<td style="border:0px;">
					
				</td>
				<td style="border:0px;">
					<button class="btn btn-default" onclick="cancelEdit();">取消</button>
					&nbsp;&nbsp;&nbsp;
					<button onclick="editUser();" class="btn btn-default">确定</button>
				</td>
			</tr>
		</table>
	</div>
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/js/pages/user/user_add.js"></script>
</body>
</html>