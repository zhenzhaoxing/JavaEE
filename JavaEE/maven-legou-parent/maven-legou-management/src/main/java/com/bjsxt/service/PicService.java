package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Pic;


public interface PicService {
	int insPic(Pic pic);
	
	List<Pic> show();
	
	int delById(int id);
}
