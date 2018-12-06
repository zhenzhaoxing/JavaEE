package com.xing.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class xmlServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String xml = "<students>" +
				"<student number='ITCAST_1001'>" +
				"<name>zhangSan</name>" +
				"<age>18</age>" + 
				"<sex>male</sex>" +
				"</student>" +
				
				"</students>";
			
			response.setContentType("text/xml;charset=utf-8");
			response.getWriter().print(xml);
		}
	}
