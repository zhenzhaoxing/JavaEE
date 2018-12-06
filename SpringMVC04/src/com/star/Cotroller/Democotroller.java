package com.star.Cotroller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Democotroller {
	@RequestMapping("download")
	public void download(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException {
		// 设置响应头 以下载形式 attachment
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		ServletOutputStream stream = response.getOutputStream();
		String path = request.getServletContext().getRealPath("files");
		File file = new File(path, fileName);

		  //调用工具类把文件  读成字节
		byte[] bs = FileUtils.readFileToByteArray(file);
		stream.write(bs);
		stream.flush();
		stream.close();
	}
	
	
	
	/*dfds
	 * 
	 *   文件上传的功能
	 * 
	 * */
	@RequestMapping("upload")
	public String upload(MultipartFile file,String name,HttpServletRequest request) throws IOException {
		//MultipartFile 用来解析 请求
		//获取文件名
		String filename = file.getOriginalFilename();
		//处理重名问题
		  
		String huffix = filename.substring(filename.lastIndexOf("."));
		//判断是否为 我所要求的文件后缀
		if(huffix.equalsIgnoreCase(".jpg")) {
			
			String string = UUID.randomUUID().toString();
			 //保存
			FileUtils.copyInputStreamToFile(file.getInputStream(),new File("E:/"+string+huffix) );
			return "index.jsp";
		}else
		{
			request.setAttribute("reques", "文件类型不对");
		return "/error.jsp";
	
		}
		
	}
	
}
