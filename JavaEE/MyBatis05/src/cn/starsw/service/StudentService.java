package cn.starsw.service;

import java.util.List;

import javax.jms.Session;

import org.apache.ibatis.session.SqlSession;

import cn.starsw.mapper.StudentMapper;
import cn.starsw.mapper.TeacherMapper;
import cn.starsw.pojo.PageInfo;
import cn.starsw.pojo.Student;
import cn.starsw.util.MyBatisUti;

public class StudentService {
public PageInfo showPage(String sname,String tname,String pageSizeStr,String pageNumberStr){
	 int pageSize=2;//每页显示的数据 默认让为2
	 if(pageSizeStr!=null&&pageSizeStr.equals("")){
		 pageSize=Integer.parseInt(pageSizeStr);
	 }
	int pageNumber=1;//当前页
	if(pageNumberStr!=null&&pageNumberStr.equals("")){
		pageNumber = Integer.parseInt(pageNumberStr);
	}
	SqlSession sqlSession = MyBatisUti.getSession();
	StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
	PageInfo pi = new PageInfo();
	pi.setPageNumber(pageNumber);
	pi.setPageSize(pageSize);
	pi.setSname(sname);
	pi.setTname(tname);
	pi.setPageStart((pageNumber-1)*pageSize);
	List<Student> list = studentMapper.selByPage(pi);

	//查询出每个学生对应的老师信息
	TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
	for(Student lis:list){
		lis.setTeacher(teacherMapper.selById(lis.getTid()));
	}
	pi.setList(list);//获取的数据在这里
	long count = studentMapper.selCountByPageInfo(pi);
	pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
	
	
	
	
	return pi;
}
}
