package com.star.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.star.mapper.FileMapper;
import com.star.pojo.Files;

@Service
public class FileService {

	@Resource
	private FileMapper fileMapper;
	
	public List<Files> show(){
		return fileMapper.selAll();
	}
	
	public int upd(int id) {
	
	    return fileMapper.upd(id);
	
	}
	
	
	
}
