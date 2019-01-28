package com.star.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

public class TransactionDemo {
	public static void main(String[] args) {
		Jedis cd = new Jedis("192.168.175.3", 6379);
                       
		     
		Transaction transzction = cd.multi();
		transzction.set("serNum", "80");

		Response<String> response = transzction.get("serNum");
        
		if (1>2) {
			transzction.exec();
		} else {
    transzction.discard();
		}
		System.out.println(response.get());
	}
}
