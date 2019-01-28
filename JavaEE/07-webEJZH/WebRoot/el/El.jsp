<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'El.jsp' starting page</title>
    
	

  </head>
  
  <body>
  
<%
	pageContext.setAttribute("name", "pageContextValue");
	request.setAttribute("name", "requestValue");
	session.setAttribute("name", "sessionValue");
	application.setAttribute("name", "applicationValue");
%>
${pageScope.name }
<br/>
${requestScope.name }
<br/>
${sessionScope.name }
<br/>
${applicationScope.name }
<br>
${name }<br>
${1+1 }
  </body>
</html>
