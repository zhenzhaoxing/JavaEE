package com.bjsxt.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.service.PicService;

@Controller
public class PicControllers {
	@Resource
	private PicService picServiceImpl;
	@RequestMapping("/")
	public String welcome(Model model){
		System.out.println("执行:"+picServiceImpl.show());
		model.addAttribute("list", picServiceImpl.show());
		return "/index.jsp";
	}
}
