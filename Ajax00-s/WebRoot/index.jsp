<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
</head>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">

	$(function() {

		$("a").click(function() {



			$.ajax({
				url : 'ShowServlet',
				data: {
					"name":"张三"
				},
				type : "POST",
				success : function(data) {
					for (var i = 0; i < data.length; i++) {
						alert(data.id + data.username)
					}
				},
				error : function() {
					alert("请求有错")
				}
			})

			return false;
		})




	})
</script>
<body>
	<a href="#">14</a>
	<form action="/show" method="post">
		<input type="submit" value="提交">

	</form>
</body>
</html>
