package com.star.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.star.pojo.Files;

public interface FileMapper {

   @Select("select*from file")	
	List<Files> selAll();
	
   @Update("updata file set count=count+1 where id=#{0}")
   int upd(int id);
   
}
