package com.star.mapper;

import org.apache.ibatis.annotations.Select;

import com.star.pojo.Users;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
public interface UserMapper {

	
	

	@Results(value={
			@Result(id=true,column="id",property="id"),
			@Result(column="username",property="username"),
			@Result(column="password",property="password"),
			@Result(property="menus",many=@Many(select="com.bjsxt.mapper.MenuMapper.selByPid"),column="{uid=id,pid=pid}")
			})
	
	
	@Select("select*,0.pid from users where username=#{username} and password=#{password}")
	  Users selByUsers(Users users);
}
