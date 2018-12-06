package com.xing.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.xing.domain.Stu;
import com.xing.util.JdbcUtil;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//先获取请求参数
		
			String name = request.getParameter("username");
			String pwd = request.getParameter("password");
			
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "select*from used where username=? and password=?";
		Stu u = null;
		try {
			u= qr.query(sql, new BeanHandler<Stu>(Stu.class),name,pwd);
	System.out.println(u);
		} catch (SQLException e) {
		}
		response.setContentType("text/html;charset=utf-8");
		//1.有值
				if(u != null) {
					response.getWriter().write("登录成功");
					//跳转到登录
					response.setHeader("refresh", "3;url=/04-webDL/index.html");
				}else {
					response.getWriter().write("登录失败");
					//跳转到登录
					response.setHeader("refresh", "3;url=/04-webDL/login.html");
				}
				
			}

		}
	
	
	
	

   