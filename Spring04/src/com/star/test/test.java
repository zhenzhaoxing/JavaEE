package com.star.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
public static void main(String[] args) {
	ApplicationContext ac = new ClassPathXmlApplicationContext("MyXml.xml");
	 Demo demo = ac.getBean("demo",Demo.class);
	 demo.demo("10");
}
}
