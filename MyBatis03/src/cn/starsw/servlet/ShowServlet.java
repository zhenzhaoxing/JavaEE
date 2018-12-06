package cn.starsw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.starsw.pojo.PageInfo;
import cn.starsw.service.StudentService;

public class ShowServlet extends HttpServlet {
	 private StudentService peopleService= new StudentService();
	 @Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//第一次访问的验证,如果没有传递参数,设置默认值
			String pageSizeStr = req.getParameter("pageSize");
			int pageSize = 2;
			if(pageSizeStr!=null&&!pageSizeStr.equals("")){
				pageSize = Integer.parseInt(pageSizeStr);
			}
			String pageNumberStr = req.getParameter("pageNumber");
	
			int pageNumber = 1;
			if(pageNumberStr!=null&&!pageNumberStr.equals("")){
				pageNumber = Integer.parseInt(pageNumberStr);
			}
			PageInfo pi = peopleService.showPage(pageSize, pageNumber);
			req.setAttribute("PageInfo", pi);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
