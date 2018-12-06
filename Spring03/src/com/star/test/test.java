package com.star.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
	//加载配置文件
		ApplicationContext  ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	              Demo bean = ac.getBean("demo",Demo.class);
	try {
		bean.demo();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	}

}
