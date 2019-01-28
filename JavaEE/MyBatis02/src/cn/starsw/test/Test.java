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
		int pageSize=2;
		int pageNumber=1;
		Map<String,Object> map= new TreeMap<String,Object>();
		map.put("pageSize", pageSize);
		map.put("pageStart",pageSize*(pageNumber-1) );
		List<Student> s= session.selectList("a.b.seletcAll",map);
		System.out.println(s);
		
		//增加内容
		
		Student p = new Student();
		p.setName("梁红玉");
		p.setAge(19);	
		
		
         try {
			int index=session.insert("a.b.inse",p);
			if(index>0){
				System.out.println("成功");
			}
			else{
				System.out.println("失败");
			}
		} catch (Exception e) {
			
			//e.printStackTrace(); 回滚
			session.rollback();
		}
		
		
		
		session.commit();
	
	
		
		
		
		/*
		//更改内容
		Student p1 = new Student();
		p1.setId(11);
		p1.setName("杨再兴");
		int index1 = session.update("a.b.up", p1);
		if(index1>0){
			System.out.println("成功");
		}
		else{
			System.out.println("失败");
		}
		session.commit();
	
*/
	
	   //删除内容
	/*
		int index2 = session.delete("a.b.del", 2);
		if(index2>0){
			System.out.println("成功");
	}else{
			System.out.println("失败");
		}
		session.commit();
		session.close();
		System.out.println("程序执行结束");
		*/
	}
	
	
	
	
	
}
