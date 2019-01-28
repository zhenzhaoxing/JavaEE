package com.test;

import java.util.ArrayList;
import java.util.List;

import com.pojo.Users;

public class dmeo {
public static void main(String[] args) {
	Users u = new Users();
		u.setId(1);
		u.setUsername("甄兆星");
		u.setPassword("123456");
		Users u1 = new Users();
		u1.setId(2);
		u1.setUsername("赵辉");
		u1.setPassword("454");
		List<Users> list = new ArrayList<>() ;
		list.add(u);
		list.add(u1);
		
			System.out.println(list);
	
}
}
