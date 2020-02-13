package com.revature.login;

import java.util.Scanner;

import com.revature.clientAccount.clientAccount;
import com.revature.daos.UserDaos;
import com.revature.model.account.User;

public class loginImplement {

	static Scanner s = new Scanner(System.in);
	
		
		public static void enterUsername() {
			
			
			
			System.out.println("Please enter your UserId");
			
			while(s.hasNext()) {
				
				//get userId for users search
				int UserId = s.nextInt();
				
				//putting data from search into class
				User user = UserDaos.getUserId(UserId);
			
				//check if the userId is same as id entered
				if (User.UserId == UserId) {				
				
					//compares password to supplied password
					loginImplement.confirmPassword(user);
				
				}else {
				
					System.out.println("Their is no user under that Id");
				}
			}
		}
		

		public static void confirmPassword(User user) {
					
			//has the client enter their password
			System.out.println("Have the client enter their password.");
			
			while(s.hasNext()) {
				
				//get password input from client
				String checkPassword = s.next();
				
				//get password from user account
				String password = User.getPassword();
				
				//compares entered password to the user password
				
				if (checkPassword.equals(password)) {
					
					//directs to account menu
					clientAccount.customerChoice(user);
								
				}else  {
				
					//when they get it wrong
					System.out.println("Sorry your password was incorrect, Please try again.");
				
				}
			}
			
		}
	
}

	
