package com.star.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.pojo.User;

@Controller
public class controller {

	
	@RequestMapping("{page}")
	public String main(@PathVariable String page) {
		System.out.println("niubi");
		return page;
	}
	
	
	
	
	   @RequestMapping("login")
	   public String login(User user ,HttpSession session) {
		
		   if(user.getName().equals("admin")&&user.getId().equals("123")){
				session.setAttribute("user", user);
				return "main";
			}else{
				return "redirect:/login.jsp";
			}
	   }
	
	
}
