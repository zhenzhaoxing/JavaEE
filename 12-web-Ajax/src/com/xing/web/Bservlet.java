package com.xing.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Bservlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		/*
		 * 1. 获取参数username
		 * 2. 判断是否为itcast
		 *   3. 如果是：响应1
		 *   4. 如果不是：响应0
		 */
		String username = request.getParameter("username");
		if(username.equalsIgnoreCase("itcast")) {
			response.getWriter().print("1");
//			System.out.println("ssssss");
		} else {
			response.getWriter().print("0");
		}
	}

}
