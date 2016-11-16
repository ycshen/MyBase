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
<script type="text/javascript">
	var Page = (function() {
		$(function() {

			$('#btnViewCorn')
					.popover(
							{
								trigger : "focus",
								title : '调度Cron表达式示例 <a class="pull-right" href="http://www.cnblogs.com/sunjie9606/archive/2012/03/15/2397626.html" target="_blank">查看定义</a>',
								placement : "auto",
								html : true,
								content : $("#tplCorn").html(),
								a : 1
							});
			$("#btnViewRegex")
					.click(
							function() {
								var url = "http://msdn.microsoft.com/zh-cn/library/ae5bf541(v=vs.80).aspx";
								var url = "http://www.oschina.net/question/12_9507";
								window.open(url);
							});

		});

		var vo = new Object();
		vo.selectHttpMethod = function(method) {
			$("#txtHttpMethod").val(method);
		};
		vo.onPostBegin = function() {
			$("#alertModel").find(".modal-title").text("提示");
			$("#alertModel")
					.find(".modal-body")
					.html(
							"<div class='text-center'><h4>数据提交中</h4><img	src='/image/loading.gif' /></br></div>");
			$("#alertModel").find(".close").hide();
			$("#alertModel").find(".modal-footer").hide();
			$("#alertModel").find(".modal-body").removeClass(
					"bg-success bg-denger");
			$("#alertModel").modal();
		};
		vo.onPostComplete = function(xhr, textStatus) {
			var httpSuccess = xhr.status == 200;
			var dataSuccess = false;
			if (httpSuccess) {
				var model = $.parseJSON(xhr.responseText);
				dataSuccess = model.result == "Success";
			}
			$("#alertModel").find(".modal-title").html(
					"<span class='glyphicon glyphicon-"
							+ (dataSuccess ? "saved" : "exclamation-sign")
							+ "' aria-hidden='true'></span>" + "处理"
							+ (dataSuccess ? "成功" : "失败")
							+ " <span class='sr-only'>" + textStatus
							+ "</span>" + " " + xhr.status);
			$("#alertModel").find(".modal-body").html(model.message)
					.removeClass("bg-success bg-denger").addClass(
							dataSuccess ? "bg-success" : "bg-danger");
			$("#alertModel").find(".close,.modal-footer").show();
		};
		return vo;
	})();
</script>

</head>
<body>
	<div id="main" class="container-fluid">

		<jsp:include page="share/nav_main.jsp">
			<jsp:param name="nav" value="main" />
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
					<div class="panel-heading">新增任务[]</div>
					<div class="panel-body">
						<form method="POST" data-ajax="true" data-ajax-url="/job/save"
							data-ajax-method="POST" data-ajax-begin="Page.onPostBegin"
							data-ajax-complete="Page.onPostComplete">
							<input type="hidden" name="id" value="" /> <input type="hidden"
								name="jobType" value="http" />

							<div class="row">
								<div class="col-sm-6 col-md-4 col-lg-3">
									<div class="form-group">
										<label for="name">任务名称</label> <span
											class="field-validation-valid text-danger"
											data-valmsg-for="name" data-valmsg-replace="true"></span> <input
											class="form-control" data-val="true"
											data-val-length="任务名称不能大于50个字符" data-val-length-max="50"
											data-val-required="任务名称不能为空" id="name" name="name"
											placeholder="输入调度任务名称" type="text" value=""
											required="required" data-val="true" data-val-required="不能为空" />
									</div>
								</div>
								<div class="col-sm-6 col-md-4 col-lg-3">
									<div class="form-group">
										<label for="groupId">选择分组</label> <span
											class="field-validation-valid text-danger"
											data-valmsg-for="groupId" data-valmsg-replace="true"></span>
										<select class="form-control" name="groupId"
											required="required" data-val="true" data-val-required="不能为空">

											<optgroup label="===EDI==="></optgroup>

											<option value="15">小米对接</option>

											<option value="16">凡客对接</option>


											<optgroup label="===数据处理系统==="></optgroup>

											<option value="18">测试组</option>


										</select>
									</div>
								</div>
								<div class="col-sm-6 col-md-4 col-lg-3">
									<div class="form-group">
										<label for="method">Http Method</label> <span
											class="field-validation-valid text-danger"
											data-valmsg-for="method" data-valmsg-replace="true"></span>
										<div class="input-group">
											<input id="txtHttpMethod" type="text" name="method" value=""
												class="form-control" aria-label="..." required="required"
												data-val="true" data-val-required="不能为空"
												data-val-regex="必须是3-10个大写字母"
												data-val-regex-pattern="[A-Z]{3,10}">
											<div class="input-group-btn">
												<button type="button"
													class="btn btn-default dropdown-toggle"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													选择 <span class="caret"></span>
												</button>
												<ul class="dropdown-menu dropdown-menu-right">
													<li><a href="javascript:Page.selectHttpMethod('GET')">GET</a></li>
													<li><a href="javascript:Page.selectHttpMethod('POST')">POST</a></li>
													<li role="separator" class="divider"></li>
													<li><a href="javascript:Page.selectHttpMethod('PUT')">PUT</a></li>
													<li><a href="javascript:Page.selectHttpMethod('HEAD')">HEAD</a></li>
													<li><a
														href="javascript:Page.selectHttpMethod('DELETE')">DELETE</a></li>
													<li><a
														href="javascript:Page.selectHttpMethod('OPTIONS')">OPTIONS</a></li>
													<li><a
														href="javascript:Page.selectHttpMethod('PATCH')">PATCH</a></li>
												</ul>
											</div>
											<!-- /btn-group -->
										</div>
										<!-- /input-group -->
									</div>
								</div>
								<div class="col-sm-6 col-md-4 col-lg-3">
									<div class="form-group">
										<label for="timeOut">超时时间(秒)</label> <span
											class="field-validation-valid text-danger"
											data-valmsg-for="timeOut" data-valmsg-replace="true"></span>
										<input class="form-control" data-val="true"
											data-val-number="必须是一个数字，单位秒。" data-val-required="不能为空"
											id="timeOut" name="timeOut" placeholder="执行超时时间（秒）"
											type="text" value="" />
									</div>
								</div>
								<div class="col-sm-6 col-md-4 col-lg-3">
									<div class="form-group">
										<label for="cron">执行频率</label> <span
											class="field-validation-valid text-danger"
											data-valmsg-for="cron" data-valmsg-replace="true"></span>
										<div class="input-group">
											<input class="form-control" data-val="true"
												data-val-length="任务名称不能大于100个字符" data-val-length-max="100"
												data-val-required="执行频率不能为空" id="cron" name="cron"
												placeholder="输入整数或者Cron表达式" type="text" value="" /> <span
												class="input-group-btn">
												<button id="btnViewCorn" type="button"
													class="btn btn-default" data-container="body"
													data-toggle1="popover" data-placement1="left"
													data-content1="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">
													Cron示例</button>
											</span>
										</div>
									</div>
								</div>
								<div class="col-sm-6 col-md-4 col-lg-3">
									<div class="form-group">
										<label for="resultRegex">成功标识正则</label> <span
											class="field-validation-valid" data-valmsg-for="resultRegex"
											data-valmsg-replace="true"></span>
										<div class="input-group">
											<input class="form-control" id="resultRegex"
												name="resultRegex" placeholder="调度成功标识正则表达式" type="text"
												value="" /> <span class="input-group-btn">
												<button id="btnViewRegex" type="button"
													class="btn btn-default">正则表达式</button>
											</span>
										</div>
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label for="url">执行地址</label> <span
											class="field-validation-valid text-danger"
											data-valmsg-for="url" data-valmsg-replace="true"></span> <input
											class="form-control" data-val="true"
											data-val-regex="Http(s)地址不正确"
											data-val-regex-pattern="((http|https)://)(.+)"
											data-val-required="任务地址不能为空" id="url" name="url"
											placeholder="输入调度任务Http地址" type="text" value="" />
									</div>
								</div>
								<div class="col-md-6 col-lg-12">
									<div class="form-group">
										<label for="header">Http Header</label> <span
											class="field-validation-valid" data-valmsg-for="header"
											data-valmsg-replace="true"></span>
										<textarea class="form-control" cols="20" id="header"
											name="header" placeholder="输入调度任务HttpHeader信息" rows="3"></textarea>
									</div>
								</div>
								<div class="col-md-6 col-lg-12">
									<div class="form-group">
										<label for="content">Http Body</label> <span
											class="field-validation-valid" data-valmsg-for="content"
											data-valmsg-replace="true"></span>
										<textarea class="form-control" id="content" name="content"
											placeholder="输入 Http 内容" rows="3"></textarea>
									</div>
								</div>
								<div class="col-lg-12">
									<div class="form-group">
										<label for="describe">任务描述</label> <span
											class="field-validation-valid" data-valmsg-for="describe"
											data-valmsg-replace="true"></span>
										<textarea class="form-control" id="describe" name="describe"
											placeholder="输入调度任务描述" rows="3"></textarea>
									</div>
								</div>
							</div>
							<div class="row hidden">
								<div class="col-sm-6 col-md-4 col-lg-3">
									<div class="form-group">
										<label for="startAt">开始时间</label> <span class="small">(为空代表立即开始)</span>
										<div id="datetimepicker"
											class=" input-group date form_datetime"
											data-date1="1979-09-16T05:25:07Z"
											data-date-format="dd MM yyyy - HH:ii p"
											data-link-field="dtp_input1">
											<span class="input-group-addon"><span
												class="glyphicon glyphicon-th"></span></span> <input
												class="form-control" data-val="true"
												data-val-date="字段 开始时间 必须是日期。" id="startAt" name="startAt"
												placeholder="点击输入开始时间" type="text" value="" /> <span
												class="input-group-addon"><span
												class="glyphicon glyphicon-remove"></span></span>
										</div>
									</div>
								</div>

								<div class="col-sm-6 col-md-4 col-lg-3">
									<div class="form-group">
										<label for="endAt">结束时间</label> <span class="small">(为空代表永不结束)</span>
										<div id="datetimepicker"
											class=" input-group date form_datetime"
											data-date1="1979-09-16T05:25:07Z"
											data-date-format="dd MM yyyy - HH:ii p"
											data-link-field="dtp_input1">
											<span class="input-group-addon"><span
												class="glyphicon glyphicon-th"></span></span> <input
												class="form-control" data-val="true"
												data-val-date="字段 结束时间 必须是日期。" id="endAt" name="endAt"
												placeholder="点击输入结束时间" type="text" value="" /> <span
												class="input-group-addon"><span
												class="glyphicon glyphicon-remove"></span></span>
										</div>
									</div>
								</div>
							</div>
							<button type="submit" class="btn btn-info btn-block">提交保存</button>

							<div class="validation-summary-valid" data-valmsg-summary="true">
								<ul>
									<li style="display: none"></li>
								</ul>
							</div>
						</form>

					</div>
				</div>


<script id="tplCorn" type="text/template">
    <p>
        格式：秒 分 时 日 月 周 年(可选)
    </p>
    <pre style="font-size:9pt;">
每隔5秒执行一次：*/5 * * * * ?
每隔1分钟执行一次：0 */1 * * * ?
每天23点执行一次：0 0 23 * * ?
每天凌晨1点执行一次：0 0 1 * * ?
每月1号凌晨1点执行一次：0 0 1 1 * ?
每月最后一天23点执行一次：
0 0 23 L * ?
每周星期天凌晨1点实行一次：
0 0 1 ? * L
在26分、29分、33分执行一次：
0 26,29,33 * * * ?
每天的0,13,18,21点都执行一次：
0 0 0,13,18,21 * * ?
</pre>    
</script>




			</div>
		</div>
	</div>
</body>
</html>