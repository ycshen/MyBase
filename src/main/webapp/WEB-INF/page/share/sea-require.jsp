<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="<c:url value="/sea-modules/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/sea-modules/pages/common.css"/>" rel="stylesheet">

<script type="text/javascript" src="<c:url value="/sea-modules/sea.js"/>"></script>
<script type="text/javascript" src="<c:url value="/sea-modules/sea-config.js"/>"></script>
<c:if test="${param.module!=null}">
<script type="text/javascript">
var PAGE = null;
seajs.use("${param.module}",function(page){
	PAGE=page;
});
</script>
</c:if>
