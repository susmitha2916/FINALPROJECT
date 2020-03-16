package com.vp.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id   
private int uid;
private String username;
private String password;
private String type;
private String email;
private String mobile;
private String confirmed;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
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
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getmobile() {
	return mobile;
}
public void setmoile(String mobile) {
	this.mobile = mobile;
}
public String getConfirmed() {
	return confirmed;
}
public void setConfirmed(String confirmed) {
	this.confirmed = confirmed;
}
}
