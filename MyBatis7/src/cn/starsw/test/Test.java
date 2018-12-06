package cn.starsw.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.jms.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



import cn.starsw.pojo.Student;

public class Test {
	public static void main(String[] args) throws IOException {
		
		InputStream is = Resources.getResourceAsStream("MyXml.xml");
		//使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//生产SqlSession
		SqlSession session=factory.openSession();
		List<Student> list = session.selectList("a.b.selAll");
		
		System.out.println(list);
	
	}
	
	
	
	
	
}
