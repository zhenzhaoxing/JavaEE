package com.star.service;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.star.mapper.UsersMapper;
import com.star.pojo.Users;

@Service
public class UsersService {

	
	@Resource
	private UsersMapper usersMapper;  
  
public int insRegister(Users user) {
	return usersMapper.insUser(user);
}
	
	
	
	
	
}
