package cn.starsw.pojo;

public class Airport {
 private int id;
 private String cityName;//城市名
 private String portName;//机场名
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCityName() {
	return cityName;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
}
public String getPortName() {
	return portName;
}
public void setPortName(String portName) {
	this.portName = portName;
}
@Override
public String toString() {
	return "Airport [id=" + id + ", cityName=" + cityName + ", portName=" + portName + "]";
}
}
