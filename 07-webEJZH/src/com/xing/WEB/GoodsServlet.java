package com.xing.WEB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xing.domain.Goods;
import com.xing.servce.GoodServive;
import com.xing.util.JdbcUtil;

/**
 * Servlet implementation class GoodsServlet
 */
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		1.连接数据库
		2.从数据库当中获取数据
		3.把从数据库中取出的数据存放到request域当中
		4.转发到商品列表页面，转发时把request对象传入
		
		 */
		//查询数据 交到 service 
		GoodServive goodServive = new GoodServive();
		List<Goods> allGoods=goodServive.findAllGoods();
		
		//3.把从数据库中取出的数据存放到request域当中
		request.setAttribute("allGoods", allGoods);
		//4.转发到商品列表页面，转发时把request对象传入
		request.getRequestDispatcher("/goods_list.jsp").forward(request, response);
		//System.out.println(allGoods);
	}

}
