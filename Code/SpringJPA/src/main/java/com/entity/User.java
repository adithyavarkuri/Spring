package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "users")
//@Table(name = "users")
public class User {

	@Id
	@Column(name = "userid")
	int userId;
	@Column(name = "username")
	String userName;
	@Column(name = "email")
	String email;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int userId, String userName, String email) {
		this.userName = userName;
		this.userId = userId;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
