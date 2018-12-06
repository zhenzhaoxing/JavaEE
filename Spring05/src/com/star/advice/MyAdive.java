package com.star.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect   //表示该类是一个通知切面类
public class MyAdive {
    
	  @Before("com.star.test.Demo.demo()")
	public void mybefore() {
		System.out.println("前置");
	}
	@After("com.star.test.Demo.demo()")
	public void myafter() {
		System.out.println("后置");
	}
	@AfterThrowing("com.star.test.Demo.demo()")
	public void mythrow() {
		System.out.println("异常");
	}
	public void myarround() {
		System.out.println("环绕通知");
	}
	
}
