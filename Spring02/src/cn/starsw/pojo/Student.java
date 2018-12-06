package cn.starsw.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
	
	
	
public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<Integer, String> getMap() {
		return map;
	}
	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}
private int id;
private String name;
private Set<String> sets;
private List<String> list;
private Map<Integer, String> map;
private String [] str ;
private Computer com;
public Computer getCom() {
	return com;
}
public void setCom(Computer com) {
	this.com = com;
}
public String[] getStr() {
	return str;
}
public void setStr(String[] str) {
	this.str = str;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", sets=" + sets + ", list=" + list + ", map=" + map + ", str="
			+ Arrays.toString(str) + ", com=" + com + "]";
}
public Set<String> getSets() {
	return sets;
}
public void setSets(Set<String> sets) {
	this.sets = sets;
}
public int getId() {
	return id;
}
public Student() {
	super();
}
public Student(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


}
