package com.star.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.pojo.Users;
import com.star.service.MeanService;

@Controller
public class UserController {
  @Resource
  
     private MeanService meanservice;
  
  @RequestMapping("login")
  public String login(Users users,HttpSession session) {
	  
	  Users users2 = meanservice.login(users);
	  
	  if(users2!=null) {
		  session.setAttribute("user", users2);
			return "redirect:/main.jsp";
	  }else {
		  return "redirect:/index.jsp";
	  }
	  
	  
	
  }
  
}
