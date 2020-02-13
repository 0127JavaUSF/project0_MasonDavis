package com.revature.util;

import java.util.Scanner;

public class FirstBalanceUtil {

	static Scanner s = new Scanner(System.in);
	
	public static int SetFirstBalance() {
		
		int balance = 0;
		while(balance < 5) {
			
		System.out.println("How much would you like to put in your account? There is a minumum of 5 caps.");
		balance = s.nextInt();

		
		
		}
		
		return balance;
	}
	
}
