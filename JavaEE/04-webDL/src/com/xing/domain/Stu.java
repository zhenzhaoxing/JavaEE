package com.xing.domain;


public class Stu {
	private String id;
	private String username;
	private String password;
private String phone;
	public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Used [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
