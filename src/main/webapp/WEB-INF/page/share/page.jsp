<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String url = request.getParameter("url");
	int totalCount = 0;
	if(request.getParameter("count")!=null && !request.getParameter("count").equals(""))
		totalCount = Integer.parseInt(request.getParameter("count"));
	int currPage = 1;
	if(request.getParameter("page")!=null&& !request.getParameter("page").equals(""))
		currPage = Integer.parseInt(request.getParameter("page"));
	
	int pageSize = 10;
	if(request.getParameter("size")!=null&& !request.getParameter("size").equals(""))
		pageSize = Integer.parseInt(request.getParameter("size"));
	
	int totalPage = totalCount / pageSize;
	if (totalCount % pageSize > 0)
		totalPage++;
	boolean isFirstPage = currPage == 1;
	boolean isLastPage = currPage == totalPage;

	int showPageItemCount = 3;
	int startPage = currPage - showPageItemCount;
	int endPage = currPage + showPageItemCount;
	if (startPage < 1) {
		endPage = endPage - startPage + 1;
	}
	if (endPage > totalPage) {
		startPage = startPage - (endPage - totalPage);
	}
	if (startPage < 1) {
		startPage = 1;
	}
%>
<!-- 
<%=totalCount%>-<%=currPage%>-<%=pageSize%>=<%=totalPage%>
 -->
<ul class="pagination">
	<li><a href="#" style="cursor:not-allowed;">总计<%= totalCount%>条</a></li>
	<li <%=isFirstPage ? "class='disabled'" : ""%>><a
		href="<%=isFirstPage ? "#" : (url + 1)%>" aria-label="First"><span
			aria-hidden="true">&laquo;</span></a></li>
	<%
		for (int i = startPage; i <= endPage; i++)
			if (i > 0 && i <= totalPage) {
	%>
	<li <%=i == currPage ? " class='active'" : ""%>><a
		data-toggle="tooltip"
		title="当前第<%=currPage%>/<%=totalPage%>页　总共<%=totalCount%>条数据　每页显示<%=pageSize%>条数据"
		href="<%=url + i%>"><%=i%></a></li>
	<%
		}
	%>
	<%-- 	<li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li>
	<li><a href="#">2</a></li>
	<li><a href="#">3</a></li>
	<li><a href="#">4</a></li>
	<li><a href="#">5</a></li> --%>
	<li <%=isLastPage ? "class='disabled'" : ""%>><a
		href="<%=isLastPage ? "#" : (url + totalPage)%>" aria-label="Last">
			<span aria-hidden="true">&raquo;</span>
	</a></li>
	<li><a href="#" style="cursor:not-allowed;">共<%= totalPage%>页</a></li>
</ul>