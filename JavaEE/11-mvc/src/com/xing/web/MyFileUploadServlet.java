package com.xing.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.xing.domain.MyFile;
import com.xing.service.MyFileService;
import com.xing.util.JdbcUtil;

public class MyFileUploadServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//先获取请求参数
		
		String name = request.getParameter("username");
		
		
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select*from MyFile where username=? ";
		MyFile u = null;
	try {
		u= qr.query(sql, new BeanHandler<MyFile>(MyFile.class),name);
System.out.println(u);
	} catch (SQLException e) {
	}
	response.setContentType("text/html;charset=utf-8");
	//1.有值
			if(u != null) {
				response.getWriter().print(1);;
				//跳转到登录
				//response.setHeader("refresh", "3;url=/04-webDL/index.html");
			}else {
				response.getWriter().print(0);
				//跳转到登录
				//response.setHeader("refresh", "3;url=/04-webDL/login.html");
			}
			
		}

	}





