<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<li <c:if test="${param.nav==null||param.nav=='system'}"> class="current"</c:if>><a href="<c:url value="/provider/system/list"/>"><span class="glyphicon glyphicon-th-large" aria-hidden="true"></span> 系统管理</a></li>
<li <c:if test="${param.nav=='module'}"> class="current"</c:if>><a href="<c:url value="/provider/module/list"/>"><span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span> 模块管理</a></li>
<li <c:if test="${param.nav=='endpoint'}"> class="current"</c:if>><a href="<c:url value="/provider/endpoint/list"/>"><span class="glyphicon glyphicon-indent-right" aria-hidden="true"></span> 接口管理</a></li>