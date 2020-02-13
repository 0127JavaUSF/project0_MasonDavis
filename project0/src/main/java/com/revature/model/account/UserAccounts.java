package com.revature.model.account;

public class UserAccounts {

	public static int UserId;
	public static int accountNumber;
	public static boolean joint;

	
	public static int getAccountsUserId() {
		return UserId;
	}

	public void setAccountsUserId(int UserId) {
		UserAccounts.UserId = UserId;
	}
	
	public static int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		UserAccounts.accountNumber = accountNumber;
	}
	
	public static boolean getjointUser() {
		return joint;
	}

	public void setJointUser(boolean joint) {
		UserAccounts.joint = joint;
	}
	
	public UserAccounts(int UserId, int accountNumber, boolean joint) {
		super();
		this.UserId = UserId;
		this.accountNumber = accountNumber;
		this.joint = joint;
	}
}
