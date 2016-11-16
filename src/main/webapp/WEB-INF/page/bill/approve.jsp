<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>总部分拣面单申请管理</title>
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>

<jsp:include page="../share/sea-require.jsp">
	<jsp:param name="module" value="pages/bill/approve" />
</jsp:include>

</head>
<body>

	<div id="main" class="container-fluid">

		<jsp:include page="../share/nav_main.jsp">
			<jsp:param name="nav" value="bill_approve" />
		</jsp:include>

		<div id="main_content">

			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span>
					总部分拣面单申请管理
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
										<label for="provinceSelect">申请大区</label> <select
											class="form-control" id="bigAreaSelect">
											<option value="">请选择大区/分公司</option>
											<c:if
												test="${bigAreaList != null && bigAreaList.size() > 0 }">
												<c:forEach var="bigArea" items="${bigAreaList}">
													<option
														<c:if test="${page.bigAreaId == bigArea.districtid}">  selected="selected" </c:if>
														value="${bigArea.districtid}">${bigArea.districtname}</option>
												</c:forEach>
		
											</c:if>
										</select>
									</div>
									</td>
									<td style="border:0px">
										<div class="form-group">
											<label for="hidDistrict">面单业务类型
										<select
											class="form-control" id="billBussinessTypeSelect">
											<option value="">请选择面单业务类型</option>
											<c:if test="${typeList != null && typeList.size() > 0 }">
												<c:forEach var="billType" items="${typeList}">
													<option
														<c:if test="${page.billBussinessType == billType.billCode}">  selected="selected" </c:if>
														value="${billType.billCode}">${billType.businessName}</option>
												</c:forEach>
											</c:if>
										</select>
										</div>
									</td>
									<td style="border:0px">
									
									</td>
								</tr>
								<tr style="border:0px">
									<td style="border:0px">
										<div class="form-group">
											<label for="status">申请状态:</label>
											<c:if test="${page.status == null}">
												<input class="" type="radio" value="100" name="status" id="test">
												<label for="test">未确认</label>
												<input class="" type="radio" value="101" name="status" id="test1">
												<label for="test1">待处理</label>
												<input class="" type="radio" value="102" name="status" id="test1">
												<label for="test1">已处理</label>
											</c:if>
											<c:if test="${page.status == '100'}">
												<input class="" type="radio" value="100" name="status" id="test" checked="checked">
												<label for="test">未确认</label>
												<input class="" type="radio" value="101" name="status" id="test1">
												<label for="test1">待处理</label>
												<input class="" type="radio" value="102" name="status" id="test1">
												<label for="test1">已处理</label>
											</c:if>
											<c:if test="${page.status == '101'}">
												<input class="" type="radio" value="100" name="status" id="test">
												<label for="test">未确认</label>
												<input class="" type="radio" value="101" name="status" id="test1" checked="checked">
												<label for="test1">待处理</label>
												<input class="" type="radio" value="102" name="status" id="test1">
												<label for="test1">已处理</label>
											</c:if>
											<c:if test="${page.status == 102}">
												<input class="" type="radio" value="100" name="status" id="test">
												<label for="test">未确认</label>
												<input class="" type="radio" value="101" name="status" id="test1">
												<label for="test1">待处理</label>
												<input class="" type="radio" value="102" name="status" id="test1" checked="checked">
												<label for="test1">已处理</label>
											</c:if>
			
										</div>
									</td>
									<td style="border:0px">
										<div class="form-group">
												<input class="" type="text" value="${page.approveStartTime}"  id="start" placeholder="开始时间">-
												<input class="" type="text" value="${page.approveEndTime}"  id="end" placeholder="结束时间">
												
										</div>
									</td>
									<td style="border:0px">
										<button class="btn " onclick="PAGE.queryApprove('${page.page}')">查询</button>
										<button class="btn " onclick="PAGE.approveBill()">下级面单申请临时按钮</button>
									</td>
								</tr>
							</table>
							
							
							
							
							
						</div>
					</div>
					<div id="main_navbar" class="page-header">
					<div class="panel-heading">
						当前面单库存数量：<!--  如风达到  50000                        普通快递   2000000                     菜鸟裹裹  3000000                     如风达到  50000                     普通快递 2000000   -->
						<c:if test="${billManageList != null && billManageList.size() > 0}">
							<c:forEach items="${billManageList }" var="manage">
								${manage.businessName} ${manage.billCount}
							
							</c:forEach>
						</c:if>
					</div>
				</div>
					<div class="panel-heading">面单区号列表</div>

					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>申请编号</th>
									<th>申请时间</th>
									<th>申请大区</th>
									<th>产品名称</th>
									<th>数量</th>
									<th>操作</th>
									<th>申请状态</th>
									<th>物流信息</th>
									<th>备注</th>
								</tr>
							</thead>
							<tbody id="tbodyDistrict">
								<c:forEach items="${page.items}" var="approve">
									<tr>
										<td style="display: none;">${approve.id}</td>
										<td>${approve.id }</td>
										<td>
										<f:formatDate value="${approve.approveTime}" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<td>${approve.bigAreaName }</td>
										<td>${approve.provinceName }${approve.cityName}${approve.billBussinessTypeName}${approve.billTypeName}</td>
										<td>${approve.billNum}</td>
										<td id="approve_oper_${approve.id }">
											<c:if test="${approve.status == 100}">
												<a href="#" onclick="PAGE.confirmApprove('${approve.id}');">确认申请</a>
											</c:if>
											<c:if test="${approve.status == 101}">
												<a href="#" onclick="PAGE.outBill('${approve.id}','${approve.bigAreaId}','${approve.bigAreaName}');">面单出库</a>
											</c:if>
											
										</td>
										<td id="approve_status_${approve.id }">
											<c:if test="${approve.status == 100}">
												未确认
											</c:if>
											<c:if test="${approve.status == 101}">
												待处理
											</c:if>
											<c:if test="${approve.status == 102}">
												已处理
											</c:if>
										</td>
										<td  id="approve_express_${approve.id }">${approve.expressCompany} ${approve.expressNo}</td>
										<td  id="approve_remark_${approve.id }">${approve.remark}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="panel-footer" style="padding: 0.3em;">
						<nav class="text-center">
							<jsp:include page="../share/page.jsp">
								<jsp:param name="url"
									value="?approveStartTime=${page.approveStartTime }&approveEndTime=${page.approveEndTime}&bigAreaId=${page.bigAreaId}&status=${page.status}&billBussinessType=${page.billBussinessType}&page=" />
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
	
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/laydate/laydate.js"></script>
<script type="text/javascript">
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
		
</script>
</body>
</html>



