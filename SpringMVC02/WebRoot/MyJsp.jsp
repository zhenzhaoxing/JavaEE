<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>

	<form action="demo5" method="post">


		<input type="checkbox" name="hover" value="吃饭"> <input
			type="checkbox" name="hover" value="睡觉"> <input
			type="checkbox" name="hover" value="喝水"> <input type="text"
			name="passwords"> <input type="submit" value="提交">
	</form>
<a href="demo4/这哪啊/123">跳转</a>
<!-- <a href="demo5?name=%id=123">跳转</a> -->
</body>
</html>
