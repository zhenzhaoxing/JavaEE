package com.star.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.star.mapper.UserMapper;
import com.star.pojo.Users;

@Service
public class UsersService {

	
	@Resource
	private   UserMapper userMapper;
	
	
	public List<Users> show(){
		return userMapper.show1();
	}
	
	
	
	
}
