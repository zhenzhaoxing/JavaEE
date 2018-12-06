package com.xing.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class fwsw extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ServletContext context = this.getServletContext();
	Integer count = (Integer) context.getAttribute("count");
	
	if(count==null){
		count=1;
	}else{
		count++;
	}
	response.setContentType("text/html;charset=utf-8");
	//response.getWriter().write("<h1>本页面一共被访问" + count + "次！</h1>");
	context.setAttribute("count", count);
	
	request.setAttribute("count", count);
	System.out.println("ss");
}
}
