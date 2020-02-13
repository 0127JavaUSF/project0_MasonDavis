package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.main.lastCityBank;
import com.revature.model.account.User;
import com.revature.model.account.UserAccounts;
import com.revature.util.ConnectionUtil;

public class UserAccountsDaos {

	public static UserAccounts extractAccount(ResultSet result) throws SQLException {
		boolean joint = result.getBoolean("joint");
		int userId = result.getInt("user_id");
		int accountNumber = result.getInt("account_number");
		return new UserAccounts(userId, accountNumber, joint);
	}
	
	//gets account number from database
	public static UserAccounts getUserAccounts(int userId) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT user_id, account_number, joint FROM userAccounts " +
					"WHERE user_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			// Set PreparedStatement parameters
			statement.setInt(1, userId);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				//assigns values to variables to return the full class
				int accountNumber = result.getInt("account_number");
				boolean joint = result.getBoolean("joint");
				return new UserAccounts(userId, accountNumber, joint);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
	
	
	//creates new account
	public static UserAccounts createUserAccount(UserAccounts userAccounts) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO userAccounts ( user_id, account_number) " +
					" VALUES (?, ?) RETURNING *";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, userAccounts.getAccountsUserId());
			statement.setInt(2, userAccounts.getAccountNumber());
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				return extractAccount(result);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	//deletes the user account 
	public static User dropUserAccount(int userId) {		
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM userAccounts WHERE user_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, userId);
			
			int result = statement.executeUpdate();
			
			if(result <= 0) {
				return null;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
