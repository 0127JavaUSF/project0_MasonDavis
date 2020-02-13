package com.revature.util;

import java.util.Scanner;

public class AccountTypeUtil {
	
	public static String SetAccountType(){
		
		Scanner c = new Scanner(System.in);
		
		int choice = 0;
		String accountType;
		
		while(choice < 1 || choice > 2) {
			
		System.out.println("Which kind of account does the client want? \n 1. Checkings \n 2. Savings");
		
		choice = c.nextInt();
		
		}
		
		if(choice == 1) {
			accountType = "Checking";
		}else
			accountType = "Savings";
			
			return accountType;
		
	}
}
