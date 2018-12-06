package cn.starsw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.starsw.service.StudentServiceImpl;

public class StudentServlet extends HttpServlet {
	private StudentServiceImpl serviceIm;

	@Override
	public void init() throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		ac.getBean("studentService", StudentServiceImpl.class);

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", serviceIm.show());
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		;
	}
}
