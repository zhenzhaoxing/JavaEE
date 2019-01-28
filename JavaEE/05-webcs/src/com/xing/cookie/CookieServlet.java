package com.xing.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//浏览器开空间
	   req.getCookies();
	   Cookie cookie = new Cookie("li", "it44");
	   /**
		 默认情况cookie是会话级别
		 打开浏览器，关闭浏览器为一次会话
		 如果不设置持久化时间，cookie会存储在浏览器的内存中，浏览器关闭	cookie信息销毁
		 
		 默认情况下会在访问创建cookie的web资源相同的路径
		http://localhost:8080/29-Cookie-Seesion/CookieServlet
		http://localhost:8080/29-Cookie-Seesion/CookieServlet2
		
		http://localhost:8080/29-Cookie-Seesion/myxq/CookieServlet
		http://localhost:8080/29-Cookie-Seesion/CookieServlet2
		
		都携带cookie信息
		*/

		//设置Cookie在客户端的存储时间
		//cookie.setMaxAge(60);
		//cookie.setPath("/29-Cookie-Seesion");
		//cookie.setPath("/29-Cookie-Seesion/CookieServlet2");
		//2.响应给浏览器
	  cookie.setDomain(".legou.com");
		resp.addCookie(cookie);
	   req.getRequestDispatcher("/index.jsp").forward(req, resp);
	   
}
}
