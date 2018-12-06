package com.star.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor {

	

	//进入控制器之前执行
     //返回值为false，就阻止进入控制器
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
  System.out.println("我在你进去控制器前执行");
		  
		return true;
	}
	//控制器执行完成，进入到jsp之前执行
	//日志记录
	//敏感词语过滤
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
arg3.getViewName();
		System.out.println("控制器执行完了 ，我是在进入 jsp之前执行的");
		
		String string = arg3.getModel().get("model").toString();
	      String newword = string.replaceAll("爱", "*");
             arg3.getModel().put("model", newword);	     
	}
	/*jsp完成后后执行
	 * 记录执行过程中出现的异常
	 * 可以吧异常记录到日志中
	 * 
	 * */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
System.out.println("jsp执行完了 然后我执行");
	}
}
