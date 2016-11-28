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

		<jsp:include page="../share/nav_main.jsp">
			<jsp:param name="nav" value="list_user" />
		</jsp:include>

		<div id="main_content">

			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span>
					员工信息管理
				</div>
			</div>

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">
						员工查询<span class="pull-right"> </span>
					</div>
					<div class="panel-body">
						<div class="form-inline">
						
							<table class="table">
								<tr style="border:0px">
									<td style="border:0px">
									<div class="form-group">
										<label for="hidDistrict">员工姓名
										<input type="text" placeholder="请输入员工名称"  id="txtUserName" class="form-control" value="${userQuery.userName }"/>
									</div>
									</td>
									<td style="border:0px">
										<div class="form-group">
											<label for="hidDistrict">手机号码
											<input type="text" id="txtTelphone" placeholder="请输入员工手机号码" class="form-control" value="${userQuery.telphone}"/>
										</div>
									</td>
									
									<td style="border:0px">
									<button class="btn " onclick="queryUser('${userQuery.page}')">查询</button>
								<!-- 	<button class="btn " onclick="addUser()">新增</button> -->
									</td>
								</tr>
							</table>
							
							
							
							
							
						</div>
					</div>
					<div class="panel-heading">员工信息列表</div>

					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>操作</th>
									<th>员工姓名</th>
									<th>员工状态</th>
									<th>所属公司</th>
									<th>所属部门</th>
									<th>电话号码</th>
									<th>创建人</th>
									<th>创建时间</th>
									<th>更新人</th>
									<th>更新时间</th>
								</tr>
							</thead>
							<tbody >
								<c:forEach items="${userQuery.items}" var="user">
									<tr>
										<td style="display: none;">${user.id}</td>
										<td>
										
										<c:if test="${user.status == 101}">
											<a  href="#" onclick="modifyUser('${user.id}')">修改</a>
										
										</c:if>
										<c:if test="${user.status != 102}">
											<a  href="#" onclick="deleteUser('${user.id}')">删除</a>
										</c:if>
										
										<td>${user.userName }</td>
										<td id="userStatus${user.id}">
											<c:choose>
												<c:when test="${user.status == 100 }"><span style="color:red;">离职</span>
												
												</c:when>
												<c:when test="${user.status == 102 }"><span style="color:green;">禁用</span>
												</c:when>
												<c:otherwise>在职
												<a  href="#" onclick="leaveUser('${user.id}')">确认离职</a>
												</c:otherwise>
											</c:choose>
										</td>
										<td>${user.companyName}</td>
										<td>${user.departmentName}</td>
										<td>${user.telphone}</td>
										<td>${user.createUser}</td>
										<td>
											<f:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<td>${user.updateUser}</td>
										<td>
										<f:formatDate value="${user.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="panel-footer" style="padding: 0.3em;">
						<nav class="text-center">
							<jsp:include page="../share/page.jsp">
								<jsp:param name="url"
									value="?telphone=${userQuery.telphone }&userName=${userQuery.userName}&page=" />
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
<script type="text/javascript" src="${ctx}/js/pages/user/user_list.js"></script>
<!-- <script type="text/javascript">
	$(function(){
		var start = {
				  elem: '#start',
				  format: 'YYYY-MM-DD hh:mm:ss',
				  min: '2016-01-01 23:59:59', //设定最小日期为当前日期
				  max: '2099-06-16 23:59:59', //最大日期
				  istime: true,
				  istoday: false,
				  event: 'focus',
				  choose: function(datas){
				     end.min = datas; //开始日选好后，重置结束日的最小日期
				     end.start = datas //将结束日的初始值设定为开始日
				  }
				};
		var end = {
		  elem: '#end',
		  format: 'YYYY-MM-DD hh:mm:ss',
		  min: '2016-01-01 23:59:59',
		  max: '2099-06-16 23:59:59',
		  istime: true,
		  event: 'focus',
		  istoday: false,
		  choose: function(datas){
		    start.max = datas; //结束日选好后，重置开始日的最大日期
		  }
		};
		laydate(start);
		laydate(end);
		});
		
</script> -->
</body>
</html>



