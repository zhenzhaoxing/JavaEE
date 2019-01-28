package cn.starsw.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.jms.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import cn.starsw.mapper.UserMapperl;
import cn.starsw.pojo.Log;
import cn.starsw.pojo.Student;

public class Test {
	public static void main(String[] args) throws IOException {

		InputStream is = Resources.getResourceAsStream("MyXml.xml");
		// 使用工厂设计模式
	   SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		// 生产SqlSession
	SqlSession session = factory.openSession();

		// UserMapper1是个接口
		UserMapperl mapper = session.getMapper(UserMapperl.class);
		        
		
		/*
		 * List<Student> all = mapper.seletcAll(); for(Student li:all){
		 * System.out.println(li); }
		 */
		/*测试if标签 和where
		List<Student> accout = mapper.selByAccInAccout("1", "3");
		System.out.println(accout);
            */
		
		Log log = new Log();
		log.setId(7);
		log.setAccIn("1");
		log.setAccOut("3");
		int upd = mapper.upd(log);
		/*bind
		log.setAccOut("不");
		List<Log> list = mapper.selByLog(log);
		System.out.println(list);
		*/
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		List<Log> in = mapper.selIn(list);
		System.out.println(in);
		session.commit();
	}
}
