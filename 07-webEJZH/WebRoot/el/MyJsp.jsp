
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
     
   
   <form action="/07-webEJZH/RegistServlet" method="post">
   
    mima: <input type="text" name="username">
   

   <input type="submit" class="login_btn" value="登录">
   </form>

   
    <c:if test="${!empty name }">
           		欢迎： ${name }
                <a href="#">退出</a>
            </c:if>
   
   
   
   
   
   <c:out value="aaa"></c:out>
  
   
<%

session.setAttribute("zhen", "90".toString());

 %>
   
   
  
   
   <c:set var="score" value="${zhen }"></c:set>
   
   <!-- test里的值为真就执行里面的语句 -->
   <c:if test="${  empty score }">
   zhen
   </c:if>
  
   
   
   
   
   
   
   
    
       <!-- choose 相当于if/else if/else -->
   <c:choose>
   
   <c:when test="${scoe>100 }">
   错误
   </c:when>
   <c:when test="${score>=90 }">
   优秀
   </c:when>
    <c:when test="${score>=60 }">
   及格
   </c:when>
   
   <c:otherwise>不及格</c:otherwise>
   
   
   </c:choose>
   
   
   
   
   <!--    以前在from里面提交的时候 都是 action=" /07-webEJZH/LoginServlet "
   现在只需加 c url 就可以了
    -->

   <c:url value="/LoginServlet"/>
   
   <c:url value="/loginServlet"/>
   
   
   <!-- 下面的是 循环遍历形式   -->
   
  
  
   <%
   String [] names = {"zhang","zhen","peng","xing"};
   pageContext.setAttribute("names", names);
    %>
   
   
   <c:forEach  var="namn" items="${names }">
   ${namn }
   <c:out value="name: ${namn }"/><br/>
   </c:forEach>
   
   
   <c:forEach items="${names }" var="name">
   
   </c:forEach>
   
  </body>
</html>
