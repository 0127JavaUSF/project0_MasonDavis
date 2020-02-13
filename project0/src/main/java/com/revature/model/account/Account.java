package com.revature.model.account;

public class Account{

	public int AccountNumber;
	public String AccountType;
	public int Balance;
	
	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int AccountNumber) {
		this.AccountNumber = AccountNumber;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String AccountType) {
		this.AccountType = AccountType;
	}

	public int getBalance() {
		return Balance;
	}

	public void setBalance(int Balance) {
		this.Balance = Balance;
	}
	
	
	public Account(int AccountNumber, int Balance, String AccountType) {
		super();
		this.AccountNumber = AccountNumber;
		this.Balance = Balance;
		this.AccountType = AccountType;
	}
	
}
