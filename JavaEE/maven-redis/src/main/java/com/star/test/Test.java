package com.star.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Test {

	public static void main(String[] args) {
   
		
		  Jedis cd = new Jedis("192.168.175.3", 6379);
	      System.out.println(cd.ping());	 
	      cd.hset("user", "username", "zhen兆");
	      cd.hset("user", "password", "741");
	      Map<String ,String> map = new HashMap<String, String>();
	      map.put("telphone","13811814763");
	      map.put("address","atguigu");
	      map.put("email","abc@163.com");
	      cd.hmset("student", map);
	                 
	      List<String> list = cd.hmget("student","telphone","address","email");
	      System.out.println(list);
	      System.out.println(cd.hgetAll("student"));
	      //System.out.println(cd.hgetAll("user"));
	       //获取所有值
	      Set<String> keys = cd.keys("*");
	      for (String string : keys) {
			 System.out.println(string);
		}
	      
	      
	      
	}

}
