package com.xing.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo implements Filter {

   
    public FilterDemo() {
        
    }


	/**
	 * 销毁之前执行，用来做对非内存资源进行释放
	 */	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	//没次过滤都会执行
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("AFilter#start 先执行这个");
		chain.doFilter(request, response);//放行！ 在xml中写的是/index.jsp 所以放行访问jsp 不然 就以
		System.out.println("AFilter#end");
	}

	//创建就执行 用来做初始化
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
