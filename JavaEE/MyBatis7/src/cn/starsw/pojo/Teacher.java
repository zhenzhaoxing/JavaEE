package cn.starsw.pojo;

import java.util.List;

public class Teacher {
private int id;
private String name;
List<Student> list;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public List<Student> getList() {
	return list;
}
public void setList(List<Student> list) {
	this.list = list;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Teacher [id=" + id + ", name=" + name + ", list=" + list + "]";
}

}
