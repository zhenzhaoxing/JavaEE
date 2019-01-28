package cn.starsw.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



import cn.starsw.poho.Student;

public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("MyXml.xml");
		//使用工厂设计模式  SqlSessionFactoryBuilder().build(is);  是SqlSessionFactory 的实现类DefaultSqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//生产SqlSession
		SqlSession session=factory.openSession();
//		
//		List<Student> list = session.selectList("a.b.seletcAll");
//		for (Student flower : list) {
//			System.out.println(flower.toString());
//		}
		//如果希望传递多个参数，可以使用对象或则map
		/*Map<String,Object> map= new TreeMap<String,Object>();
		map.put("id", 1);
		map.put("name", "张飞");
		List<Object> a = session.selectList("a.b.seletcAll");*/
		Student stu = new Student();
		stu.setId(1);
		Student s= session.selectOne("a.b.seletcAll",1);
		
		System.out.println(s);
		
		session.close();
	}
}
