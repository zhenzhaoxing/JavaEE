package cn.starsw.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();
     static {
    	 try {
			InputStream stream = Resources.getResourceAsStream("MyXml.xml");
			factory= new SqlSessionFactoryBuilder().build(stream);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
     /*
      * 获取Sqlsession的方法
      * */
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
