package com.xing.servce;

import java.util.List;

import com.xing.dao.GoodDao;
import com.xing.domain.Goods;

public class GoodServive {

	public List<Goods> findAllGoods() {
		//把这个交到 dao层 有他专门负责交互数据
		GoodDao goodDao = new GoodDao();
		List<Goods> allGoods=goodDao.findAllGoods();
		return	allGoods;
		
		
		
	}

}
