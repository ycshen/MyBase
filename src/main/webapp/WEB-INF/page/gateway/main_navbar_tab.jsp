<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<li <c:if test="${param.nav==null||param.nav=='system'}"> class="current"</c:if>><a href="<c:url value="/gateway/system/list"/>"><span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span> 接入系统</a></li>
<li <c:if test="${param.nav=='api'}"> class="current"</c:if>><a href="<c:url value="/gateway/apigroup/list"/>"><span class="glyphicon glyphicon-indent-right" aria-hidden="true"></span> 系统接口</a></li>
