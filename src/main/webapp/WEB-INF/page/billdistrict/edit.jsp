<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>面单区号管理</title>

<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>

<jsp:include page="../share/sea-require.jsp">
	<jsp:param name="module" value="pages/billdistrict/edit" />
</jsp:include>
</head>
<body style="background-color1: #fff;">

	<div class="container">
	<br/>
<%-- 
		<div class="page-header">
			<h1>
				面单区号 <small> <c:if test="${editType == 1}">
						<span>新增</span>
					</c:if> <c:if test="${editType == 2}">
						<span>修改</span>
					</c:if>
				</small>
			</h1>
		</div> --%>
		<div class="row form-horizontal">
			<div class="col-xs-12">
				<div class="form-group">
					<label for="provinceSelect" class="col-sm-2 control-label">省份</label>
					<div class="col-sm-10">
						<c:if test="${editType == 1}">
							<select class="form-control" id="provinceSelect">
								<option value="">请选择省份</option>

								<c:if test="${provinceList != null && provinceList.size() > 0 }">
									<c:forEach var="province" items="${provinceList}">
										<option value="${province.id}">${province.text}</option>
									</c:forEach>

								</c:if>
							</select>
						</c:if>
						<c:if test="${editType == 2}">
							<input name="provinceName" id="txtProvinceName"
								class="form-control" type="text" placeholder="请输入省份"
								disabled="disabled" value="${billDistrict.provinceName}">
						</c:if>
					</div>
				</div>
			</div>
			<div class="col-xs-12">
				<div class="form-group">
					<label for="citySelect" class="col-sm-2 control-label">城市</label>
					<div class="col-sm-10">
						<c:if test="${editType == 1}">
							<select class="form-control" id="citySelect">
								<option value="">请选择城市</option>
							</select>
						</c:if>
						<c:if test="${editType == 2}">
							<input name="districtName" id="txtDistrictName"
								disabled="disabled" value="${billDistrict.districtName}"
								class="form-control" type="text" placeholder="请输入城市">
						</c:if>
					</div>
				</div>
			</div>
			<div class="col-xs-12">
				<div class="form-group">
					<label for="txtDistrictNum" class="col-sm-2 control-label">区号</label>
					<div class="col-sm-10">
						<input name="districtNum" id="txtDistrictNum"
							value="${billDistrict.districtNum}" maxlength="4"
							class="form-control" type="text" placeholder="请输入区号"
							onkeyup="this.value=this.value.replace(/\D/g,'')">
					</div>
				</div>
			</div>

			<div class="col-xs-12">
				<div class="form-group">
					<label for="txtDistrictCode" class="col-sm-2 control-label">区号代码</label>
					<div class="col-sm-10">
						<input name="districtCode" id="txtDistrictCode"
							value="${billDistrict.districtCode}" maxlength="3"
							class="form-control" type="text" placeholder="请输入区号代码"
							onkeyup="this.value=this.value.replace(/\D/g,'')">
					</div>
				</div>
			</div>

			<div class="col-xs-12">
				<div class="form-group">
					<label for="txtDistrictCode" class="col-sm-2 control-label">状态</label>
					<div class="col-sm-10">
						<c:if test="${billDistrict.status == 1}">
							<input value="1" name="status" class="itl-input" type="radio"
								id="test" checked="checked">
							<label for="test">正常</label>
							<input value="2" name="status" class="itl-input" type="radio"
								id="test1">
							<label for="test1">停用</label>
						</c:if>
						<c:if test="${billDistrict.status == 2}">
							<input value="1" name="status" class="itl-input" type="radio"
								id="test">
							<label for="test">正常</label>
							<input value="2" name="status" class="itl-input" type="radio"
								id="test1" checked="checked">
							<label for="test1">停用</label>
						</c:if>
						<c:if test="${billDistrict.status == null}">
							<input value="1" name="status" class="itl-input" type="radio"
								id="test" checked="checked">
							<label for="test">正常</label>
							<input value="2" name="status" class="itl-input" type="radio"
								id="test1">
							<label for="test1">停用</label>
						</c:if>
					</div>
				</div>
			</div>

			<div class="col-xs-12">
				<hr />
				<div class="form-group text-center">
					<button onclick="PAGE.editDistrict();" class="btn">保存</button>
					&nbsp;&nbsp;&nbsp;
					<button class="btn btn-default" onclick="PAGE.cancelEdit();">取消</button>
				</div>
				<input type="hidden" value="${billDistrict.id}" id="hidId" /> <input
					type="hidden" value="${editType}" id="hidEditType" />
			</div>
		</div>
	</div>

</body>
</html>