package cn.starsw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.starsw.pojo.PageInfo;
import cn.starsw.service.StudentService;

public class ShowServlet1 extends HttpServlet {
	private StudentService studentservice = new StudentService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sname = req.getParameter("sname");
		if (sname != null && !sname.equals(""))
			sname = new String(sname.getBytes("iso-8859-1"), "utf-8");
		String tname = req.getParameter("tname");
		System.out.println(tname);
		if (tname != null && !tname.equals(""))
			tname = new String(tname.getBytes("iso-8859-1"), "utf-8");
		String pageSize = req.getParameter("pageSize");
		String pageNumber = req.getParameter("pageNumber");// 当前页
		PageInfo pi = studentservice.showPage(sname, tname, pageSize, pageNumber);
		req.setAttribute("pageinfo", pi);
		//System.out.println(pi.getList());
		req.getRequestDispatcher("index.jsp").forward(req, resp);

	}
}
