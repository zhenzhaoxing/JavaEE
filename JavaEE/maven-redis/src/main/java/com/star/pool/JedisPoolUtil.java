package com.star.pool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {

	private static volatile JedisPool jedisPool = null;

	private JedisPoolUtil() {
	}

	public static JedisPool getInstall() {
		if (jedisPool == null) {
			//加锁判断
			 synchronized (JedisPoolUtil.class) {
				 if (jedisPool == null) {
					 JedisPoolConfig je = new JedisPoolConfig();
				      	 je.setMaxTotal(1000);
						je.setMaxIdle(32);
						je.setMaxWaitMillis(100 * 1000);
						je.setTestOnBorrow(true);
						jedisPool = new JedisPool(je, "192.168.75.3",6379);
					
				 }
			}
			

		}

		return jedisPool;

	}

	
	public static void colsePool(JedisPool jedispool,Jedis jedis) {
		
		
		if(jedis!=null)
		{
			    jedispool.returnResourceObject(jedis);
		}
		
		
	}
	
	
	
	
	
	
	
}
