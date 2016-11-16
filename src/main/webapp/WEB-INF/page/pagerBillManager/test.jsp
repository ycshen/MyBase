<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>面单区号管理</title><link href="${ctx}/css/index.css" rel="stylesheet">
<script src="${ctx}/js/jquery.js" type="text/javascript"></script>
<script src="${ctx}/js/layer/layer.js" type="text/javascript"></script>

</head>
<body>
<header class="m-d-y-w-w-h">
	1111
    
</header>
<div class="m-d-y-w-w-h-ct" id="divTest">
123132112323<input type="button" value="弹出div" onclick="getDiv();"/>
</div>
<script type="text/javascript">
	
	function getDiv(){
		var html = $("#divTest").html();
		layer.open({
			  type: 1,
			  skin: 'layui-layer-rim', //加上边框
			  area: ['420px', '240px'], //宽高
			  content: html
		});
	}
	
</script>
</body>
</html>