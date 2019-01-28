package cn.starsw.servlet;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.starsw.poho.Student;
import cn.starsw.service.StudentService;

public class showServlet extends HttpServlet {

//页务层	
	private StudentService stu = new StudentService();
	
	
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<Student>  list= stu.show();			
	req.setAttribute("list", list);
    req.getRequestDispatcher("/index.jsp").forward(req, resp);
	
	}
}