<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<body>

	<div id="main" class="container-fluid">


		<div id="main_content">


			<div id="main_body" style="padding: 0.6em;">
				<div class="panel panel-default">

					<div class="table-responsive">
						<table id="syslist" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>状态</th>
									<th>员工姓名</th>
									<th>联系方式</th>
									<th>创建人</th>
									<th>创建时间</th>
									<th>更新人</th>
									<th>更新时间</th>
								</tr>
							</thead>
							<tbody >
								<c:forEach items="${userQuery.items}" var="user">
									<tr>
										<td>
											<c:choose>
												<c:when test="${user.status == 100 }"><span style="color:red;">离职</span>
												
												</c:when>
												<c:when test="${user.status == 102 }"><span style="color:green;">禁用</span>
												</c:when>
												<c:otherwise>在职
												</c:otherwise>
											</c:choose>
										</td>
										
										<td>${user.userName}</td>
										<td>${user.telphone}</td>
										<td>${user.createUser}</td>
										<td><f:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td>${user.updateUser}</td>
										<td><f:formatDate value="${user.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="panel-footer" style="padding: 0.3em;">
						<nav class="text-center">
							<%@include file="department_user_list_page.jsp" %>
							<input type="hidden" value="${userQuery.count}" id="count"/>
							
							<input type="hidden" value="${userQuery.departmentId}" id="txtDepartmentId"/>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<%-- <script type="text/javascript" src="${ctx}/js/jquery.js"></script> --%>
<script type="text/javascript" src="${ctx}/js/pages/department/department_list.js"></script>

</body>
</html>



