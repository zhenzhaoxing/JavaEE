package domain;

public class Person {
private String name;
private String password;
private String uid;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
@Override
public String toString() {
	return "Person [name=" + name + ", password=" + password + ", uid=" + uid + "]";
}
}
