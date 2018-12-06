package com.xing.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class firstServlet
 */
public class firstServlet extends HttpServlet {
	
	/**
	 servlet什么 时候被创建？
	  默认：第一次访问的时候会被 创建
	  通过配置可以设置服务器一启动的时候就创建对象
	  创建的对象会被 缓存
	 
	 init 当servlet创建的时候调用
	/**
	 service 当每一次发送请求的时候就会调用 
	                        每发送一次就会调用 一次
	 * */
	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		 String queryString = request.getQueryString();
			System.out.println(queryString);
			System.out.println("request.getContentLength(): " + request.getContentLength());
			System.out.println("request.getContentType(): " + request.getContentType());
			System.out.println("request.getContextPath(): " + request.getContextPath());
			System.out.println("request.getMethod(): " + request.getMethod());
			System.out.println("request.getLocale(): " + request.getLocale());
				
			System.out.println("request.getQueryString(): " + request.getQueryString());
			System.out.println("request.getRequestURI(): " + request.getRequestURI());
			System.out.println("request.getRequestURL(): " + request.getRequestURL());
			System.out.println("request.getServletPath(): " + request.getServletPath());
			System.out.println("request.getRemoteAddr(): " + request.getRemoteAddr());
			System.out.println("request.getRemoteHost(): " + request.getRemoteHost());
			System.out.println("request.getRemotePort(): " + request.getRemotePort());
			System.out.println("request.getScheme(): " + request.getScheme());
			System.out.println("request.getServerName(): " + request.getServerName());
			System.out.println("request.getServerPort(): " + request.getServerPort());
		}
	
   @Override
   //
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	 String queryString = request.getQueryString();
	System.out.println(queryString);
	System.out.println("request.getContentLength(): " + request.getContentLength());
	System.out.println("request.getContentType(): " + request.getContentType());
	System.out.println("request.getContextPath(): " + request.getContextPath());
	System.out.println("request.getMethod(): " + request.getMethod());
	System.out.println("request.getLocale(): " + request.getLocale());
		
	System.out.println("request.getQueryString(): " + request.getQueryString());
	System.out.println("request.getRequestURI(): " + request.getRequestURI());
	System.out.println("request.getRequestURL(): " + request.getRequestURL());
	System.out.println("request.getServletPath(): " + request.getServletPath());
	System.out.println("request.getRemoteAddr(): " + request.getRemoteAddr());
	System.out.println("request.getRemoteHost(): " + request.getRemoteHost());
	System.out.println("request.getRemotePort(): " + request.getRemotePort());
	System.out.println("request.getScheme(): " + request.getScheme());
	System.out.println("request.getServerName(): " + request.getServerName());
	System.out.println("request.getServerPort(): " + request.getServerPort());

	
	/**
	 destroy 当servlet销毁的时候调用
	 		 当服务器关闭的时候来调用
	 * */
}
}
