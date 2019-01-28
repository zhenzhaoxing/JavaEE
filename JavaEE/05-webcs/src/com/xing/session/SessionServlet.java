package com.xing.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	/**
		 获得专属于当前会话的Session对象
		如果服务器端没有该会话的Session对象，会创建一个新的Session返回
		如果已经有了属于该会话的Session直接将已有的Session返回
		本质就是根据SESSIONID判断该客户端是否在服务器上已经存在session了
		
		域 对象    
		 * */
    	
    	HttpSession session = req.getSession();
    	session.setAttribute("zhen", 521521);
    	
    System.out.println(session.getAttribute("zhen"));}

}
