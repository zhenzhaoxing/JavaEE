package com.star.mapper;

import org.apache.ibatis.annotations.Insert;

import com.star.pojo.Users;



public interface UsersMapper {

	
//添加数据
	@Insert("insert into user values (5,#{username},#{password},#{photo})")
	int insUser(Users user);
	
	
	
}
