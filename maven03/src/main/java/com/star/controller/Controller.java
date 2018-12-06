package com.star.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

import com.star.service.UsersService;

@org.springframework.stereotype.Controller
public class Controller {

	
	@Resource
	private UsersService usersService;
	@RequestMapping("demo")
	public String dmeo(HttpServletRequest request) {
		request.setAttribute("list", usersService.show());
		
		/*System.out.println(usersService.show());*/
	return "/index.jsp";
	}
	    
}
