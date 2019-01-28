package com.bjsxt.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.pojo.Pic;
import com.bjsxt.service.PicService;


@Controller
public class PicController {
	@Resource
	private PicService picServiceImpl;
	@RequestMapping("insert")
	public String insert(MultipartFile file,HttpServletRequest req){
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(req.getServletContext().getRealPath("files"),file.getOriginalFilename()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Pic pic = new Pic();
		pic.setPath(file.getOriginalFilename());
		int index = picServiceImpl.insPic(pic);
		if(index>0){
			return "redirect:/show";
		}else{
			return "/add.jsp";
		}
	}
	@RequestMapping("show")
	public String show(Model model){
		model.addAttribute("list", picServiceImpl.show());
		return "/main.jsp";
	}
	@RequestMapping("delete")
	public String delete(int id){
		int index = picServiceImpl.delById(id);
		return "redirect:/show";
	}
}
