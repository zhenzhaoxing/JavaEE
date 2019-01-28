package com.star.test;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class ListDemo {

	public static void main(String[] args) {
		  Jedis cd = new Jedis("192.168.175.3", 6379); 
		  
		  //cd.lpush("list1", "v1","v2","v3","v4");
		    List<String> list = cd.lrange("list1",0, -1);
		    //System.out.println(list);
		    
		    // String 类型
		    //Long append = cd.append("k1", "我爱你");
		    
		     System.out.println(cd.get("k1"));
		    // cd.mset("str1","学生1","Str2","学生二");
		     System.out.println(cd.mget("str1","Str2"));
		     
		     //zset
		     cd.zadd("zset01",60d,"v1");
		     cd.zadd("zset01",70d,"v2");
		     cd.zadd("zset01",80d,"v3");
		     cd.zadd("zset01",50d,"v4");
		     Set<String> zrange = cd.zrange("zset01", 0, -1);
	  System.out.println(" "+zrange);
	  
	}

}
