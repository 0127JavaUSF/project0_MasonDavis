package com.revature.util;

import java.util.Scanner;

public class setNameUtil {

	static Scanner s = new Scanner(System.in);
	
		public static String setFirstName() {
			
			System.out.println("Please enter you First name. ");
			String FirstName = s.next();
		
			
			return FirstName;
			
		}
		
		public static String setLastName() {
			
			System.out.println("Please enter your last name. ");
			String LastName = s.next();
			
			return LastName;
			
			
		}
}
