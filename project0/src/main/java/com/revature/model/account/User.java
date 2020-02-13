package com.revature.model.account;

public class User {

	public static int UserId;
	public String FirstName;
	public String LastName;
	public static String password;
	
	public static int getUserId() {
		return UserId;
	}

	public void setUserId(int UserId) {
		User.UserId = UserId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	
	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		User.password = password;
	}
	
	public User(int UserId, String FirstName, String LastName, String password) {
		super();
		this.UserId = UserId;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.password = password;
	}
	
	
}
