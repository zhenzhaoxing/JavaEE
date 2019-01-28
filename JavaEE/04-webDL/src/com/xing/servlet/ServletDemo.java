package com.xing.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.enterprise.context.spi.Context;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo
 */
@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String path = this.getServletContext().getRealPath("/WEB-INF/c.txt");
    	FileInputStream f=new FileInputStream(path);
    	ServletOutputStream out = resp.getOutputStream();
    byte[] butter = new byte[1024];
    int len=0;
    while((len=f.read(butter))>0){
    	//System.out.println(len);
    	System.out.println(Arrays.toString(butter));
    out.write(butter,0,len);
    
    
    
    }
    
    }

}
