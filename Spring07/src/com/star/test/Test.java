package com.star.test;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.star.pojo.People;


public class Test {

	public static void main(String[] args) {
		
		
		
		ApplicationContext ac = new  ClassPathXmlApplicationContext("ApplicationContext.xml");
		People people = ac.getBean("people",People.class);
				
           System.out.println(people);
	}
   
}
