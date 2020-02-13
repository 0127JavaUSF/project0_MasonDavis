package com.revature.util;

import java.util.Scanner;


import com.revature.daos.AccountDaos;
import com.revature.model.account.Account;


public class WithdrawlUtil {
	
	

	public static void withdrawMoney(Account account) {
	
		Scanner withdrawlResponse = new Scanner(System.in);
	
		int withdrawl = -1;
		while(withdrawl != 0) {
			
			System.out.println("How much would they like to withdrawl? \n To exit enter 0");
			withdrawl = withdrawlResponse.nextInt();
			withdrawl = Math.abs(withdrawl);
			
			if(withdrawl <= account.Balance) {
		
				int balance = account.Balance - withdrawl;
				//set account balance
				account.setBalance(balance);
				//updating account
				AccountDaos.updateAccount(account);
				withdrawl = 0;
				System.out.println(account.Balance);
		
			}else if(withdrawl > account.Balance) {
			
				System.out.println("Insufficient funds \n Please input a different amount.");
				withdrawl = -1;
			
			}else if(withdrawl == 0) {
				
				
	
				
			}
	

		}
		
				
	}
}
