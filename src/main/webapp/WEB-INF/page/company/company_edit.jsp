<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>面单申请</title>

<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/common.css" rel="stylesheet">
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
</head>
<body>
	
	<div class="container">
		<table class="table">
			
			
	<form method="post" id="companyForm">
			
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>企业名称：</label>
				</td>
				<td style="border:0px;">
					<input name="companyName" id="txtCompanyName"
							value="${company.companyName}" maxlength="20"
							class="form-control" type="text" placeholder="请输入企业名称"
							style="width: 300px;">
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>企业地址：</label>
				</td>
				<td style="border:0px;">
					<input name="companyAddress" id="txtCompanyAddress"
							value="${company.companyAddress}" maxlength="20"
							class="form-control" type="text" placeholder="请输入企业地址"
							style="width: 300px;">
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>企业联系方式：</label>
				</td>
				<td style="border:0px;">
					<input name="companyTelephone" id="txtCompanyTelphone"
							value="${company.companyTelephone}" maxlength="11"
							class="form-control" type="text" placeholder="请输入联系方式"
							style="width: 300px;">
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label ><span style="color:red;">*</span>企业负责人：</label>
				</td>
				<td style="border:0px;">
					<input name="companyCeo" id="txtCompanyCeo"
							value="${company.companyCeo}" maxlength="20"
							class="form-control" type="text" placeholder="请输入企业负责人"
							style="width: 300px;">
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label >企业网址：</label>
				</td>
				<td style="border:0px;">
					<input name="companySite" id="txtCompanySite"
							value="${company.companySite}" maxlength="20"
							class="form-control" type="text" placeholder="请输入企业网址"
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
					<button onclick="editCompany();" class="btn btn-default">添加</button>
				</td>
			</tr>
		</table>
	</div>
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/js/pages/company/company_edit.js"></script>
</body>
</html>