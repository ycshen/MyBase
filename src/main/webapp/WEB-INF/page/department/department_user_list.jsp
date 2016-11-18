<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>员工信息管理</title>
<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/common.css" rel="stylesheet">
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
</head>
<body>

	<div id="main" class="container-fluid">


		<div id="main_content">


			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">

					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>员工姓名</th>
									<th>联系方式</th>
									<th>创建人</th>
									<th>创建时间</th>
									<th>更新人</th>
									<th>更新时间</th>
								</tr>
							</thead>
							<tbody >
								<c:forEach items="${userQuery.items}" var="user">
									<tr>
										<td>${user.userName}</td>
										<td>${user.telphone}</td>
										<td>${user.createUser}</td>
										<td><f:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td>${user.updateUser}</td>
										<td<f:formatDate value="${user.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="panel-footer" style="padding: 0.3em;">
						<nav class="text-center">
							<jsp:include page="../share/page.jsp">
								<jsp:param name="url"
									value="?departmentId=${userQuery.departmentId }&page=" />
								<jsp:param name="count" value="${userQuery.count }" />
								<jsp:param name="page" value="${userQuery.page }" />
								<jsp:param name="size" value="${userQuery.size }" />
							</jsp:include>
							
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/js/pages/department/department_list.js"></script>

</body>
</html>



