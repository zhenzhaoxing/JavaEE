package com.star.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.star.mapper.MenuMapper;
import com.star.mapper.UserMapper;
import com.star.pojo.Menu;
import com.star.pojo.Users;
@Service
public class MeanService {

	
	@Resource
	private MenuMapper menuMapper;  
  

	@Resource
	private UserMapper usermapper;
	
	public Users login(Users users) {
		return usermapper.selByUsers(users);
	}
	
	

}
