package com.revature.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.model.account.Account;

public class JointUserIdUtil {

	static Scanner s = new Scanner(System.in);
	
	public static boolean chooseUserAccountJoint(Account account){
		
		System.out.println("Do they want a joint account?  \n1.Yes \n2.No");
		int accountNumber = account.getAccountNumber();
		Integer jointAccount = 0;
		boolean joint;
		
		while(jointAccount == 0) {
			jointAccount = s.nextInt();
			
			switch(jointAccount) {
		
			case 1: System.out.println("What is the joint user's id?");
					int jointUserId = s.nextInt();
					createJointUserAccount(jointUserId, accountNumber);
					joint = true;
					return joint;
				
			case 2:
				return joint = false;
				
			default:	joint = false;
		
			}
		}
		return joint = false;
	}
	
	public static void createJointUserAccount(int jointUserId, int accountNumber) {
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO userAccounts ( user_id, account_number) " +
					" VALUES (?, ?) RETURNING *";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, jointUserId);
			statement.setInt(2, accountNumber);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				return;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return;
	}
	
}
