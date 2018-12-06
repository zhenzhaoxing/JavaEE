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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">


	$(function() {
     var username = false;
	var password = false;
	var password1 = false;
	/* //用户名判断 */
     $(":text:eq(0)").blur(function(){
        if($(this).val()==""){
         $(this).next().css("color","red").html("X");
         username=false
        }else{
         $(this).next().css("color","green").html("√");
           username=true;
        }
     })
/*      密码判断 */
     
     
     $(":password:eq(0)").blur(function(){
        if(!$(this).val().match(/^\w{6,12}$/)||$(this).val()==""){
         $(this).next().css("color","red").html("X");
         password=false
        }else{
         $(this).next().css("color","green").html("√");
           password=true;
        }
     })
     
     /*      确认密码 */
     
      $(":password:eq(1)").blur(function(){
        if($(this).val()!=$(":password:eq(0)").val()||$(this).val()==""){
         $(this).next().css("color","red").html("X");
         password1=false
        }else{
         $(this).next().css("color","green").html("√");
           password1=true;
        }
     })
     /* 提交 */
     
     $(":submit").click(function(){
        if(username==false||password==false||password1==false){
         alert("请填写完整信息")
         return false;
        }
     })
     
	});
</script>
</head>
<body>
	<form action="register" method="post" enctype="multipart/form-data">
用户名	<input type="text" name="username"> <span></span><br/>
密码	    <input type="password" name="password"> <span></span><br/>
确认密码	<input type="password" name="passwoed1"> <span></span><br/>
头像	    <input type="file" name="file">
	    <input type="submit" value="提交"><br>
	    </form>
</body>
</html>