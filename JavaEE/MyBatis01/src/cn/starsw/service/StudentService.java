package cn.starsw.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.starsw.poho.Student;

public class StudentService {

	
	
	public List<Student> show() throws IOException{
		InputStream is = Resources.getResourceAsStream("MyXml.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		List<Student> list=session.selectList("a.b.selAll");
		session.close();
		return list;
		
	}
}
