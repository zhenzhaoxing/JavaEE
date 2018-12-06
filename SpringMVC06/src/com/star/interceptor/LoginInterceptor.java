package com.star.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//判断
		 String uri = request.getRequestURI();
		 if(uri.equals("/SpringMVC06/login.jxp")) {
			 return true;
		 }else {
			Object object = request.getSession().getAttribute("user");
			 if(object!=null) {
				 return true;
			 }
			 request.setAttribute("error", "请登录");
			 response.sendRedirect("/SpringMVC06/login.jxp");
			 return false;
		 }
		
	}

}
