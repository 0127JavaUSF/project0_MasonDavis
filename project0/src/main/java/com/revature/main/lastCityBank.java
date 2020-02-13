package com.revature.main;

import java.util.Scanner;

import com.revature.CreateAccount.createAccount;
import com.revature.login.loginImplement;
import com.revature.views.view;



public class lastCityBank implements view {

	public static void main(String [] args) {
		
		
			
		Scanner s = new Scanner(System.in);
		int answer = 0;
		
		
		while(answer == 0) {
			System.out.println("Does the customer have an account with Last City Bank? \n 1. YES \n 2. NO");
		
			answer = s.nextInt();
		
			if(answer == 1) {
			
				loginImplement.enterUsername();
				//loginImplement.confirmPassword();
			
			}else if(answer == 2) {
			
				createAccount.getFirstName();;
			
			}else {
			
				System.out.println("Sorry that is not a valid entry. Please try again.");
				answer = 0;
			
			}
		
		}
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public view selectOption() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
