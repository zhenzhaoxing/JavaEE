package cn.starsw.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.starsw.mapper.StudentMapper;
import cn.starsw.pojo.User;
import cn.starsw.service.StudentServiceImpl;


public class test {

	public static void main(String[] args) {
		// 配置文件一加载 类就会被创建
		// ApplicationContext 是一个全局容器
		ApplicationContext c = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		 StudentServiceImpl serviceImpl = c.getBean("studentService", StudentServiceImpl.class);

		
	}
}


