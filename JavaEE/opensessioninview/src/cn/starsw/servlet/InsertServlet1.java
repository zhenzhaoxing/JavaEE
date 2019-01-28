package cn.starsw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.starsw.pojo.Log;
import cn.starsw.service.LogServiceImpl;

public class InsertServlet1 extends HttpServlet {
	private LogServiceImpl logservice = new LogServiceImpl();
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		 Log log =new Log();
	
		 log.setAccOut(req.getParameter("accout"));
		 log.setMoney(Double.parseDouble(req.getParameter("money")));
		 int i = logservice.ins(log);
		 if(i>0){
			 resp.sendRedirect("success.jsp");
		 }
		 else{
			 resp.sendRedirect("error.jsp");
		 }
		}
	}
