package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Users;

public class ShowServlet extends HttpServlet {
	   @Override
	   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   	 
	   	   
	   	   
	   	   String string = req.getParameter("name");

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
	   	/*	System.out.println();
	   		[Users [id=1, username=甄兆星, password=123456], Users [id=2, username=赵辉, password=454]]*/
	   		/* 这两句是把对象转换成json格式 json有对象格式 还有数组格式 用到了三个包 */
	   		ObjectMapper mapper = new ObjectMapper();
	   		String result = mapper.writeValueAsString(list);
	          /* System.out.println(result);
	           [{"id":1,"username":"甄兆星","password":"123456"},{"id":2,"username":"赵辉","password":"454"}]*/
	   		resp.setContentType("application/json;charset=utf-8");
	   		PrintWriter printWriter = resp.getWriter();
	   		printWriter.println(result);
	   		printWriter.flush();
	   	}
	   }
