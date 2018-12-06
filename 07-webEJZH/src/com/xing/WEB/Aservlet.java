package com.xing.WEB;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Aservlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     String parameter = req.getParameter("username");
	    HttpSession session = req.getSession();
	    session.setAttribute("name", parameter);
    	req.getRequestDispatcher("/GoodsServlet").forward(req, resp);
	
	
	
	
	
	
}
}
