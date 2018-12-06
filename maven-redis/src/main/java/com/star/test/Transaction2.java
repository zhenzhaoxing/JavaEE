package com.star.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class Transaction2 {
	
	public boolean reand() throws InterruptedException {
		Jedis cd = new Jedis("192.168.175.3", 6379); 

		  int balance=0;
		  int debt;
		int amtTosubtract=10;

		 cd.watch("balance"); 
		     //假如在其他线程改了后
		Thread.sleep(8000);
		int int1 = Integer.parseInt(cd.get("balance"));
		
		if(int1<amtTosubtract) {
			cd.unwatch();
			System.out.println("不可以");
			return false;
		}else {
			Transaction transaction = cd.multi();
			transaction.decrBy("balance",amtTosubtract);
			transaction.incrBy("debt", amtTosubtract);
			   transaction.exec();
			       balance =Integer.parseInt(cd.get("balance"));
                   debt= Integer.parseInt(cd.get("debt"));
		            System.out.println("************"+balance);
		           System.out.println("*************"+debt);
		           return true;
		}
		
		
		
	}
	
	
	
  



public static void main(String[] args) throws InterruptedException {
	
	       Transaction2 t = new Transaction2();
	       boolean reand = t.reand();
	       System.out.println(reand);
}
}
