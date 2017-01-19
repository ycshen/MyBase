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
			
			
	<form method="post" id="configForm">
			<input type="hidden" value="${config.id}" name="id"/>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>键：</label>
				</td>
				<td style="border:0px;">
					<input name="key" id="txtkey"
							value="${config.key}" maxlength="20"
							class="form-control" type="text" placeholder="请输入键"
							style="width: 300px;">
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>值：</label>
				</td>
				<td style="border:0px;">
					<input name="value" id="txtvalue"
							value="${config.value}" maxlength="20"
							class="form-control" type="text" placeholder="请输入值"
							style="width: 300px;">
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>键值编码：</label>
				</td>
				<td style="border:0px;">
					<input name="code" id="txtcode"
							value="${config.code}" maxlength="13" 
							class="form-control" type="text" placeholder="请输入键值编码"
							<c:if test="${config.code != null && config.code != ''}">readonly="readonly"</c:if>
							style="width: 300px;">
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>备注：</label>
				</td>
				<td style="border:0px;">
					<input name="remark" id="txtremark"
							value="${config.remark}" maxlength="20"
							class="form-control" type="text" placeholder="请输入备注"
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
					<c:if test="${config.id == null || config.id == ''}">
						<button onclick="editConfig();" class="btn btn-default">确定</button>
					</c:if>
					<c:if test="${config.id != null && config.id != ''}">
						<button onclick="editConfig();" class="btn btn-default">修改</button>
					</c:if>
				</td>
			</tr>
		</table>
	</div>
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/js/pages/config/config_edit.js"></script>
</body>
</html>