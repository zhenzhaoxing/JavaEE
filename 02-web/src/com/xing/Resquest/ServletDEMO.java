package com.xing.Resquest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletDEMO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		
    		throws ServletException, IOException {
    	//现在使用的提交方式  只适用post  get不能用也没有效果
    	request.setCharacterEncoding("UTF-8");
    	
    	request.setAttribute("zhen", "666");
    	request.getAttribute("zhen");
    	//请求转发
    	request.getRequestDispatcher("/Ser").forward(request, response);
    	//获取单个请求体
    	String parameter = request.getParameter("username");
    	System.out.println(parameter);
    	/***********1.请求行***********************/
		//1.1获取请求方式  get post
		String method = request.getMethod();
		System.out.println(method);
		//1.2请求资源 URL URI
		StringBuffer requestURL = request.getRequestURL();
		String requestURI = request.getRequestURI();
		System.out.println("getRequestURL = "+requestURL);
		System.out.println("getRequestURI ="+requestURI);
		//1.3获取get请求参数
		String queryString = request.getQueryString();
		System.out.println("getQueryString  = "+queryString);
		//1.4获取当前web应用名称 
		String contextPath = request.getContextPath();
		System.out.println("getContextPath = " +contextPath);
		
		
		/***********2.请求头***********************/
		//1.获取所有的请求头名称
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			System.out.println("name = "+headerNames.nextElement());
		}
		//2.根据名称获取指定的头信息
		String header = request.getHeader("referer");
		System.out.println("referer  = "+ header);
				
		//3.打印所有的请求头和请求头内容
		Enumeration<String> headerNames2 = request.getHeaderNames();
		while(headerNames2.hasMoreElements()) {
			//获取请求名称
			String name = headerNames2.nextElement();
			String value = request.getHeader(name);
			System.out.println(name +":"+value);
		}	
		/***********3.请求体***********************/
		//1.获取一个值
		String name =  request.getParameter("username");
		System.out.println(name);
		//2.获取多个值
		String[] parameterValues = request.getParameterValues("hobby");
		System.out.println(Arrays.toString(parameterValues));
		//3.获取所有请求参数名称
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()) {
			System.out.println("name="+parameterNames.nextElement());
		}
		System.out.println("---------------");
		
		//4.获取所有请求参数
		Map<String, String[]> parameterMap = request.getParameterMap();
		//遍历所有请求参数名称与值
		for (Map.Entry<String, String[]> entry: parameterMap.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(Arrays.toString(entry.getValue()));
		}
	}

}
