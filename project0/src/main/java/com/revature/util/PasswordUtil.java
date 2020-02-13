package com.revature.util;

import java.util.Scanner;

public class PasswordUtil {

	static Scanner s = new Scanner(System.in);
	
	public static String CreatePassword() {
		
		String password;
		String confirmPassword;
		
		 do {
			 System.out.println("Please enter a password: ");
			 	password = s.next();
				System.out.println("Please re-enter your password: ");
				confirmPassword = s.next();
				
				
				
		 }while(password.equals(confirmPassword) != true);
		
		 return password;
	}
}
