package cn.starsw.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//工具类
public class MyBatisUti {
	//factory实例化的过程是一个比较耗费性能的过程.
		//保证有且只有一个factory
	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();
	static{
	try {
		InputStream is = Resources.getResourceAsStream("MyXml.xml");
		factory=new SqlSessionFactoryBuilder().build(is);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	}
	
	public static SqlSession getSession(){
		SqlSession session = tl.get();
		if(session==null){
			tl.set(factory.openSession());
		}
		
		return tl.get();
		
	}
	public static void closeSession(){
		SqlSession session = tl.get();
		if(session!=null){
			session.close();
		}
		tl.set(null);
	}
	
}
