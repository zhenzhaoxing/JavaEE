<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>



</head>

<body>
	<table border="1">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
		<c:forEach items="${PageInfo.list }" var="pi">
			<tr>
				<td>${pi.id }</td>
				<td>${pi.name }</td>
				<td>${pi.age }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="ShowServlet?pageNumber=${PageInfo.pageNumber-1 }&pageSize=${PageInfo.pageSize}" <c:if test="${PageInfo.pageNumber<=1 }">  onclick="javascript:return false;" </c:if> >上一页</a>
	<a href="ShowServlet?pageNumber=${PageInfo.pageNumber+1 }&pageSize=${PageInfo.pageSize}" <c:if test="${PageInfo.pageNumber>=PageInfo.total }">  onclick="javascript:return false;" </c:if> >下一页</a>
  </body>
</html>
