package cn.starsw.service;

import java.util.List;

import cn.starsw.mapper.StudentMapper;
import cn.starsw.pojo.User;

public class StudentServiceImpl {

	private StudentMapper studentmappr;

	public StudentMapper getStudentmapper() {
		return studentmappr;
	}

	public void setStudentmappr(StudentMapper studentmappr) {
		this.studentmappr = studentmappr;
	
	
	}

	public List<User> show() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
