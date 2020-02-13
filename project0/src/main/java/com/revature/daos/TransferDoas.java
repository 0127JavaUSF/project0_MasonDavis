package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.model.account.Account;
import com.revature.util.ConnectionUtil;

public class TransferDoas {

	public static Account transferFunds(Account account, Account transferAccount) {
		
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "	UPDATE accounts SET balance = ? WHERE account_number = ?;";
			
			PreparedStatement statement = connection.prepareStatement(sql);

			
			statement.setInt(1, account.getBalance());
			statement.setInt(2, account.getAccountNumber());
			
			int result = statement.executeUpdate();

			
			if(result == 1) {
				//connection.commit();
			}	
		}catch(SQLException e) {
			//connection.rollback();
			e.printStackTrace();
		}
		
		try(Connection connection = ConnectionUtil.getConnection()){		
			String sql2 = " UPDATE accounts SET balance = ? WHERE account_number = ?;";
			
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			
			statement2.setInt(1, transferAccount.getBalance());
			statement2.setInt(2, transferAccount.getAccountNumber());
		
			int result2 = statement2.executeUpdate();
			
			if(result2 == 1) {
				//connection.commit();
			}	
		}catch(SQLException e) {
			//connection.rollback();
			e.printStackTrace();
		}
			return null;
	}
}
