package com.star.pojo;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
@Controller
public class People {
	
	@Resource
	private Student student;

	@Override
	public String toString() {
		return "People [student=" + student + "]";
	}

	
}
