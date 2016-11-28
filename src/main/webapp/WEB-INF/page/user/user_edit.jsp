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
		<input type="hidden" value="${user.id}" name="id"/>
			<input type="hidden" value="${user.companyId}" name="companyId"/>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>公司名称：</label>
				</td>
				<td style="border:0px;">
					<input name="companyName" id="txtcompanyName"
							value="${user.companyName}" maxlength="20"
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
							value="${user.departmentName}" maxlength="20"
							class="form-control" type="hidden" 
							style="width: 300px;" > 
					<select class="form-control" style="width: 300px;" name="departmentId">
						<option value="">请选择部门信息</option>
						<c:if test="${departmentList != null && departmentList.size() > 0 }">
							<c:forEach items="${departmentList }" var="department">
								<c:choose>
									<c:when test="${department.id == user.departmentId}">
										<option value="${department.id}" selected="selected">${department.departmentName}</option>
									</c:when>
									<c:otherwise>
										<option value="${department.id}">${department.departmentName}</option>
									</c:otherwise>
								</c:choose>
								
							</c:forEach>
						</c:if>
					</select>
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
							style="width: 300px;" value="${user.userName}">
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>联系电话：</label>
				</td>
				<td style="border:0px;">
					<input name="telphone" id="txtTelphone"
							 maxlength="20"
							class="form-control" type="text" placeholder="请输入联系电话"
							style="width: 300px;" value="${user.telphone}">
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
<script type="text/javascript" src="${ctx}/js/pages/user/user_edit.js"></script>
</body>
</html>