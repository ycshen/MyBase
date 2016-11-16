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
	<jsp:param name="module" value="pages/bill/district" />
</jsp:include>

</head>
<body>

	<div id="main" class="container-fluid">

		<jsp:include page="../share/nav_main.jsp">
			<jsp:param name="nav" value="bill_district" />
		</jsp:include>

		<div id="main_content">

			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span>
					面单区号管理
				</div>
			</div>

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">
						区号查询<span class="pull-right"> </span>
					</div>
					<div class="panel-body">
						<div class="form-inline">
							<div class="form-group">
								<label for="provinceSelect">省份</label> <select
									class="form-control" id="provinceSelect">
									<option value="">请选择省份</option>
									<c:if
										test="${provinceList != null && provinceList.size() > 0 }">
										<c:forEach var="provinceVo" items="${provinceList}">
											<option
												<c:if test="${page.provinceName == provinceVo.name}">  selected="selected" </c:if>
												value="${provinceVo.id}">${provinceVo.name}</option>
										</c:forEach>

									</c:if>
								</select>
							</div>
							<div class="form-group">
								<label for="hidDistrict">城市</label><input id="hidDistrict"
									type="hidden" value="${page.districtName }"> <select
									class="form-control" id="citySelect">
									<option value="">请选择城市</option>
								</select>
							</div>
							<div class="form-group">
								<label for="status">状态</label>
								<c:if test="${page.status == null}">
									<input class="" type="radio" value="1"
										name="status" id="test">
									<label for="test">正常</label>
									<input class="" type="radio" value="2"
										name="status" id="test1">
									<label for="test1">停用</label>
								</c:if>
								<c:if test="${page.status == '1'}">
									<input class="" type="radio" value="1"
										name="status" id="test" checked="checked">
									<label for="test">正常</label>
									<input class="" type="radio" value="2"
										name="status" id="test1">
									<label for="test1">停用</label>
								</c:if>
								<c:if test="${page.status == '2'}">
									<input class="" type="radio" value="1"
										name="status" id="test">
									<label for="test">正常</label>
									<input class="" type="radio" value="2"
										name="status" id="test1" checked="checked">
									<label for="test1">停用</label>
								</c:if>

							</div>

							<button class="btn " onclick="PAGE.queryDistrict('${page.page}')">查询</button>
							<button class="btn " onclick="PAGE.addDistrict()">新增</button>
							<c:if test="${provinceList == null || provinceList.size() == 0 }">
								<button class="btn " onclick="PAGE.initBillDistrict();">初始化面单区号</button>
							</c:if>
						</div>
					</div>
					<div class="panel-heading">面单区号列表</div>

					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>省份</th>
									<th>城市/区县</th>
									<th>区号</th>
									<th>区号代码</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="tbodyDistrict">
								<c:forEach items="${page.items}" var="billDistrict">
									<tr>
										<td style="display: none;">${billDistrict.id}</td>
										<td>${billDistrict.provinceName }</td>
										<td>${billDistrict.districtName }</td>
										<td>${billDistrict.districtNum }</td>
										<td>${billDistrict.districtCode }</td>
										<%-- <td style="display:none;">${billDistrict.status}</td> --%>
										<td>${billDistrict.status eq(1) ? "正常" : "停用"}</td>
										<td><a href="#"
											onclick="PAGE.updateBillDistrict('${billDistrict.id}');">修改</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="panel-footer" style="padding: 0.3em;">
						<nav class="text-center">
							<jsp:include page="../share/page.jsp">
								<jsp:param name="url"
									value="?provinceName=${page.provinceName}&districtName=${page.districtName}&status=${page.status}&page=" />
								<jsp:param name="count" value="${page.count }" />
								<jsp:param name="page" value="${page.page }" />
								<jsp:param name="size" value="${page.size }" />
							</jsp:include>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>