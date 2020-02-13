package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.main.lastCityBank;
import com.revature.model.account.User;
import com.revature.util.ConnectionUtil;

public class UserDaos {

	public static User extractUser(ResultSet result) throws SQLException {
		int UserId = result.getInt("user_id");
		String FirstName = result.getString("first_name");
		String LastName = result.getString("last_name");
		String password = result.getString("user_password");
		return new User(UserId, FirstName, LastName, password);
	}
	
	//gets account number from database
		public static User getUserId(int UserId) {
			try(Connection connection = ConnectionUtil.getConnection()) {
				String sql = "SELECT user_id, first_name, last_name, user_password FROM users " +
						"WHERE user_id = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				
				// Set PreparedStatement parameters
				statement.setInt(1, UserId);
				
				ResultSet result = statement.executeQuery();
				
				if(result.next()) {
					String FirstName = result.getString("first_name");
					String LastName = result.getString("last_name");
					String password = result.getString("user_password");
					return new User(UserId, FirstName, LastName, password);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return null;		
		}
		
		//creates new account
		public static User createUser(User user) {
			try(Connection connection = ConnectionUtil.getConnection()) {
				String sql = "INSERT INTO users (first_name, last_name, user_password) " +
						" VALUES (?, ?, ?) RETURNING *";
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, user.getFirstName());
				statement.setString(2, user.getLastName());
				statement.setString(3, user.getPassword());
				
				ResultSet result = statement.executeQuery();
				
				if(result.next()) {
					return extractUser(result);
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//drop user accounts
		public static User dropUser(User user) {
			try(Connection connection = ConnectionUtil.getConnection()) {
				String sql = "DELETE FROM users WHERE user_id = ?" ;
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setInt(1, user.getUserId());
				
				
				int result = statement.executeUpdate();
				
				if(result >= 0) {
					String [] args = {};
					lastCityBank.main(args);
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
}
