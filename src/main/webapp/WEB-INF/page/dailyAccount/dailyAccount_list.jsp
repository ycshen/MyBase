<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>日常账号管理</title>
	<link rel="apple-touch-icon" href="<c:url value="/img/aps.ico"></c:url>">
	<link rel="icon" href="<c:url value="/img/aps.ico"></c:url>">
	<!--[if IE]><link rel="shortcut icon" href="<c:url value="/img/aps.ico"></c:url>"><![endif]-->
<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/common.css" rel="stylesheet">
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
</head>
<body>

	<div id="main" class="container-fluid">

		<jsp:include page="../share/nav_main.jsp">
			<jsp:param name="nav" value="list_account" />
		</jsp:include>

		<div id="main_content">

			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span>
					日常账号管理
				</div>
			</div>

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">
						日常账号查询<span class="pull-right"> </span>
					</div>
					<div class="panel-body">
						<div class="form-inline">
						
							<table class="table">
								<tr style="border:0px">
									<td style="border:0px">
									<div class="form-group">
										<label for="hidDistrict">账号
										<input type="text" placeholder="请输入账号"  id="txtAccount" class="form-control" value="${dailyAccountQuery.account }"/>
									</div>
									</td>
									
									<td style="border:0px">
									<button class="btn " onclick="queryDailyAccount('${dailyAccountQuery.page}')">查询</button>

									</td>
								</tr>
								
							</table>
							
							
							
							
							
						</div>
					</div>
					<div class="panel-heading">日常账号列表</div>

					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>操作</th>
									<th>账号</th>
									<th>密码</th>
									<th>所属信息</th>
									<th>所属系统</th>
									<th>域名地址</th>
									<th>备注</th>
									<th>添加时间</th>
								</tr>
							</thead>
							<tbody >
								<c:forEach items="${list}" var="dailyAccount">
									<tr>
										<td style="display: none;">${dailyAccount.id}</td>
										<td>
										<a  href="#" onclick="deleteDailyAccount('${dailyAccount.id}')">删除</a></td>
										<td>${dailyAccount.account }</td>
										<td>${dailyAccount.password}</td>
										<td>${dailyAccount.companyId}-${dailyAccount.userId}</td>
										<td>${dailyAccount.system}</td>
										<td>${dailyAccount.systemUrl}</td>
										<td>${dailyAccount.remark}</td>
										<td>${dailyAccount.addTime}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/js/pages/dailyAccount/dailyAccount_list.js"></script>

</body>
</html>



