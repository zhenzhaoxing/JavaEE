package cn.starsw.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.starsw.pojo.Student;
import cn.starsw.pojo.StudentFactory;

public class test {

	public static void main(String[] args) {
		// 配置文件一加载 类就会被创建
		// ApplicationContext 是一个全局容器
		ApplicationContext c = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Student student = c.getBean("stu2", Student.class);
		System.out.println(student);//Student [id=11000, name=甄兆星]
		/*
		 * StudentFactory factory = new StudentFactory(); Student student2 =
		 * factory.newInstance(); System.out.println(student2); Student
		 * [id=11000, name=甄兆星]
		 */
	}
}
