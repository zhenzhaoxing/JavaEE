package cn.starsw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.starsw.pojo.User;

public interface StudentMapper {
	@Select("select *from user where username=#{username} and password=#{password}")
	User selByUsersPwd(User user);
}
