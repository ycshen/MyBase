<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>菜单权限信息管理</title>
<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/common.css" rel="stylesheet">
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
</head>
<body>

	<div id="main" class="container-fluid">

		<jsp:include page="../share/nav_main.jsp">
			<jsp:param name="nav" value="list_menu" />
		</jsp:include>

		<div id="main_content">

			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span>
					菜单权限信息管理
				</div>
			</div>

			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">
					<div class="panel-heading">
						菜单权限查询<span class="pull-right"> </span>
					</div>
					<div class="panel-body">
						<div class="form-inline">
						
							<table class="table">
								<tr style="border:0px">
									<td style="border:0px">
									<div class="form-group">
										<label for="hidDistrict">菜单名称
										<input type="text" placeholder="请输入菜单名称"  id="txtmenuName" class="form-control" value="${menuQuery.menuName }"/>
									</div>
									</td>
									<td style="border:0px">
										<div class="form-group">
											<label for="hidDistrict">菜单url
											<input type="text" id="txtmenuUrl" placeholder="请输入菜单url" class="form-control" value="${menuQuery.menuUrl}"/>
										</div>
									</td>
									<td style="border:0px">
										<div class="form-group">
											<label for="hidDistrict">菜单类型
											<select class="form-control" id="menuTypeSelect" style="width: 200px;" name="menuType">
												<option value="">请选择菜单类型</option>
												<c:if test="${configList != null && configList.size() > 0 }">
													<c:forEach var="config" items="${configList}">
														<option value="${config.value}"  <c:if test="${menuQuery.menuType == config.value}">selected="selected"</c:if>>${config.key}</option>
													</c:forEach>
					
												</c:if>
											</select>
										</div>
									</td>
								</tr>
								<tr>
								<td style="border:0px">
									<div class="form-group">
										
									</div>
									</td>
									<td style="border:0px">
										
									</td>
									<td style="border:0px">
									<button class="btn " onclick="queryMenu('${menuQuery.page}')">查询</button>
										<button class="btn " onclick="addSystem()">新增系统</button>
									</td>
								</tr>
							</table>
							
							
							
							
							
						</div>
					</div>
					<div class="panel-heading">菜单权限信息列表</div>
					<div class="panel-heading"><a href="${ctx}/inner/menu/tree">树形菜单</a></div>

					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>操作</th>
									<th>菜单名称</th>
									<th>菜单类型</th>
									<th>菜单类型标签</th>
									<th>所属系统</th>
									<th>添加人</th>
									<th>更新人</th>
								</tr>
							</thead>
							<tbody >
								<c:forEach items="${menuQuery.items}" var="menu">
									<tr>
										<td style="display: none;">${menu.id}</td>
										<td>
										
										<a  href="#" onclick="modifyMenu('${menu.id}')">修改</a>&nbsp;&nbsp;
										<a  href="#" onclick="viewMenu('${menu.id}')">详细</a>&nbsp;&nbsp;
										<a  href="#" onclick="deleteMenu('${menu.id}')">删除</a>
										
										<c:choose>
											<c:when test="${menu.menuType == 0}">
												<a  href="#" onclick="addSub('${menu.id}', 3)">添加子菜单</a>&nbsp;&nbsp;
											</c:when>
											<c:when test="${menu.menuType == 3}">
												<a  href="#" onclick="addMultiSub('${menu.id}')">添加事件</a>&nbsp;&nbsp;
											</c:when>
										</c:choose>
										</td>
										<td>${menu.menuName }</td>
										<td>${menu.menuTypeName}</td>
										<td>${menu.menuTypeTag}</td>
										<td>${menu.beyondOfSystem}</td>
										<td>${menu.createUser}</td>
										<td>${menu.updateUser}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="panel-footer" style="padding: 0.3em;">
						<nav class="text-center">
							<jsp:include page="../share/page.jsp">
								<jsp:param name="url"
									value="?menuName=${menuQuery.menuName }&menuUrl=${menuQuery.menuUrl}&menuType=${menuQuery.menuType}&page=" />
								<jsp:param name="count" value="${menuQuery.count }" />
								<jsp:param name="page" value="${menuQuery.page }" />
								<jsp:param name="size" value="${menuQuery.size }" />
							</jsp:include>
							
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
<div style="display:none;text-align:center;" id="divMenuType">
	<label for="test">事件类型：</label>
	<!-- <input class="" type="radio" value="3"  name="menuType" id="test1">
	<label for="test">菜单</label> -->
	<input class="" type="radio" value="1"  name="menuType" id="test1">
	<label for="test1">按钮</label>
	<input class="" type="radio" value="2"  name="menuType" id="test1">
	<label for="test1">A标签</label>
	<input class="" type="radio" value="4"  name="menuType" id="test1">
	<label for="test1">单击事件</label>
	<input class="" type="radio" value="5"  name="menuType" id="test1">
	<label for="test1">双击事件</label>
	<br/><br/>
	<input type="button"  class="btn btn-default" value="确定类型" onclick="confirmType();"/>
	<input type="button"  class="btn btn-default" value="取消操作" onclick="cancleType();"/>
	<input type="hidden"  id="hidMenuId"/>
</div>
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/js/pages/menu/menu_list.js"></script>
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



