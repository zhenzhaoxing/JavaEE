package cn.starsw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.starsw.pojo.Airport;

public interface AirportMapper {
   @Select("select *from airport where id in(select takeid from airplane)")
   List<Airport> selTakePort();
   
   @Select("select *from airport where id in(select landid from airplane)")
   List<Airport> selLandPort();
}
