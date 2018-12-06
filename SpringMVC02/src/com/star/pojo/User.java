package com.star.pojo;

public class User {
 String username;
 String passwords;
public String getUsername() {
	return username;
}
@Override
public String toString() {
	return "User [username=" + username + ", passwords=" + passwords + "]";
}
public void setUsername(String username) {
	this.username = username;
}
public String getPasswords() {
	return passwords;
}
public void setPasswords(String passwords) {
	this.passwords = passwords;
}
}
