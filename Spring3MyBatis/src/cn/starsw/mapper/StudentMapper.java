package cn.starsw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.starsw.pojo.Student;

public interface StudentMapper {
    @Select("select *from student")
	List<Student> selAll();
}
