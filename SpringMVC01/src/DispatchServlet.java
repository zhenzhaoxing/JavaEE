import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatchServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("这是执行控制器");
		
		
		
		
		String parameter = req.getParameter("dispat");
		
		if(parameter.equals("demo1")) {
			demo1();
		}
		
		if(parameter.equals("demo2")) {
			demo2();
		}
		if(parameter.equals("demo3")) {
			demo3();
		}
		if(parameter.equals("demo4")) {
			demo4();
		}
	}
	
	public void demo1() {
		System.out.println("调用方法1");
	}
	
	public void demo2() {
		System.out.println("调用方法2");
	}
	public void demo3() {
		System.out.println("调用方法3");
	}
	public void demo4() {
		System.out.println("调用方法4");
	}
	
	
	
}
