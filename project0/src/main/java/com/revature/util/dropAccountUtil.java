package com.revature.util;

import java.util.Scanner;

import com.revature.clientAccount.clientAccount;
import com.revature.daos.AccountDaos;
import com.revature.daos.UserAccountsDaos;
import com.revature.daos.UserDaos;
import com.revature.model.account.Account;
import com.revature.model.account.User;

public class dropAccountUtil {

	public static void dropAccount(User user, Account account) {
		
		Scanner c = new Scanner(System.in);
		
		int close = 0;
		System.out.println("Is the customer sure they want to CLOSE their account? \n1. Yes \n2. No");
		
		
		while(close == 0) {
		
			close = c.nextInt();
			
			if(close == 1) {
				
				int accountNumber = account.getAccountNumber();
				UserAccountsDaos.dropUserAccount(user.getUserId());
				UserDaos.dropUser(user);
				
			
			}else if(close == 2){
			
				clientAccount.customerChoice(user);
			
			}else {
			
				System.out.println("That was not a valid entry.");
			
			}
		}
	}
}
