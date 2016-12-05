<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>菜单信息编辑</title>

<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/common.css" rel="stylesheet">
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
</head>
<body>
	
	<div class="container">
		<table class="table">
			
			
	<form method="post" id="menuForm">
			<input type="hidden" value="${menu.id}" name="id"/>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>菜单名称：</label>
				</td>
				<td style="border:0px;">
					<input name="menuName" id="txtmenuName"
							value="${menu.menuName}" maxlength="20"
							class="form-control" type="text" placeholder="请输入名称"
							style="width: 300px;">
				</td>
			</tr>
			 <tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>菜单类型：</label>
				</td>
				<td style="border:0px;">
					<select class="form-control" id="menuTypeSelect" style="width: 300px;" name="menuType">
							<option value="">请选择菜单类型</option>
							<c:if test="${configList != null && configList.size() > 0 }">
								<c:forEach var="config" items="${configList}">
									<option value="${config.value}">${config.key}</option>
								</c:forEach>

							</c:if>
						</select>
				</td>
			</tr>
			<%--<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>键值编码：</label>
				</td>
				<td style="border:0px;">
					<input name="code" id="txtcode"
							value="${menu.code}" maxlength="13" 
							class="form-control" type="text" placeholder="请输入键值编码"
							<c:if test="${menu.code != null && menu.code != ''}">readonly="readonly"</c:if>
							style="width: 300px;">
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>备注：</label>
				</td>
				<td style="border:0px;">
					<input name="remark" id="txtremark"
							value="${menu.remark}" maxlength="20"
							class="form-control" type="text" placeholder="请输入备注"
							style="width: 300px;">
				</td>
			</tr> --%>
			
		</form>
			<tr>
				<td style="border:0px;">
					
				</td>
				<td style="border:0px;">
					<button class="btn btn-default" onclick="cancelEdit();">取消</button>
					&nbsp;&nbsp;&nbsp;
					<c:if test="${menu.id == null || menu.id == ''}">
						<button onclick="editMenu();" class="btn btn-default">确定</button>
					</c:if>
					<c:if test="${menu.id != null && menu.id != ''}">
						<button onclick="editMenu();" class="btn btn-default">修改</button>
					</c:if>
				</td>
			</tr>
		</table>
	</div>
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/js/pages/menu/menu_edit.js"></script>
</body>
</html>