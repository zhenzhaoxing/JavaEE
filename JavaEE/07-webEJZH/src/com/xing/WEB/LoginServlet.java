package com.xing.WEB;

import java.io.IOException;
import java.sql.SQLException;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.xing.domain.Stu;
import com.xing.util.JdbcUtil;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名， 密码
		String name = request.getParameter("username");
		
		HttpSession session2 = request.getSession();
		session2.setAttribute("name", name);
		String pwd = request.getParameter("password");
		//解决乱码
		byte[] bytes = name.getBytes("ISO8859-1");
		String str = new String(bytes,"UTF-8");
		System.out.println(str+pwd);
		//到数据库当中查询有没有该用户
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from student where username=? and password=?";
		Stu u = null;
		try {
			u = qr.query(sql, new BeanHandler<Stu>(Stu.class),str,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		//1.有值
		if(u != null) {
			response.getWriter().write("登录成功");
			//把用户保存
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			//跳转到登录
			response.setHeader("refresh", "3;url=/07-webEJZH/index.jsp");
		}else {
			response.getWriter().write("登录失败");
			//跳转到登录
			response.setHeader("refresh", "3;url=/07-webEJZH/login.jsp");
		}
		
	}

}
