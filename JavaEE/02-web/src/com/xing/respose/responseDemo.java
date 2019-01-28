package com.xing.respose;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class responseDemo extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setCharacterEncoding("utf-8");
       request.setCharacterEncoding("utf-8");
		
		//相应
		
		response.getWriter().write("dd");
        response.setHeader("content-type", "text/html;charset=utf-8");
		response.setHeader("Refresh","5; URL=http://www.itcast.cn");
	//response.sendRedirect("http://www.baidu.com");
	
	
	
	}

}
