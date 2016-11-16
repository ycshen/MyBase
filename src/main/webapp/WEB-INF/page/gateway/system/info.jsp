<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>API分组信息</title>

<jsp:include page="../../share/sea-require.jsp">
	<jsp:param name="module" value="pages/gateway/system/info" />
</jsp:include>

</head>
<body>
	<div id="main" class="container-fluid">
		<div id="main_content">
			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-info">
					<div class="panel-heading">系统信息</div>
					<div class="panel-body">
						<form method="post" data-ajax="true"
							data-ajax-url="<c:url value="/gateway/system/saveOrUpdate"></c:url>"
							data-ajax-loading="#Loading" data-ajax-loading-duration="1000"
							data-ajax-begin="PAGE.onPostBegin"
							data-ajax-complete="PAGE.onPostComplete">
							<fieldset>

								<input type="hidden" name="id" value="${model.id }">
								<div class="form-group">
									<label for="exampleInputName">名称</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="groupName" data-valmsg-replace="true"></span><input
										id="groupName" name="groupName" required="required"
										type="text" class="form-control" placeholder="名称"
										value="${model.groupName }" data-val="true"
										data-val-length="最长50" data-val-length-min="2"
										data-val-length-max="50" data-val-required="至少2个字符" />
								</div>
								<div class="form-group">
									<label for="exampleInputdomainName">域名</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="domainName" data-valmsg-replace="true"></span><input
										id="domainName" name="domainName" required="required"
										type="text" class="form-control" placeholder="域名"
										value="${model.domainName }" data-val="true"
										data-val-length="域名1-100" data-val-length-min="1"
										data-val-length-max="100" data-val-required="域名不能为空">
								</div>
								<div class="form-group">
									<label for="exampleInputCode">编码</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="groupCode" data-valmsg-replace="true"></span><input
										id="groupCode" name="groupCode" required="required"
										type="text" class="form-control" placeholder="编码"
										value="${model.groupCode }" data-val="true"
										data-val-length="编码2-50个字符" data-val-length-min="2"
										data-val-length-max="50" data-val-required="分组编码不能为空"
										data-val-regex="必须以字母开头，只能输入数字、字母、或下划线的组合"
										data-val-regex-pattern="^[a-zA-Z][a-zA-Z0-9_]{0,49}$">
								</div>

								<div class="form-group">
									<label for="exampleInputAuthType">认证方式</label> <span
										class="field-validation-valid text-danger"
										data-valmsg-for="authType" data-valmsg-replace="true"></span>
									<select id="authType" name="authType" class="form-control"
										data-val="true" data-val-length-max="100"
										data-val-required="认证方式不能为空"
										data-bind="options:authTypeArray,
					                       optionsText: 'name',
					                       optionsValue: 'code',
					                       value: authType,
					                       optionsCaption: '请选择...',event:{change:onAuthTypeChanged}">
									</select>
								</div>
								<script id="authJsonData" type="text/painJson">
{
	"currentAuthType":"${model.authType}",
	"currentAuthData":${model.authParm==null?"null":model.authParm},
	"authTypes":[
			<c:forEach var="item" items="${authTypes}" varStatus="status">
			{code:"${item.code }",name:"${item.name}",keyMap:"${item.getKeyMap().entrySet()}"}<c:if test="${!status.last}">,</c:if>
			</c:forEach>
	]
}
</script>
<script type="knockout/template" id="auth-param-template">
<div class="jumbotron container" data-bind="foreach: authParamArray">
<div class="form-group">
	<label data-bind="text:name,attr:{for:style}"></label> <span
		class="field-validation-valid text-danger"
		data-valmsg-replace="true" data-bind="attr:{'data-valmsg-for':style}"></span><input
		required="required" type="text" class="form-control"
		value="" data-val="true" data-val-required="不能为空"
		data-bind="attr:{id:style,name:style,value:value}"/>
</div>
</div>
</script>
								<div id="authParmDiv"  data-bind="template: { name: 'auth-param-template'}">
									<%-- 	<div class="form-group">
											<label for="IpAuth-Start">编码</label> <span
												class="field-validation-valid text-danger"
												data-valmsg-for="IpAuth-Start" data-valmsg-replace="true"></span><input
												id="IpAuth-Start" name="IpAuth-Start" required="required"
												type="text" class="form-control" placeholder="编码"
												value="${model.groupCode }" data-val="true" data-val-required="不能为空">
										</div> --%>
								</div>

								<div class="form-group">
									<label for="comment">备注</label> <span
										class="text-danger field-validation-valid"
										data-valmsg-for="comment" data-valmsg-replace="true"></span>
									<textarea id="comment" name="comment" class="form-control"
										placeholder="备注" required="required" class="form-control"
										data-val="true" data-val-length="最长255"
										data-val-length-min="0" data-val-length-max="255"
										data-val-required="备注0-255个字符">${model.comment}&nbsp;
								</textarea>
								</div>

								<div class="form-group">
									<label for="exampleInputDesc">系统状态</label> <br>
									<c:forEach items="${status}" var="item">
										<label class="radio-inline"> <input type="radio"
											name="status" value="${item.code }"
											<c:if test="${model.status.code==item.code }">checked="checked"</c:if>
											data-val="true" required="required" data-val-required="请选择状态">
											${item.desc }
										</label>
									</c:forEach>
									<span class="field-validation-valid text-danger"
										data-valmsg-for="status" data-valmsg-replace="true"></span>
								</div>

								<div id="Loading" class="text-center" style="display: none;">
									<!-- <img src='img/loading.gif' /> -->
								</div>

								<button type="submit" class="btn btn-info btn-block">保存</button>
								<div class="text-center">
									<img id="Loading" class="hide"
										src="<c:url value="/img/loading.gif"></c:url>" />
								</div>
							</fieldset>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>

<script type="application/javascript">
	
	
	/*$(function(){
		alert(23232);
		loadAuthParm();
	});*/

	/*function loadAuthParm(){
		var auth=$("#authType").val();

		if(auth =="AnonymousAuth"||auth ==""){
			$("#authParmDiv").html("");
		}else if(auth =="IpAuth"){
			$("#authParmDiv").html("");
			$("#authParmDiv").append("<label for='exampleInputAuthParm'>开始IP</label>");
			$("#authParmDiv").append("<input id='ipStart' name='ipStart' required='required' " +
					"type='text' class='form-control'  data-val='true' value='${authParmModel.ipStart}'" +
					"data-val-length='参数2-15' data-val-length-min='2'" +
					" data-val-length-max='15' data-val-required='开始IP是必需的'" + "data-val-regex='IP地址格式不正确'" +
					"data-val-regex-pattern='^(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[0-9]{1,2})(\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[0-9]{1,2})){3}$'/>");
			$("#authParmDiv").append("<label for='exampleInputAuthParm'>结束IP</label> ");
		 	$("#authParmDiv").append("<input id='ipEnd' name='ipEnd' required='required' " +
			"type='text' class='form-control'  data-val='true' value='${authParmModel.ipEnd}'" +
			"data-val-length='参数2-15' data-val-length-min='2'" +
			"data-val-length-max='15' data-val-required='结束IP是必需的'" + "data-val-regex='IP地址格式不正确'" +
			"data-val-regex-pattern='^(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[0-9]{1,2})(\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[0-9]{1,2})){3}$'/>");
		}else{
			$("#authParmDiv").html("");
			$("#authParmDiv").append("<label for='exampleInputAuthParm'>私钥</label>");
			$("#authParmDiv").append("<input id='privateKey' name='privateKey' required='required' " +
					"type='text' class='form-control'  data-val='true' value='${authParmModel.privateKey}'" +
					"data-val-length='参数1-32' data-val-length-min='2'" +
					" data-val-length-max='32' data-val-required='私钥参数是必需的'/>" );
		}
	}*/


</script>
</html>