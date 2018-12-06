package com.star.Controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@RequestMapping("demo")
	public String demo(HttpServletRequest req,HttpSession sessionparem) {
		req.setAttribute("re", "这是 request的值");

		HttpSession session = req.getSession();
		session.setAttribute("nu", "这是session的值");
		sessionparem.setAttribute("session", "这也是session的值");
		ServletContext context = req.getServletContext();
		context.setAttribute("application", "这是 application的参数");
		return "/index.jsp";
	}

	
	
	
	
	
	@RequestMapping("demo1")
	public String demo1(Map<String, String> map) {
		map.put("map", "map的值");
		return "/index.jsp";
	}
	
	
	
}
