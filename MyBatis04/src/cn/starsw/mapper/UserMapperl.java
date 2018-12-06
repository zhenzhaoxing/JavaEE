package cn.starsw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.starsw.pojo.Log;
import cn.starsw.pojo.Student;

public interface UserMapperl {
	List<Student> seletcAll();

	List<Student> selByAccInAccout(@Param("accin") String accIn, @Param("accOut") String accOut);

	int upd(Log log);

	List<Log> selByLog(Log log);

	List<Log> selIn(List<Integer> list);

	int ins(List<Integer> list);

}
