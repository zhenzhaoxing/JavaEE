package com.star.test;

import redis.clients.jedis.Jedis;

public class MasSla {
	public static void main(String[] args) throws InterruptedException {
		
	
	Jedis ma = new Jedis("192.168.175.3", 6379);
	Jedis sl = new Jedis("192.168.175.3", 6380);
   sl.slaveof("192.168.175.3",6379); 
     ma.set("key10", "7897");
   Thread.sleep(5000);
            
             System.out.println( sl.get("key10"));
	}

   
}
