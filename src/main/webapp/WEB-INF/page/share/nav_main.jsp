<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%> --%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Cookie[] cookies = request.getCookies();
	String nav_panel_state = "";
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			// 获得具体的Cookie
			Cookie cookie = cookies[i];
			// 获得Cookie的名称
			String name = cookie.getName();
			if("nav_panel_state".equals(name)){
				String value = cookie.getValue();
				nav_panel_state = "nav_panel_"+value;
			}
		}
	}
%>

<div id="nav_panel" class="text-center <%=nav_panel_state%>">
	<div id="nav_logo">
		<img class="img-responsive" alt="" tabindex="0" style="width:3em;height:3em;"
			src="<c:url value="/img/logo.png"/>"> <span>企家婆</span>
	</div>
	<div id="nav_panel_draw">
		<a href="javascript:void(0)"><span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></a>
	</div>
	
	<div id="nav_panel_goGroup">
		<a href="<c:url value="/"></c:url>"><span class="glyphicon glyphicon-home"
			aria-hidden="true"></span> </a> <span class='title'>主菜单</span>
	</div>
	
	<div id="nav_ext">
		<a href="<c:url value="/logout"></c:url>" data-toggle="tooltip"
			data-placement="auto" title="【user】退出登陆  "><span
			class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
			${sessionScope.account}</a>
	</div>
	<hr>
	<div id="nav_list" class="scrollbar">
		<ul>
			<li
				<c:if test="${param.nav==null||param.nav=='list_company'}"> class="current"</c:if>><a
				data-toggle="tooltip" data-placement="auto right"
				href="<c:url value="/inner/company/list"/>" title="公司信息"><span
					class="glyphicon glyphicon-scale" aria-hidden="true"></span>公司信息</a></li>
			<li <c:if test="${param.nav=='list_department'}"> class="current"</c:if>><a
				data-toggle="tooltip"
				href="<c:url value="/inner/department/list"/>"
				data-placement="auto right" title="部门信息"><span
					class="glyphicon glyphicon-tower" aria-hidden="true"></span>部门信息</a></li>
			<li <c:if test="${param.nav=='list_user'}"> class="current"</c:if>><a
				data-toggle="tooltip"
				href="<c:url value="/inner/user/list"/>"
				data-placement="auto right" title="员工信息"><span
					class="glyphicon glyphicon-tower" aria-hidden="true"></span>员工信息</a></li>
			<li <c:if test="${param.nav=='list_config'}"> class="current"</c:if>><a
				data-toggle="tooltip"
				href="<c:url value="/inner/config/list"/>"
				data-placement="auto right" title="code"><span
					class="glyphicon glyphicon-modal-window" aria-hidden="true"></span>基础配置</a></li>
			<li <c:if test="${param.nav=='list_menu'}"> class="current"</c:if>><a
				data-toggle="tooltip"
				href="<c:url value="/inner/menu/list"/>"
				data-placement="auto right" title="code"><span
					class="glyphicon glyphicon-modal-window" aria-hidden="true"></span>菜单管理</a></li>
			
			
			
			
		</ul>
	</div>


<%--
	<div id="syslistcon">
		<div class="syslist">
			<button type="button" class="btn btn-info btn-lg">
				<span class="glyphicon glyphicon-retweet" aria-hidden="true"></span>
				<div>调度</div>
			</button>
			<button type="button" class="btn btn-success btn-lg">
				<span class="glyphicon glyphicon-transfer" aria-hidden="true"></span>
				<div>日志</div>
			</button>
			<button type="button" class="btn btn-warning btn-lg">
				<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
				<div>监控</div>
			</button>
		</div>
	</div>
--%>

</div>