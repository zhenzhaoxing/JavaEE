package com.star.test;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	           Demo demo = ac.getBean("demo1245",Demo.class);
	
	demo.demo();
	}
}
