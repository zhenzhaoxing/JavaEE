package com.xing.Resquest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ser
 */
public class Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Override
    protected void service(HttpServletRequest request, HttpServletResponse res)
    		throws ServletException, IOException {
    	request.getRequestDispatcher("/ServletDEMO").forward(request, res);
    	
    }
    //请求转发 地址蓝不变


}
