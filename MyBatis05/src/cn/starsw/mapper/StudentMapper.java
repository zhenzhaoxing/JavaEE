package cn.starsw.mapper;

import java.util.List;

import cn.starsw.pojo.PageInfo;
import cn.starsw.pojo.Student;

public interface StudentMapper {
 List<Student> selByPage(PageInfo pi);
 
 long  selCountByPageInfo(PageInfo pi);
}
