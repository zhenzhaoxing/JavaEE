<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'index.jsp' starting page</title>
	
  </head>
  
  <body>
   
   aaa
   <%="bbb" %>
   <%
   out.write("ccc");
   response.getWriter().write("ddd");
   out.write("fff");
    %>
    <%--这是注释 --%>
  </body>
</html>
