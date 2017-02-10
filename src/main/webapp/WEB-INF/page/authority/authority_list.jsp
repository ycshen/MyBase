<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>权限管理</title>
<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/common.css" rel="stylesheet">
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
</head>
<body>

	<div id="main" class="container-fluid">

		<jsp:include page="../share/nav_main.jsp">
			<jsp:param name="nav" value="list_authority" />
		</jsp:include>

		<div id="main_content">

			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span>
					权限信息管理
				</div>
			</div>

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">
						权限信息查询<span class="pull-right"> </span>
					</div>
					<div class="panel-body">
						<div class="form-inline">
						
							<table class="table">
								<tr style="border:0px">
									<td style="border:0px">
									<div class="form-group">
										<label for="hidDistrict">权限名称
										<input type="text" placeholder="请输入权限名称" id="txtkey" class="form-control" value=""/>
									</div>
									</td>
									<td style="border:0px">
									<button class="btn " onclick="queryauth('${authorityQuery.page}')">查询</button>
										<button class="btn " onclick="addauth()">新增</button>
									</td>
								</tr>
								
							</table>
							
							
							
							
							
						</div>
					</div>
					<div class="panel-heading">权限信息列表</div>

					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>操作</th>
									<th>权限名称</th>
									<th>权限描述</th>
									<th>状态</th>
									<th>添加人</th>
									<th>更新人</th>
								</tr>
							</thead>
							<tbody >
								<c:forEach items="${authorityQuery.items}" var="auth">
									<tr>
										<td style="display: none;">${auth.id}</td>
										<td>
										<a  href="#" onclick="modifyauth('${auth.id}')">修改</a>&nbsp;&nbsp;
										<a  href="#" onclick="deleteauth('${auth.id}')">删除</a></td>
										<td>${auth.authName }</td>
										<td>${auth.authDesc}</td>
										<td>
											<c:if test="${auth.isDelete == 0 }">
												<span class="btn btn-success">正常</span>
											</c:if>
											<c:if test="${auth.isDelete == 1 }">
												<span class="btn btn-warning">停用</span>
											</c:if>
										</td>
										<td>${auth.createUser}</td>
										<td>${auth.updateUser}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="panel-footer" style="padding: 0.3em;">
						<nav class="text-center">
							<jsp:include page="../share/page.jsp">
								<jsp:param name="url"
									value="?authName=${authorityQuery.authName }&page=" />
								<jsp:param name="count" value="${authorityQuery.count }" />
								<jsp:param name="page" value="${authorityQuery.page }" />
								<jsp:param name="size" value="${authorityQuery.size }" />
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
<script type="text/javascript" src="${ctx}/js/pages/authority/auth_list.js"></script>
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



