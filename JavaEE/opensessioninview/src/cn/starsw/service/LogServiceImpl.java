package cn.starsw.service;

import org.apache.ibatis.session.SqlSession;

import cn.starsw.mapper.UserMapperl;
import cn.starsw.pojo.Log;
import cn.starsw.util.MyBatisUti;

public class LogServiceImpl {
 public int ins(Log log){
	 SqlSession session = MyBatisUti.getSession();//就有一个Session
	 UserMapperl mapper = session.getMapper(UserMapperl.class);
	 
	 return mapper.ins(log);
 }
}
