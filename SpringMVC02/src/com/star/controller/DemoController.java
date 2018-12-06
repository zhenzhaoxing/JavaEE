package com.star.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.star.pojo.User;

@Controller
public class DemoController {
	// 这个注解指出 前端调用的参数
	@RequestMapping("demo")
	public String demo(User u, HttpServletRequest req) {
		System.out.println("执行器" + u);
		req.setAttribute("demo12", "zekegdrfbgf");
		return "main.jsp";
	}

	// 如果请求参数名和方法参数名不对应使用@RequestParam()赋值
	@RequestMapping("demo1")
	public String demo1(@RequestParam(value = "name") String username, String passwords) {
		System.out.println("第二执行器" + username + passwords);
		return "main1.jsp";
	}
	/*
	 * 如果方法参数是基本数据类型(不是封装类)可以通过
	 * 
	 * @RequestParam 设置默认值.
	 */

	@RequestMapping("demo2")
	public String demo3(@RequestParam(defaultValue = "2") int pageSize,
			@RequestParam(defaultValue = "1") int pageNumber) {

		System.out.println(pageSize + "" + pageNumber);
		return "main.jsp";
	}

	// 强制要求必须有某个参数
	@RequestMapping("demo3")
	public String demo4(@RequestParam(required = true) String name) {

		System.out.println("name" + name);
		return "index.jsp";
	}

	// 格式要和 请求的一致
	@RequestMapping("demo4/{name}/{id1}")
	public String demo4(@PathVariable String name, @PathVariable("id1") int age) {
		System.out.println(name + " " + age);
		return "index.jsp";
	}

	@RequestMapping("demo4")
	public String demo5(@RequestParam("hover") ArrayList<String> list) {
		System.out.println("name" + list);
		return "index.jsp";
	}

	@RequestMapping("demo6")
	@ResponseBody
	public User demo6() {
		User u = new User();
		u.setUsername("张杰");
		u.setPasswords("110117843");
		return u;
	}
	@RequestMapping(value="demo7",produces="text/html;charset=utf-8")
	@ResponseBody
	public String demo7() {
		User u = new User();
		u.setUsername("张杰");
		u.setPasswords("110117843");
		return "如果是字符串";
	}
	
	
}
