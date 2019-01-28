package com.star.pojo;

public class Users {
private int id;
private String username;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Override
public String toString() {
	return "Users [id=" + id + ", username=" + username + "]";
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

}
