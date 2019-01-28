package com.xing.cookie;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LastServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 //1.获取当前的日期
	 		Date date = new Date();
	 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	 		String formatDate = sdf.format(date);
	   //吧日期写到cookie
	 		Cookie cookie = new Cookie("lastTime",formatDate);
	 		//可以设置持久时间
			cookie.setMaxAge(60*10); 
			//3.响应给浏览器
			response.addCookie(cookie);
			String lastTime = null;
			//取cookie
			Cookie[] cookies = request.getCookies();
			
			if(cookies != null) {
				for (Cookie c : cookies) {
					if(c.getName().equals("lastTime")) {
						lastTime =  c.getValue();
					}
				}
			}
			
			response.setContentType("text/html;charset=utf-8");
			if(lastTime != null) {
				response.getWriter().write("上次的登录时间为："+lastTime);
			}else {
				response.getWriter().write("你是第一次登录 ");
			}
			
			
			System.out.println("sssssss");
		}

	}
