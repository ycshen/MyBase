<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>面单申请</title>

<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>

<jsp:include page="../share/sea-require.jsp">
	<jsp:param name="module" value="pages/billapprove/edit" />
</jsp:include>
</head>
<body>
	
	<div class="container">
		<table class="table">
			<tr>
				<td style="border:0px;text-align:right;">
					<label>申请部门：</label>
				</td>
				<td style="border:0px;">
					${brpUserInfo.districtname }
						<input type="hidden" value="${brpUserInfo.districtid }" id="hidBigAreaId"/>
						<input type="hidden" value="${brpUserInfo.districtname }" id="hidBigAreaName"/>
						<input type="hidden" value="${brpUserInfo.expresscompanyid }" id="hidDeptId"/>
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label >面单类型：</label>
				</td>
				<td style="border:0px;">
					<input value="1" name="billType" class="itl-input" type="radio"
								id="test" checked="checked">
							<label for="test">纸质面单</label>
							<input value="2" name="billType" class="itl-input" type="radio"
								id="test1">
							<label for="test1">电子面单</label>
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label for="provinceSelect" >面单业务类型：</label>
				</td>
				<td style="border:0px;">
					<select class="form-control" id="billBussinessSelect" style="width: 200px;">
							<option value="">请选择面单业务类型</option>
							<c:if
								test="${typeList != null && typeList.size() > 0 }">
								<c:forEach var="billType" items="${typeList}">
									<option value="${billType.billCode}">${billType.businessName}</option>
								</c:forEach>

							</c:if>
						</select>
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label >申请面单数：</label>
				</td>
				<td style="border:0px;">
					<input name="districtCode" id="txtBillNum"
							value="${billDistrict.districtCode}" maxlength="10"
							class="input-medium" type="text" placeholder="请输入数量"
							onkeyup="this.value=this.value.replace(/\D/g,'')" style="width: 150px;">单
				</td>
			</tr>
			<tr>
				<td style="border:0px;text-align:right;">
					<label>当前库存：</label>
				</td>
				<td style="border:0px;">
					<span id="spanReserveNum">0</span>单
				</td>
			</tr>
			<tr>
				<td style="border:0px;">
					
				</td>
				<td style="border:0px;">
					<button class="btn btn-default" onclick="PAGE.cancelEdit();">取消</button>
					&nbsp;&nbsp;&nbsp;
					<button onclick="PAGE.editApprove();" class="btn">提交申请</button>
				</td>
			</tr>
		</table>
		
	</div>

</body>
</html>