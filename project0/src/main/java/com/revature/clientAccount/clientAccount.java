package com.revature.clientAccount;

import java.util.Scanner;

import com.revature.daos.AccountDaos;
import com.revature.daos.UserAccountsDaos;
import com.revature.main.lastCityBank;
import com.revature.model.account.Account;
import com.revature.model.account.User;
import com.revature.model.account.UserAccounts;
import com.revature.util.DepositUtil;
import com.revature.util.WithdrawlUtil;
import com.revature.util.dropAccountUtil;
import com.revature.util.transferUtil;

public class clientAccount{
		
	public static void customerChoice(User user) {
		
		//setting account and user values to variables
		String clientFirstName = user.getFirstName();
		String clientLastName = user.getLastName();
		int UserId = User.UserId;
		//getting and making user account using the user id
		UserAccounts userAccount = UserAccountsDaos.getUserAccounts(UserId);
		int accountNumber = userAccount.accountNumber;
		//getting and making the account using the account number
		Account account = AccountDaos.getAccountNumber(accountNumber);
		int balance = account.Balance;
		//set scanner
		Scanner r = new Scanner(System.in);
		
		//set while loop variable
		int choice = 0;
		
		
		//display the clients account number, name, and balance for teller
		System.out.println("Client Account Number: #" + accountNumber + " \nClient Name: " + clientFirstName + " " + clientLastName 
				+ "\nYour balance is " + balance + " caps.");
		
		//set loop menu for manipulating account
		while(choice <= 0 || choice > 6) {
			System.out.println("What would they like to do? \n 1. Deposit \n 2. Withdrawl \n 3. Check Balance \n "
					+ "4. Transfer Money \n 5. Close Account \n 6. Main Menu");
		
			choice = r.nextInt();
		
		}
		
		while(choice >= 1 && choice <= 6) {
		
		
			if(choice == 1) {
				//sends to deposit money
				DepositUtil.depositMoney(account);
			
			}else if(choice == 2) {
				//sends to withdraw money
				WithdrawlUtil.withdrawMoney(account);
				
			}else if(choice == 3) {
				//output the account balance
				System.out.println("The client's balance is " + account.getBalance() + " caps.");
				
			}else if(choice == 4){
				//sends to transfer money to another account
				transferUtil.transferMoney(account);
			
			}else if(choice == 5) {
				//drop account
				dropAccountUtil.dropAccount(user, account);
				
			}else {
				//make it wrap around to main
				String [] args = {};
				lastCityBank.main(args);
				r.close();
				
			}
			System.out.println("What would they like to do? \n 1. Deposit \n 2. Withdrawl \n 3. Check Balance \n "
					+ "4. Transfer Money \n 5. Close Account \n 6. Main Menu");
			
			choice = r.nextInt();
		
		}
		r.close();
		
	}

}
