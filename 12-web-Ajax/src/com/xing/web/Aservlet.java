package com.xing.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import domain.Person;

public class Aservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().write("hello Ajax 我是真真");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
			
		System.out.println(request.getParameter("name"));
		response.getWriter().write("hel  这是post请求方式");
		
		
		Person q = CommonUtils.toBean(request.getParameterMap(), Person.class);
		             String uuid = CommonUtils.uuid();
		             System.out.println(uuid);
		System.out.println(q.getName());
		
		System.out.println(q);
		
		
		
		
		
		
	}
		
	}


