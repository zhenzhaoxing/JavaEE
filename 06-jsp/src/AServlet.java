import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AServlet extends HttpServlet {

	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse reps) throws ServletException, IOException {
req.setCharacterEncoding("utf-8");
String parameter = req.getParameter("username");
HttpSession session = req.getSession();
session.setAttribute("zhen", parameter);

	System.out.println(parameter);
   req.getRequestDispatcher("/hao.jsp").forward(req, reps);	
	}
	
	
}
