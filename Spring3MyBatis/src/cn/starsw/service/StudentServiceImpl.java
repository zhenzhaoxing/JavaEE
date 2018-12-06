package cn.starsw.service;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import cn.starsw.mapper.StudentMapper;
import cn.starsw.pojo.Student;
@Service
public class StudentServiceImpl {
   @Resource
	private StudentMapper studentMappr;

	//@Resource 省区写setget方法了 java中的方法
   

	

	public List<Student> show() {
    return studentMappr.selAll();
	}
}
