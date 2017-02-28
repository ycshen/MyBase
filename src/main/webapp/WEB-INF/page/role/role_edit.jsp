<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>配置信息编辑</title>

<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/common.css" rel="stylesheet">
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
</head>
<body>
	
	<div class="container">
		<table class="table">
			
			
	<form method="post" id="myForm">
			<input type="hidden" value="${auth.id}" name="id"/>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>角色名称：</label>
				</td>
				<td style="border:0px;">
					<input name="authName" id="txtAuthName"
							value="${auth.authName}" maxlength="20"
							class="form-control" type="text" placeholder="请输入角色名称"
							style="width: 300px;">
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>角色描述：</label>
				</td>
				<td style="border:0px;">
					<textarea class="form-control" name="authDesc" id="txtAuthDesc" style="width:300px;" rows="3" placeholder="请输入角色描述">${auth.authDesc}</textarea>
				</td>
			</tr>
			
		</form>
			<tr>
				<td style="border:0px;">
					
				</td>
				<td style="border:0px;">
					<button class="btn btn-default" onclick="cancelEdit();">取消</button>
					&nbsp;&nbsp;&nbsp;
					<c:if test="${auth.id == null || auth.id == ''}">
						<button onclick="editauth();" class="btn btn-default">确定</button>
					</c:if>
					<c:if test="${auth.id != null && auth.id != ''}">
						<button onclick="editauth();" class="btn btn-default">修改</button>
					</c:if>
				</td>
			</tr>
		</table>
	</div>
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/js/pages/authority/auth_edit.js"></script>
</body>
</html>