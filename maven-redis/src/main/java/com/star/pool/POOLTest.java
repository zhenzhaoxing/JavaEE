package com.star.pool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class POOLTest {

	public static void main(String[] args) {
            JedisPool jedispool = JedisPoolUtil.getInstall();
           Jedis jedis=null;
           
          try {
        	   jedis = jedispool.getResource();
 			  System.out.println(jedis.ping());
			  jedis.set("key20", "values");
		} catch (Exception e) {
			System.out.println("s");
		}
          finally {
			JedisPoolUtil.colsePool(jedispool, jedis);
		}
	}

}
