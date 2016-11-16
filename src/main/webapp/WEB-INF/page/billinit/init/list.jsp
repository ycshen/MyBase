<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="shortcut icon" href="${pageContext.request.contextPath }/aps.ico" >
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title></title>

<script src="${ctx}/js/jquery.js" type="text/javascript"></script>
<script src="${ctx}/js/layer/layer.js" type="text/javascript"></script>


<jsp:include page="../../share/sea-require.jsp">
	<jsp:param name="module" value="pages/billinit/init/list" />
</jsp:include>

</head>
<body>
	<div id="main" class="container-fluid">

		<jsp:include page="../../share/nav_main.jsp">
			<jsp:param name="nav" value="bill_init" />
		</jsp:include>

		<div id="main_content">

			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span>
					单号初始化
				</div>
			</div>

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">单号初始化<span class="pull-right">
					</span></div>
					<div class="panel-body">
					<table class="table table-bordered noWrap">
						<tbody>
						<tr>

							<td class="label_td"><label>面单业务类型</label></td>
							<td>
								<select id="businessType" name="businessType"
										class="js-example-basic-single js-states form-control input-sm" style="font-size: small; width: 200px;">
									<%--<option value="-1">-请选面单-</option>--%>
								</select>
							</td>
							<td class="label_td"><label>面单类型</label></td>
							<td>
								<input class="itl-input" type="radio" checked="true" name="billType" value="1">
								<label>纸质面单</label>
								<input class="itl-input" type="radio" name="billType"  value="2">
								<label>电子面单</label>
							</td>
							<td><span class="handle-last-right">
                        		<button <%--onclick="queryInitList()"--%> data-bind="click:queryInitList"  class="itl-btn">查询</button>
								<button <%--onclick="initBill()" --%> data-bind="click:initBill"  class="itl-btn">初始化</button>
                    		</span>
							</td>
						</tr>
						<tr>


						</tr>
						</tbody></table>
						</div>

					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>面单类型</th>
									<th>面单业务类型</th>
									<th>当前单号</th>
									<th>剩余单号</th>
									<th>操作</th>
								</tr>
							</thead>



								<tbody id="content">
									<c:forEach items="${result.items}" step="1"
										var="billInit">
										<tr data-item-id="${billInit.id}">
											<td style="border-left1: 0.8em solid gray;">${billInit.id}</td>
											<td>${billInit.billType eq 1 ?"纸质面单":"电子面单"}</td>
											<td>${billInit.businessName}</td>
											<td>${billInit.currentBillNum}</td>
											<td>${billInit.surplusAmount}</td>
											<td><a class="btn btn-xs btn-info" data-bind="click:showlog" href="javascript:void(0)">
												日志</a> <a class="btn btn-xs btn-info" data-bind="click:initBill" href="javascript:void(0)"> 初始化</a></td>
										</tr>
									</c:forEach>
								</tbody>

						</table>
					</div>
					<div class="panel-footer page-foot" style="padding: 0.3em;">
						<nav class="text-center" >
							<jsp:include page="../../share/page.jsp">
								<jsp:param name="url" value="?provinceId=${result.provinceId}&cityId=${result.cityId}&businessType=${result.businessType}&billType=${result.billType}&page=" />
								<jsp:param name="count" value="${result.count }" />
								<jsp:param name="page" value="${result.page }" />
								<jsp:param name="size" value="${result.size }" />
							</jsp:include>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>