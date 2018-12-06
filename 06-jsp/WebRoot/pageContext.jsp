<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'pageContext.jsp' starting page</title>
    
	

  </head>
  
  <body>
  
  
  <%
  
  pageContext.setAttribute("zh", 110);
  
  pageContext.setAttribute("request", "requestTest", PageContext.REQUEST_SCOPE);
	
	pageContext.setAttribute("session", "sessionTest", pageContext.SESSION_SCOPE);
  
   %>
   
   <%=pageContext.getAttribute("zh") %><br>
   <%=pageContext.getAttribute("request") %><br>
   <%=session.getAttribute("session") %>
<%
	HttpSession s = pageContext.getSession();
	System.out.println(s.getAttribute("session"));

%>

  </body>
</html>
