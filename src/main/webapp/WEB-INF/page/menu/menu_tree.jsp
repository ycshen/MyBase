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
<style>
/**
 * Document defaults
 */
body {
  background-color: #eee;
}

* {
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
}

/* The loader container */
.loader {
  position: absolute;
  top: 50%;
  left: 50%;

  width: 200px;
  height: 200px;

  margin-top: -100px;
  margin-left: -100px;

  perspective: 100px;
  transform-type: preserve-3d;

  animation: loader 6s cubic-bezier(0,0,1,1) infinite;
}

/* Loader animation */
@keyframes loader {
  0% {
    transform: rotateX(30deg) rotateZ(0deg);
  }
  100% {
    transform: rotateX(30deg) rotateZ(-360deg);
  }
}

/* The dot */
.dot {
  position: absolute;
  top: 50%;
  left: 50%;
  z-index: 10;

  width: 20px;
  height: 20px;

  margin-top: -90px;
  margin-left: -10px;

  border-radius: 10px;

  background-color: #1e3f57;

  transform-type: preserve-3d;
  transform-origin: 50% 90px;
  transform: rotateZ(30deg);

  animation: dot1 1.5s cubic-bezier(.6,0,.4,1) infinite;
}

.dot:nth-child(2) {
  transform: rotateZ(15deg);
  animation-name: dot2;
  animation-delay: 150ms;
  background-color: #2d556d;
}

.dot:nth-child(3) {
  transform: rotateZ(0deg);
  animation-name: dot3;
  animation-delay: 300ms;
  background-color: #447891;
}

.dot:nth-child(4) {
  transform: rotateZ(-15deg);
  animation-name: dot4;
  animation-delay: 450ms;
  background-color: #5998b2;
}

.dot:nth-child(5) {
  transform: rotateZ(-30deg);
  animation-name: dot5;
  animation-delay: 600ms;
  background-color: #6bb2cd;
}

/* Dot animations */
@keyframes dot1 {
  0% {
    transform: rotateZ(30deg) rotateX(10deg);
  }
  95%, 100% {
    transform: rotateZ(390deg) rotateX(10deg);
  }
}

@keyframes dot2 {
  0% {
    transform: rotateZ(15deg) rotateX(10deg);
  }
  95%, 100% {
    transform: rotateZ(375deg) rotateX(10deg);
  }
}

@keyframes dot3 {
  0% {
    transform: rotateZ(0deg) rotateX(10deg);
  }
  95%, 100% {
    transform: rotateZ(360deg) rotateX(10deg);
  }
}

@keyframes dot4 {
  0% {
    transform: rotateZ(-15deg) rotateX(10deg);
  }
  95%, 100% {
    transform: rotateZ(345deg) rotateX(10deg);
  }
}

@keyframes dot5 {
  0% {
    transform: rotateZ(-30deg) rotateX(10deg);
  }
  95%, 100% {
    transform: rotateZ(330deg) rotateX(10deg);
  }
}
</style>

<script src="${ctx}/js/single-loaders/js/prefixfree.min.js"></script>

<script src="${ctx}/js/single-loaders/js/modernizr.js"></script>
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
					<div class="panel-heading">菜单权限信息列表</div>
					<div class="panel-heading"><a href="${ctx}/inner/menu/list">列表菜单</a></div>
					<div class="table-responsive">
					<br/>
						&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="添加菜单事件" id="btnAddSub"  class="btn btn-default"/>
						&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="查看详细" id="btnView"  class="btn btn-default"/>
						<br/><br/>
						<div id="tree"></div>   
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
<script type="text/javascript" src="${ctx}/js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/treeview/bootstrap-treeview.js"></script>
<script type="text/javascript" src="${ctx}/js/pages/menu/menu_tree.js"></script>
 <div class="loader" id="divLoader">
	  <div class="dot"></div>
	  <div class="dot"></div>
	  <div class="dot"></div>
	  <div class="dot"></div>
	  <div class="dot"></div>
	</div>
</body>
</html>



