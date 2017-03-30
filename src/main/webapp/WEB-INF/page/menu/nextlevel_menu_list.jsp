<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>下级菜单信息</title>
	<link rel="apple-touch-icon" href="<c:url value="/img/aps.ico"></c:url>">
	<link rel="icon" href="<c:url value="/img/aps.ico"></c:url>">
	<!--[if IE]><link rel="shortcut icon" href="<c:url value="/img/aps.ico"></c:url>"><![endif]-->
<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/common.css" rel="stylesheet">
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
</head>
<body>

	<div id="main" class="container-fluid">


		<div id="main_content">

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">下级菜单信息列表</div>

					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>排序</th>
									<th>菜单名称</th>
									<th>路径</th>
									<th>菜单类型</th>
									<th>菜单类型标签</th>
								</tr>
							</thead>
							<tbody >
									<tr>
										<td style="display: none;">${menu.id}</td>
										<td>
											<a  href=""><i class="glyphicon glyphicon-arrow-down"></i></a>
											<a  href=""><i class="glyphicon glyphicon-arrow-up"></i></a>
										</td>
										<td>aaa</td>
										<td>bbbb</td>
										<td>aaa</td>
										<td>aaa</td>
									</tr>
							</tbody>
						</table>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>



