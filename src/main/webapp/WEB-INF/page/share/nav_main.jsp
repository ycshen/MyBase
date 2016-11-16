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
			src="<c:url value="/img/logo.png"/>"> <span>BRP</span>
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
			
			<li <c:if test="${param.nav=='bill_type'}"> class="current"</c:if>><a
				data-toggle="tooltip"
				href="<c:url value="/bill/type/list"/>"
				data-placement="auto right" title="面单类型"><span
					class="glyphicon glyphicon-modal-window" aria-hidden="true"></span>面单类型</a></li>
			
			<li <c:if test="${param.nav=='bill_district'}"> class="current"</c:if>><a
				data-toggle="tooltip"
				href="<c:url value="/bill/district"/>"
				data-placement="auto right" title="区号维护"><span
					class="glyphicon glyphicon-tower" aria-hidden="true"></span>区号维护</a></li>
			
			<li <c:if test="${param.nav=='bill_init'}"> class="current"</c:if>><a
				data-toggle="tooltip"
				href="<c:url value="/billinit/list"/>"
				data-placement="auto right" title="单号初始化"><span
					class="glyphicon glyphicon-plane" aria-hidden="true"></span>单号初始化</a></li>
			<li <c:if test="${param.nav=='bill_manage'}"> class="current"</c:if>><a
					data-toggle="tooltip"
					href="<c:url value="/billManage/list"/>"
					data-placement="auto right" title="面单管理"><span
					class="glyphicon glyphicon-plane" aria-hidden="true"></span>面单管理</a></li>

			<li <c:if test="${param.nav=='bill_out'}"> class="current"</c:if>><a
				data-toggle="tooltip"
				href="<c:url value="/bill/out"/>"
				data-placement="auto right" title="面单出库"><span
					class="glyphicon glyphicon-log-out" aria-hidden="true"></span>面单出库</a></li>
			<li <c:if test="${param.nav=='bill_approve'}"> class="current"</c:if>><a
				data-toggle="tooltip"
				href="<c:url value="/bill/approve"/>"
				data-placement="auto right" title="面单申请"><span
					class="glyphicon glyphicon-log-out" aria-hidden="true"></span>面单申请</a></li>
					
			<%-- <li <c:if test="${param.nav=='usermgr'}"> class="current"</c:if>><a
				data-toggle="tooltip"
				href="<c:url value="/sysmgr/usermgr/list"/>"
				data-placement="auto right" title="账户管理"><span
					class="glyphicon glyphicon-th" aria-hidden="true"></span>账户管理</a></li> --%>			
						
			<%-- <li <c:if test="${param.nav=='about'}"> class="current"</c:if>><a
				data-toggle="tooltip" href="<c:url value="/busSystemController/getBusSystemGroupList"/>"
				data-placement="auto right" title="关于"><span
					class="glyphicon glyphicon-paste" aria-hidden="true"></span>关于</a></li> --%>
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