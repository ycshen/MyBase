<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>企业信息管理</title>
<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/common.css" rel="stylesheet">
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
</head>
<body>

	<div id="main" class="container-fluid">

		<jsp:include page="../share/nav_main.jsp">
			<jsp:param name="nav" value="list_company" />
		</jsp:include>

		<div id="main_content">

			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span>
					企业信息管理
				</div>
			</div>

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">
						面单申请查询<span class="pull-right"> </span>
					</div>
					<div class="panel-body">
						<div class="form-inline">
						
							<table class="table">
								<tr style="border:0px">
									<td style="border:0px">
									<div class="form-group">
										<label for="provinceSelect">企业会员级别</label> 
										<select
											class="form-control" id="levelSelect">
											<option value="">请选择会员级别</option>
											<c:if
												test="${configList != null && configList.size() > 0 }">
												<c:forEach var="config" items="${configList}">
													<option
														<c:if test="${companyQuery.level == config.value}">  selected="selected" </c:if>
														value="${config.value}">${config.key}</option>
												</c:forEach>
		
											</c:if>
										</select>
									</div>
									</td>
									<td style="border:0px">
										<div class="form-group">
											<label for="hidDistrict">企业名称
											<input type="text" placeholder="企业名称" id="txtCompanyName" class="form-control" value="${companyQuery.companyName }"/>
										</div>
									</td>
									<td style="border:0px">
									<button class="btn " onclick="queryCompany('${companyQuery.page}')">查询</button>
										<button class="btn " onclick="addCompany()">新增企业信息</button>
									</td>
								</tr>
								
							</table>
							
							
							
							
							
						</div>
					</div>
					<div class="panel-heading">企业信息列表</div>

					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>操作</th>
									<th>企业编号</th>
									<th>企业名称</th>
									<th>企业地址</th>
									<th>企业联系方式</th>
									<th>会员级别</th>
									<th>注册时间</th>
									<th>创建人</th>
									<th>更新人</th>
								</tr>
							</thead>
							<tbody >
								<c:forEach items="${companyQuery.items}" var="company">
									<tr>
										<td style="display: none;">${company.id}</td>
										<td>
											<a href="#" onclick="addSubCompany('${company.id}')">添加子公司</a>&nbsp;&nbsp;
											<a  href="#" onclick="addDepartment('${company.id}')">添加部门</a>
										</td>
										<td>${company.id }</td>
										<td>${company.companyName }</td>
										<td>${company.companyAddress}</td>
										<td>${company.companyTelephone}</td>
										<td id="company_level_${company.id }">
											<c:if test="${company.level == 100}">
												普通会员
											</c:if>
											<c:if test="${company.level == 101}">
												白银会员
											</c:if>
											<c:if test="${company.level == 102}">
												黄金会员
											</c:if>
											<c:if test="${company.level == 103}">
												钻石会员
											</c:if>
											<c:if test="${company.level == 104}">
												终身会员
											</c:if><c:if test="${company.level == 105}">
												禁用会员
											</c:if>
										</td>
										<td>
										<f:formatDate value="${company.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<td>${company.createUser}</td>
										<td>${company.updateUser}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="panel-footer" style="padding: 0.3em;">
						<nav class="text-center">
							<jsp:include page="../share/page.jsp">
								<jsp:param name="url"
									value="?conpanyName=${companyQuery.companyName }&level=${companyQuery.level}&page=" />
								<jsp:param name="count" value="${companyQuery.count }" />
								<jsp:param name="page" value="${companyQuery.page }" />
								<jsp:param name="size" value="${companyQuery.size }" />
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
<script type="text/javascript" src="${ctx}/js/pages/company/company_list.js"></script>
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



