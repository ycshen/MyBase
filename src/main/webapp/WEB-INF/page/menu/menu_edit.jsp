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
			<input type="hidden" value="${isTree}" id="hidIsTree"/>
			<input type="hidden" value="${menu.id}" name="id"/>
			<input type="hidden" value="${menu.parentMenuId}" name="parentMenuId" id="hidParentMenuId"/>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>${formName}名称：</label>
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
					<label ><span style="color:red;">*</span>${formName}类型：</label>
				</td>
				<td style="border:0px;">
					<input name="menuType" id="txtmenuName" type="hidden" value="${menu.menuType}"/>
					<select class="form-control" id="menuTypeSelect" style="width: 300px;" name="menuType" disabled="disabled">
							<option value="">请选择菜单类型</option>
							<c:if test="${configList != null && configList.size() > 0 }">
								<c:forEach var="config" items="${configList}">
									<option value="${config.value}" <c:if test="${menu.menuType == config.value}">selected="selected"</c:if>>${config.key}</option>
								</c:forEach>

							</c:if>
						</select>
				</td>
			</tr>
			<c:choose>
				<c:when test="${menu.menuType == 3}">
					<tr>
						<td style="border:0px;text-align:right;">
							<label ><span style="color:red;">*</span>菜单URL：</label>
						</td>
						<td style="border:0px;">
							<input name="menuUrl" id="txtmenuUrl"
									value="${menu.menuUrl}" maxlength="20" 
									class="form-control" type="text" placeholder="请输入菜单URL"
									style="width: 300px;">
						</td>
					</tr>
				</c:when>
				<c:when test="${menu.menuType == 2}">
					<tr>
						<td style="border:0px;text-align:right;">
							<label ><span style="color:red;">*</span>href：</label>
						</td>
						<td style="border:0px;">
							<input name="menuUrl" id="txtmenuUrl"
									value="${menu.menuUrl}" maxlength="20" 
									class="form-control" type="text" placeholder="请输入href"
									style="width: 300px;">
						</td>
					</tr>
				</c:when>
				<c:when test="${menu.menuType == 1 || menu.menuType == 4 || menu.menuType == 5}">
					<tr>
						<td style="border:0px;text-align:right;">
							<label ><span style="color:red;">*</span>事件：</label>
						</td>
						<td style="border:0px;">
							<input name="menuUrl" id="txtmenuUrl"
									value="${menu.menuUrl}" maxlength="20" 
									class="form-control" type="text" placeholder="请输入事件"
									style="width: 300px;">
						</td>
					</tr>
				</c:when>
			</c:choose>
			
			<%--<tr>
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