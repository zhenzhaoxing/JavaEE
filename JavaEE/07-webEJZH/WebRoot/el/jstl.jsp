<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'jstl.jsp' starting page</title>
    
	

  </head>
  
  <body>
    <%
    request.setAttribute("count", 50);
     %>
    <c:if test="${1==1 }">
    <h1>dui1</h1>
    </c:if>
    <c:if test="${count>50 }">
    <h1>count>50</h1>
    </c:if>
     <c:if test="${count<=50 }">
    <h1>count<=50</h1>
    </c:if>
    <hr>
    
  
  </body>
</html>
