package com.star.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.registry.infomodel.User;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.star.pojo.Users;
import com.star.service.UsersService;

@Controller
public class UsersController {
       
	@Resource
	private UsersService usersService;
	     
	@RequestMapping("register")
	public String register(Users user,MultipartFile file,HttpServletRequest req) {
		
		//取名 获取明等
		
		String filename = UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		  String path = req.getServletContext().getRealPath("images")+"/"+filename;
		/*  文件方法 tomcat目录下了*/
		  try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  user.setPhoto(filename);
		int index = usersService.insRegister(user);
		if(index>0) {
			
			req.setAttribute("succes", "注册ok");
			return "redirect:/show";
		}else {
		return "redirect:/index.jsp";
		}
	}
	
}
