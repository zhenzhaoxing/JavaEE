package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Pic;





public interface PicMapper {
   
	int insPic(Pic pic);
	@Select("select *from file")
	List<Pic> selAll();
	@Delete("delete from file where id=#{0}")
	int delByid(int id);
	
}
