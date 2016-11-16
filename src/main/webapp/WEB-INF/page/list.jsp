<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>管理首页</title>

<c:import url="share/require.jsp"></c:import>

<script src="//cdn.bootcss.com/echarts/3.0.0/echarts.min.js"></script>
<link href="css/main.css" rel="stylesheet" />
<script src="js/main.js"></script>
</head>
<body>
	<div id="main" class="container-fluid">

		<jsp:include page="share/nav_main.jsp">
			<jsp:param name="nav" value="group" />
		</jsp:include>

		<div id="main_content">
			<div id="main_navbar" class="page-header">
				<div class="main_navbar_title">
					<span class="glyphicon glyphicon-scale" aria-hidden="true"></span>
					我的工作台
				</div>

				<ul class="main_navbar_tab">
					<li class="current"><a href="#">我的任务 </a></li>
					<li><a href="#">我的日程</a></li>
					<li><a href="#">最新动态</a></li>
					<li><a href="#">最新动态</a></li>
				</ul>

			</div>

			<div id="main_body" style="padding: 0.6em;">



				<div class="panel panel-default">
					<div class="panel-heading">分组列表</div>
					<div class="panel-body">
						<p>
							此页面展示您有权限查看的任务分组列表，任务分组包含 <span class="label label-warning">一级分组</span>
							<span class="badge">top</span> 和 <span class="label label-info">二组分组</span>
							，一级分组用于权限管控，二级分组下面可以创建任务列表。
						</p>
					</div>
					<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>名称</th>
									<th>编码</th>
									<th>排序</th>
									<th>任务数</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>



								<tr class="warning" data-item-id="14">
									<td style="border-left1: 0.8em solid gray;"><span
										class="badge">top</span></td>
									<td>EDI</td>
									<td>edi</td>
									<td>1</td>
									<td>-</td>
									<td>
										<button type="button" class="btn btn-primary btn-xs"
											onclick="Page.updateGroup(14)">修改分组</button> <!-- <button type="button" class="btn btn-danger btn-xs">删除</button> -->
								</tr>



								<tr data-item-id="15">
									<td style="padding-left: 0.5em; border-left: 2em solid #ddd;">15</td>
									<td style="padding-left: 1.5em;">小米对接</td>
									<td>xiaomi</td>
									<td>1</td>
									<td>1</td>
									<td>
										<button type="button" class="btn btn-primary btn-xs"
											onclick="Page.updateGroup(15)">修改分组</button>

										<button type="button" class="btn btn-warning btn-xs"
											onclick="Page.viewJobList(15)">任务列表</button> <!-- <button type="button" class="btn btn-danger btn-xs">删除</button> -->
								</tr>



								<tr data-item-id="16">
									<td style="padding-left: 0.5em; border-left: 2em solid #ddd;">16</td>
									<td style="padding-left: 1.5em;">凡客对接</td>
									<td>vancl</td>
									<td>2</td>
									<td>3</td>
									<td>
										<button type="button" class="btn btn-primary btn-xs"
											onclick="Page.updateGroup(16)">修改分组</button>

										<button type="button" class="btn btn-warning btn-xs"
											onclick="Page.viewJobList(16)">任务列表</button> <!-- <button type="button" class="btn btn-danger btn-xs">删除</button> -->
								</tr>



								<tr class="warning" data-item-id="17">
									<td style="border-left1: 0.8em solid gray;"><span
										class="badge">top</span></td>
									<td>数据处理系统</td>
									<td>dps</td>
									<td>2</td>
									<td>-</td>
									<td>
										<button type="button" class="btn btn-primary btn-xs"
											onclick="Page.updateGroup(17)">修改分组</button> <!-- <button type="button" class="btn btn-danger btn-xs">删除</button> -->
								</tr>



								<tr data-item-id="18">
									<td style="padding-left: 0.5em; border-left: 2em solid #ddd;">18</td>
									<td style="padding-left: 1.5em;">测试组</td>
									<td>test</td>
									<td>1</td>
									<td>1</td>
									<td>
										<button type="button" class="btn btn-primary btn-xs"
											onclick="Page.updateGroup(18)">修改分组</button>

										<button type="button" class="btn btn-warning btn-xs"
											onclick="Page.viewJobList(18)">任务列表</button> <!-- <button type="button" class="btn btn-danger btn-xs">删除</button> -->
								</tr>


							</tbody>
						</table>
						<div class="panel-footer">
							<span class="label label-primary">分组总数</span>：5 个， 其中 一级分组 2
							个，二级分组 3 个
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">任务列表</div>
					<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>名称</th>
									<th>执行频率</th>
									<th>成功-警告-失败</th>
									<th>分组</th>
									<th>类型</th>
									<th>状态 <!-- public enum TriggerState { NONE, NORMAL, PAUSED, COMPLETE, ERROR, BLOCKED } -->
									</th>
									<th>创建人</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>

								<tr data-item-id="14">
									<td style="border-left1: 0.8em solid gray;">14</td>
									<td title="HttpJob.10f301fc-9f46-4d15-bbfb-70ac9d9e3e3a"><a
										href="/job/itemlist/14">小米妥投回传</a></td>
									<td>50</td>

									<td><a type="button"
										class="btn btn-default btn-xs btn-success"
										href="/job/itemlist/14?show=Success">62302</a> - <span
										class="label label-warning">0</span> - <a type="button"
										class="btn btn-default btn-xs btn-danger"
										href="/job/itemlist/14?show=Failure">4104</a></td>
									<td><a href="/job/list/15">小米对接</a></td>
									<td>HttpJob</td>
									<td class="triggerState">NORMAL</td>
									<td>root</td>
									<td><a type="button"
										class="btn btn-default btn-xs btn-success" title="暂停"
										data-ajax="true" data-ajax-method="Post"
										data-ajax-url="/job/pause/14"
										data-ajax-begin="Page.onStartOrStopBegin"
										data-ajax-complete="Page.onStartOrStopComplete"> <span
											class="glyphicon glyphicon-pause" aria-hidden="true"></span>
											暂停
									</a> <a href="/job/update/14" type="button"
										class="btn btn-info btn-xs">修改</a> <a type="button"
										class="btn btn-danger btn-xs" data-ajax="true"
										data-ajax-confirm="确认要删除该任务【小米妥投回传】吗？" data-ajax-method="Post"
										data-ajax-url="/job/delete/14"
										data-ajax-begin="Page.onDeleteBegin"
										data-ajax-complete="Page.onDeleteComplete">删除</a></td>
								</tr>

								<tr data-item-id="15">
									<td style="border-left1: 0.8em solid gray;">15</td>
									<td title="HttpJob.8f72f49c-9e0e-4bc5-afc6-a7bba20f231c"><a
										href="/job/itemlist/15">凡客订单抓取</a></td>
									<td>30</td>

									<td><a type="button"
										class="btn btn-default btn-xs btn-success"
										href="/job/itemlist/15?show=Success">107444</a> - <span
										class="label label-warning">0</span> - <a type="button"
										class="btn btn-default btn-xs btn-danger"
										href="/job/itemlist/15?show=Failure">1791</a></td>
									<td><a href="/job/list/16">凡客对接</a></td>
									<td>HttpJob</td>
									<td class="triggerState">NORMAL</td>
									<td>root</td>
									<td><a type="button"
										class="btn btn-default btn-xs btn-success" title="暂停"
										data-ajax="true" data-ajax-method="Post"
										data-ajax-url="/job/pause/15"
										data-ajax-begin="Page.onStartOrStopBegin"
										data-ajax-complete="Page.onStartOrStopComplete"> <span
											class="glyphicon glyphicon-pause" aria-hidden="true"></span>
											暂停
									</a> <a href="/job/update/15" type="button"
										class="btn btn-info btn-xs">修改</a> <a type="button"
										class="btn btn-danger btn-xs" data-ajax="true"
										data-ajax-confirm="确认要删除该任务【凡客订单抓取】吗？" data-ajax-method="Post"
										data-ajax-url="/job/delete/15"
										data-ajax-begin="Page.onDeleteBegin"
										data-ajax-complete="Page.onDeleteComplete">删除</a></td>
								</tr>

								<tr data-item-id="16">
									<td style="border-left1: 0.8em solid gray;">16</td>
									<td title="HttpJob.4395e6a6-d281-49b9-a26b-2e01c2741655"><a
										href="/job/itemlist/16">凡客日志回传</a></td>
									<td>5 */1 * * * ?</td>

									<td><a type="button"
										class="btn btn-default btn-xs btn-success"
										href="/job/itemlist/16?show=Success">646</a> - <a
										type="button" class="btn btn-default btn-xs btn-warning"
										href="/job/itemlist/16?show=Warning">66752</a> - <a
										type="button" class="btn btn-default btn-xs btn-danger"
										href="/job/itemlist/16?show=Failure">1004</a></td>
									<td><a href="/job/list/16">凡客对接</a></td>
									<td>HttpJob</td>
									<td class="triggerState">NORMAL</td>
									<td>root</td>
									<td><a type="button"
										class="btn btn-default btn-xs btn-success" title="暂停"
										data-ajax="true" data-ajax-method="Post"
										data-ajax-url="/job/pause/16"
										data-ajax-begin="Page.onStartOrStopBegin"
										data-ajax-complete="Page.onStartOrStopComplete"> <span
											class="glyphicon glyphicon-pause" aria-hidden="true"></span>
											暂停
									</a> <a href="/job/update/16" type="button"
										class="btn btn-info btn-xs">修改</a> <a type="button"
										class="btn btn-danger btn-xs" data-ajax="true"
										data-ajax-confirm="确认要删除该任务【凡客日志回传】吗？" data-ajax-method="Post"
										data-ajax-url="/job/delete/16"
										data-ajax-begin="Page.onDeleteBegin"
										data-ajax-complete="Page.onDeleteComplete">删除</a></td>
								</tr>

								<tr data-item-id="17">
									<td style="border-left1: 0.8em solid gray;">17</td>
									<td title="HttpJob.fac94fc9-7514-47e0-a3ba-41372e515a05"><a
										href="/job/itemlist/17">百度请求</a></td>
									<td>0 */1 * * * ?</td>

									<td><a type="button"
										class="btn btn-default btn-xs btn-success"
										href="/job/itemlist/17?show=Success">44202</a> - <span
										class="label label-warning">0</span> - <a type="button"
										class="btn btn-default btn-xs btn-danger"
										href="/job/itemlist/17?show=Failure">145</a></td>
									<td><a href="/job/list/18">测试组</a></td>
									<td>HttpJob</td>
									<td class="triggerState">NORMAL</td>
									<td>root</td>
									<td><a type="button"
										class="btn btn-default btn-xs btn-success" title="暂停"
										data-ajax="true" data-ajax-method="Post"
										data-ajax-url="/job/pause/17"
										data-ajax-begin="Page.onStartOrStopBegin"
										data-ajax-complete="Page.onStartOrStopComplete"> <span
											class="glyphicon glyphicon-pause" aria-hidden="true"></span>
											暂停
									</a> <a href="/job/update/17" type="button"
										class="btn btn-info btn-xs">修改</a> <a type="button"
										class="btn btn-danger btn-xs" data-ajax="true"
										data-ajax-confirm="确认要删除该任务【百度请求】吗？" data-ajax-method="Post"
										data-ajax-url="/job/delete/17"
										data-ajax-begin="Page.onDeleteBegin"
										data-ajax-complete="Page.onDeleteComplete">删除</a></td>
								</tr>

								<tr data-item-id="18">
									<td style="border-left1: 0.8em solid gray;">18</td>
									<td title="HttpJob.4c65d6fb-a674-4c25-965f-bbf7e03cd8a3"><a
										href="/job/itemlist/18">凡客在天河城</a></td>
									<td>35</td>

									<td><a type="button"
										class="btn btn-default btn-xs btn-success"
										href="/job/itemlist/18?show=Success">39255</a> - <span
										class="label label-warning">0</span> - <a type="button"
										class="btn btn-default btn-xs btn-danger"
										href="/job/itemlist/18?show=Failure">127</a></td>
									<td><a href="/job/list/16">凡客对接</a></td>
									<td>HttpJob</td>
									<td class="triggerState">NORMAL</td>
									<td>jiatao</td>
									<td><a type="button"
										class="btn btn-default btn-xs btn-success" title="暂停"
										data-ajax="true" data-ajax-method="Post"
										data-ajax-url="/job/pause/18"
										data-ajax-begin="Page.onStartOrStopBegin"
										data-ajax-complete="Page.onStartOrStopComplete"> <span
											class="glyphicon glyphicon-pause" aria-hidden="true"></span>
											暂停
									</a> <a href="/job/update/18" type="button"
										class="btn btn-info btn-xs">修改</a> <a type="button"
										class="btn btn-danger btn-xs" data-ajax="true"
										data-ajax-confirm="确认要删除该任务【凡客在天河城】吗？" data-ajax-method="Post"
										data-ajax-url="/job/delete/18"
										data-ajax-begin="Page.onDeleteBegin"
										data-ajax-complete="Page.onDeleteComplete">删除</a></td>
								</tr>

							</tbody>
						</table>
					</div>



					<div class="panel-footer" style="padding: 0.3em;">
						<nav class="text-center">


							<!-- 
5-1-12=1
 -->
							<ul class="pagination">
								<li class='disabled'><a href="#" aria-label="First"><span
										aria-hidden="true">&laquo;</span></a></li>

								<li class='active'><a data-toggle="tooltip"
									title="当前第1/1页　总共5条数据　每页显示12条数据" href="?page=1">1</a></li>

								<!-- 	<li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li>
	<li><a href="#">2</a></li>
	<li><a href="#">3</a></li>
	<li><a href="#">4</a></li>
	<li><a href="#">5</a></li> -->

								<li class='disabled'><a href="#" aria-label="Last"> <span
										aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>

				</div>


			</div>
		</div>
	</div>
</body>
</html>