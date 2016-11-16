<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>角色信息</title>


<c:import url="share/require.jsp"></c:import>

<link href="css/main.css" rel="stylesheet" />
<script src="js/jquery.validate.min.js"></script>
<script src="js/jquery.validate.unobtrusive.js"></script>
<script src="js/jquery.unobtrusive-ajax.js"></script>
<style type="text/css">
label {
	font-weight: normal;
}

.input-validation-error {
	border-color: #a94442;
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 6px #ce8483
		!important;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#closeBtn").click(function() {
			var event = document.createEvent('HTMLEvents');
			event.initEvent("hideRightPanel", true, true);
			top.document.dispatchEvent(event);
		});
	});
	Page = {
		saveOnSuccess : function(data) {
			if (data.ResultModel.result == "Success") {
				top.location.reload();
			} else {
				alert(data.ResultModel.message);
			}
		},
		updateUser: function(id){
			top.Page.updateGroup(id);
		},
		onPostBegin : function() {
			$("fieldset input").attr("disabled","disabled")
		},
		onPostComplete : function(xhr, textStatus) {
			var httpSuccess = xhr.status == 200;
			var dataSuccess = false;

			$("fieldset input").removeAttr("disabled");
			if (httpSuccess) {
				var model = $.parseJSON(xhr.responseText);
				dataSuccess = model.result == "Success";
				if(dataSuccess){
					top.location.reload();
				} else {
					alert(model.message);
				}
			}else{
				alert("提交失败")
			}
		}
	}
</script>
</head>
<body>
	<div id="main" class="container-fluid">
		<div id="main_content">

			<div id="main_body1" style="padding: 0.6em;">

				<div class="panel panel-info">
					<div class="panel-heading">
						
							
							
							
							添加角色
    						
						
					</div>
					<div class="panel-body">
						
						<form method="post" data-ajax="true"
							data-ajax-url="/role/save"
							data-ajax-loading="#Loading" data-ajax-loading-duration="1000"
							data-ajax-begin="Page.onPostBegin"
							data-ajax-complete="Page.onPostComplete">

							<fieldset>
								<input type="hidden" name="id" value="">
								<div class="form-group">
									<label for="exampleInputName">角色编码</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="name" data-valmsg-replace="true"></span><input
										id="exampleInputName" name="name" required="required"
										type="text" class="form-control" placeholder="角色编码"
										value="" data-val="true"
										data-val-length="角色编码 必须至少包含 2 个字符" data-val-length-min="2"
										data-val-length-max="100" data-val-required="角色编码 字段是必需的">
								</div>
								<div class="form-group">
									<label for="exampleInputAccount">角色描述</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="account" data-valmsg-replace="true"></span><input
										id="exampleInputAccount" name="describe" required="required"
										type="text" class="form-control" placeholder="角色描述"
										value="" data-val="true"
										data-val-length="角色描述 必须至少包含 3 个字符" data-val-length-min="3"
										data-val-length-max="100" data-val-required="角色描述 字段是必需的">
								</div>
								<div class="form-group">
									<label for="exampleInputPermission">权限配置</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="account" data-valmsg-replace="true"></span>
									<textarea id="exampleInputPermission" name="permission" class="form-control" rows="5"></textarea>
								</div>
								<div id="Loading" class="text-center" style="display: none;">
									<img src='img/loading.gif' />
								</div>

								
									
									<button type="submit" class="btn btn-info btn-block">保存角色</button>
									<img id="Loading" class="hide"
										src="img/loading.gif" />
									
								
								
							</fieldset>
						</form>
					</div>
				</div>


			</div>
		</div>
	</div>

</body>
</html>