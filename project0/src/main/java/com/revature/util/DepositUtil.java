package com.revature.util;


import java.util.Scanner;

import com.revature.daos.AccountDaos;
import com.revature.model.account.Account;

public class DepositUtil {
	
	static Scanner depositResponse = new Scanner(System.in);
	
	public static void depositMoney(Account account) {
		//System.out.println("in the deposit money");
		int deposit = -1;
		while(deposit <= 0) {
		
			//get the amount to add
			System.out.println("How much would they like to deposit?");
			deposit = depositResponse.nextInt();
			
			//validate deposit isn't negative
			if(deposit >= 0) {
				
				//send the new balance to the database
				int balance = account.Balance + deposit;
				account.setBalance(balance);
				AccountDaos.updateAccount(account);
				
				
				System.out.println("Their balance is now " + account.Balance);
				
				
			}else {
			
				System.out.println("Invaild entry. Try again.");
			}
		}

	}
	
}
