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


<jsp:include page="../share/sea-require.jsp">
	<jsp:param name="module" value="pages/billmanage/billmanage_list" />
</jsp:include>

</head>
<body>
	<div id="main" class="container-fluid">

		<jsp:include page="../share/nav_main.jsp">
			<jsp:param name="nav" value="bill_manage" />
		</jsp:include>


		<div id="main_content">

			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span>
					面单管理
				</div>
			</div>

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">面单管理<span class="pull-right">
					</span></div>

					<div>
						<div id="" style="padding-top: 1.6em;">

							<div class="container-fluid">
								<div class="row text-center">
									<div class="col-xs-3">
										<div class="panel panel-danger">
											<div class="panel-heading">生产中</div>
											<div class="panel-body">
												<h3> ${billManageStatusCount.billProductCount}</h3>
											</div>
										</div>
									</div>
									<div class="col-xs-3">
										<div class="panel panel-success">
											<div class="panel-heading">当前库存</div>
											<div class="panel-body">
												<h3>${billManageStatusCount.billRepertoryCount}</h3></div>
										</div></div>
									<div class="col-xs-3">
										<div class="panel panel-info">
											<div class="panel-heading">累计出库</div>
											<div class="panel-body">
												<h3>${billManageStatusCount.billOutWarehouseCount}</h3></div>
										</div></div>
									<div class="col-xs-3">
										<div class="panel panel-warning">
											<div class="panel-heading">累计作废</div>
											<div class="panel-body">
												<h3>${billManageStatusCount.billInvalidCount}</h3></div>
										</div></div>
								</div>

							</div>
						</div>

					</div>

					<div class="panel-body">
						<table class="table table-bordered noWrap">
						<tbody>
						<tr>

							<td class="label_td"><label>待处理审请：${toDoNum}条 <a href="/bill/approve?page=1&status=100"> >>>去处理</a></label></td>
							<td>
							</td>
							<td>
								<button class="btn btn-xs btn-info" data-bind="click:billInWarehouse" >面单入库</button>
							</td>
							<td><span class="handle-last-right">
								<button class="btn btn-xs btn-info" data-bind="click:billException" >异常面单录入</button>
                    		</span>
							</td>
						</tr>
						</tbody></table>

						</div>
					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>编号</th>
									<th>所在位置</th>
									<th>面单业务类型</th>
									<th>面单类型</th>
									<th>单量</th>
								</tr>
							</thead>

								<tbody id="content">
									<c:forEach items="${resultModel}" step="1"  var="billManage" varStatus="xh">
										<tr data-item-id="">
											<td>${xh.count}</td>
											<td>${billManage.billDeptName}</td>
											<td>${billManage.businessName}</td>
											<td>${billManage.billType eq 1 ?"纸质面单":"电子面单"}</td>
											<td>${billManage.billCount}</td>
										</tr>
									</c:forEach>
								</tbody>

						</table>
					</div>
				<%--	<div class="panel-footer page-foot" style="padding: 0.3em;">
						<nav class="text-center" >
							<jsp:include page="../share/page.jsp">
								<jsp:param name="url" value="?provinceId=${result.provinceId}&cityId=${result.cityId}&businessType=${result.businessType}&billType=${result.billType}&page=" />
								<jsp:param name="count" value="${result.count }" />
								<jsp:param name="page" value="${result.page }" />
								<jsp:param name="size" value="${result.size }" />
							</jsp:include>
						</nav>
					</div>--%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>