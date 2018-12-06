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
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.commons.CommonUtils;

public class UPloadServlet2 extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   /*
		 * 上传三步
		 */
		// 工厂 给文件加以限制
		DiskFileItemFactory factory = new DiskFileItemFactory(20*1024, new File("F:/f/temp"));
		//解析器
		ServletFileUpload sup = new ServletFileUpload(factory);
//		sfu.setFileSizeMax(100 * 1024);//限制单个文件大小为100K
//		sfu.setSizeMax(1024 * 1024);//限制整个表单大小为1M
		
		
		//解析 得到List
		
		
		try {
			List<FileItem> list=sup.parseRequest(request);
		      FileItem fi = list.get(1);
//////////////////////////////////////////////////////
		 
		 
		 
		 //1 得到文件保存的路径 保存到web-inf下
		 String root = this.getServletContext().getRealPath("WEB-INF/files/");
		 
		 /*
			 * 2. 生成二层目录
			 *   1). 得到文件名称
			 *   2). 得到hashCode
			 *   3). 转发成16进制
			 *   4). 获取前二个字符用来生成目录
			 */
		 
		 String filename = fi.getName();//获取上传的文件名称
		 /*
		  * 处理文件名的绝对路径问题 比如 c：/file/z.txt;必须把/去掉
		  * 
		  * */
		 int index = filename.lastIndexOf("\\");
		 //当他不等于-1 说明 有\\ 
		 if(index!=-1){
			 //然后 重新 负值 在 index \ 后面的 z.txt
			filename=filename.substring(index+1); 
		 }
		 /*
			 * 给文件名称添加uuid前缀，处理文件同名问题  
			 */
		 String savename = CommonUtils.uuid()+"_"+filename;
		 
		 
		 //生成 2级目录
		/* 1). 得到文件名称
		 *   2). 得到hashCode
		 *   3). 转发成16进制
		 *   4). 获取前二个字符用来生成目录
		 
		 */
		 //获取哈希值
		 int hashCode = filename.hashCode();
		 //把10进制 转换成 16进制
		 String hexString = Integer.toHexString(hashCode);
		   /*
			 * 2. 获取hex的前两个字母，与root连接在一起，生成一个完整的路径
			 */
			File dirFile = new File(root, hexString.charAt(0) + "/" + hexString.charAt(1));
		 
			/*
			 * 获取了 但是必须创建 目录连
			 * 这个方法是有目录不创建 直接加 没有就创建
			 *  
			 */
			dirFile.mkdirs();
			
			/*
			 * 4. 创建目录文件  文件 目录
			 */
			File deslFile= new File(dirFile, savename);
		try {
			//写
			fi.write(deslFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 
//////////////////////////////////////////////////////
		 
		 
		 
		 
		
		
		
		} catch (FileUploadException e) {
			if(e instanceof FileUploadBase.FileSizeLimitExceededException) {
				request.setAttribute("msg", "您上传的文件超出了100KB！");
				request.getRequestDispatcher("/form3.jsp").forward(request, response);
			}
		}
		
		
		
		
	}

}
