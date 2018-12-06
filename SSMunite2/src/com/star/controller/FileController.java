package com.star.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.service.FileService;

@Controller
public class FileController {

	@Resource
	private FileService fileService;

	@RequestMapping("show")
	public String sho(Model model) {
		model.addAttribute("list", fileService.show());
		return "/register.jsp";
	}

	@RequestMapping("download")
	public void download(int id, String name, HttpServletResponse res, HttpServletRequest resp) throws IOException {
	        fileService.upd(id);
		res.setHeader("Content-Disposition", "attachment;filename=" + name);
		ServletOutputStream os = res.getOutputStream();
		File file = new File(resp.getServletContext().getRealPath("files"), name);
		os.write(FileUtils.readFileToByteArray(file));
		os.flush();
		os.close();
	}

}
