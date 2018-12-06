package com.star.test;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
//下面配置的component 相当于applicationContext.xml中的bean
@Component("demo1245")
public class Demo {

	
	@Pointcut("execution(* com.star.test.Demo.demo())")
	public void demo() {
		
		int x=5/0;
		System.out.println("参数");
	}
}
