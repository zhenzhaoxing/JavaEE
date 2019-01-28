package com.xing.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
@SuppressWarnings("all")
public class UPloadServlet1 extends HttpServlet {
/*
	 上传对Servlet限制
	  * request.getParametere("xxx");这个方法在表单为enctype="multipart/form-data"时，它作废了。它永远都返回null
  * ServletInputStream request.getInputStream();包含整个请求的体！
*/
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
 * 1. 上传三步
  相关类：
  * 工厂：DiskFileItemFactory
  * 解析器：ServletFileUpload
  * 表单项：FileItem

  1). 创建工厂：DiskFileItemFactory factory = new DiskFileItemFactory();
  2). 创建解析器：ServletFileUpload sfu = new ServletFileUpload(factory);
  3). 使用解析器来解析request，得到FileItem集合：List<FileItem> fileItemList = sfu.parseRequest(request);
 * 
 * */
		request.setCharacterEncoding("utf-8");
	
		response.setContentType("text/html;charset=utf-8");
		
		DiskFileItemFactory disk =  new DiskFileItemFactory();
		
		ServletFileUpload fileUpload = new ServletFileUpload(disk);
		try {
			List<FileItem> list = fileUpload.parseRequest(request);
		
			FileItem fileItem = list.get(0);
			FileItem fileIte = list.get(1);
			System.out.println("普通表单项演示:"+fileItem.getFieldName()+"="+fileItem.getString("utf-8"));
			
			System.out.println("文件表单项演示：");
			System.out.println("Content-Type: " + fileIte.getContentType());
			System.out.println("size: " + fileIte.getSize());
			System.out.println("filename: " + fileItem.getName());
			
			//保存文件
			File destFile = new File("c:/cd");
			try {
				fileItem.write(destFile);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			
		} catch (FileUploadException e) {
			
			e.printStackTrace();
		}
		
	
		
		
		
	}

}
