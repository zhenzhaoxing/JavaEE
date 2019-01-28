package cn.starsw.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.starsw.mapper.AirportMapper;
import cn.starsw.pojo.Airport;
import cn.starsw.util.MyBatisUtil;

public class AirportService {
	public List<Airport> showTakePort() {
		SqlSession session = MyBatisUtil.getSession();
		AirportMapper airportMapper = session.getMapper(AirportMapper.class);
		return airportMapper.selTakePort();

	}
	public List<Airport> showLandPort() {
		SqlSession session = MyBatisUtil.getSession();
		AirportMapper airportMapper = session.getMapper(AirportMapper.class);
		return airportMapper.selLandPort();

	}
}
