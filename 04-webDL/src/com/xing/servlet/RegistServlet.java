package com.xing.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.xing.domain.Stu;
import com.xing.util.JdbcUtil;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		//设置请求编码 与响应的编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取参数  验证码
		String code = request.getParameter("code");
		System.out.println("code="+code);
		//获取服务器生成的验证码  
		String word = (String) this.getServletContext().getAttribute("checkCode");
		//判断输入的验证
		if(code.equals(word)) {
			//如果正确 
			//1.接收所有参数
			Map<String, String[]> parameterMap = request.getParameterMap();
			Stu u = new Stu();
			//2.把接收的参数封装成User对象
			
				try {
					
					BeanUtils.populate(u, parameterMap);
				
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			//3.设置uid
			u.setId(UUID.randomUUID().toString());
			//4.写入到数据库
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			String sql ="insert into student values(?,?,?,?)";
			//String sqlq ="";
			try {
				qr.update(sql,u.getId(),u.getUsername(),u.getPassword(),u.getPhone());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.getWriter().write("注册成功");
			//跳转到登录
			response.setHeader("refresh", "3;url=/04-webDL/login.html");
		}else {
			//不正确 ，告诉用户验证码错误，跳转回注册页
			response.getWriter().write("验证码错误");
			response.setHeader("refresh", "3;url=/04-webDL/regist.html");
		}
	}
}
