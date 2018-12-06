<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<script type="text/javascript" src="js/jquery-1.7.2.js">

</script>
<script type="text/javascript">



$(function(){
   $("a").click(function(){
     /*  当前对象的父类的上一层 */
        var $td=$(this).parent().prev();
       $td.html(parseInt($td.html())+1);
   })
   

})
</script>

</head>
<body>
     <table border="1">
	<tr>
		<td>资料名称</td>
		<td>下载次数</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list }" var="file">
		<tr>
			<td>${file.name }</td>
			<td>${file.count }</td>
			<td><a href="download?id=${file.id }&name=${file.name}">下载</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
