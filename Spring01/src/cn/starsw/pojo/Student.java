package cn.starsw.pojo;

public class Student {
private int id;
private String name;
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + "]";
}
public int getId() {
	return id;
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
