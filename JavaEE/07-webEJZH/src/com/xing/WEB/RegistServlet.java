package com.xing.WEB;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.xing.domain.Stu;
import com.xing.util.JdbcUtil;


public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
   
		if(code.equals(word)){
			Map<String, String[]> parameterMap = request.getParameterMap ();
		Stu u = new Stu();
		try {
			BeanUtils.populate(u, parameterMap);
		} catch (IllegalAccessException e) {
			
		} catch (InvocationTargetException e) {	
		}
		
		
		u.setId(UUID.randomUUID().toString());
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "insert into student values(?,?,?,?)";
		try {
			qr.update(sql, u.getId(),u.getUsername(),u.getPassword(),u.getPhone());
		} catch (SQLException e) {
		}
		response.getWriter().write("注册成功");
		//跳转到登录
		response.setHeader("refresh", "3;url=/07-webEJZH/login.jsp");
		}else{
			response.getWriter().write("验证码错误");
			response.setHeader("refresh", "3;url=/07-webEJZH/regist.jsp");
		}
		}
		
		
		
		
		
	}
       


	

