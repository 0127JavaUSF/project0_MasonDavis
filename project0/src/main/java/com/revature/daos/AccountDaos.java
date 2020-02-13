package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.main.lastCityBank;
import com.revature.model.account.Account;
import com.revature.model.account.User;
import com.revature.util.ConnectionUtil;

public class AccountDaos {

	//gets account number, account balance, and the type of account
	public static Account extractAccount(ResultSet result) throws SQLException {
		int Balance = result.getInt("balance");
		String AccountType = result.getString("account_type");
		int AccountNumber = result.getInt("account_number");
		return new Account(AccountNumber, Balance, AccountType);
	}
	
	//gets account number from database
	public static Account getAccountNumber(int AccountNumber) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT account_number, balance, account_type FROM accounts " +
					"WHERE account_number = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			// Set PreparedStatement parameters
			statement.setInt(1, AccountNumber);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				//sets and returns a full Account
				int Balance = result.getInt("balance");
				String AccountType = result.getString("account_type");
				return new Account(AccountNumber, Balance, AccountType);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
	//update account_balance
	public static Account updateAccount(Account account) {
		
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "UPDATE accounts SET balance = ? "
					+ "WHERE account_number = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, account.getBalance());
			statement.setInt(2, account.getAccountNumber());
			
			int result = statement.executeUpdate();
			
			if(result == 0) {
				
				return account;
			}	
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	//creates new account
	public static Account createAccount(Account account) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO accounts (balance, account_type) " +
					" VALUES (?, ?) RETURNING *";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, account.getBalance());
			statement.setString(2, account.getAccountType());
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				return extractAccount(result);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//drop account by account number
	public static User dropAccount(int accountNumber) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM accounts WHERE account_number = ?" ;
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, accountNumber);
			
			
			int result = statement.executeUpdate();
			
			if(result >= 0) {
				//inform teller the account has been closed.
				System.out.println("Their account has been deleted.");
				String [] args = {};
				lastCityBank.main(args);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
