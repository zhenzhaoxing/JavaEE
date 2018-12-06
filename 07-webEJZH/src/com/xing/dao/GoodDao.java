package com.xing.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xing.domain.Goods;
import com.xing.util.JdbcUtil;

public class GoodDao {

	public List<Goods> findAllGoods() {

		
		//1.连接数据库
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		//2.从数据库当中获取数据
		String sql ="select * from goods";
		List<Goods> allGoods = null;
		try {
			allGoods = qr.query(sql, new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//在GOOdService里 调用这个方法 然后 返会给它allGoods
		return allGoods;
	}

}
