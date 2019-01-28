package cn.starsw.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.starsw.pojo.PageInfo;

public class Test {

	public static void main(String[] args) throws IOException {
		
		
		InputStream is = Resources.getResourceAsStream("MyXml.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		int pageNumber=2;
		int pageSize=2;
		PageInfo pi = new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map =new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		pi.setList(session.selectList("a.b.seletcAll",map));
		
		//总条数
		long count = session.selectOne("a.b.selCount");
		
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		
		System.out.println(pi.getList());

	}

}
