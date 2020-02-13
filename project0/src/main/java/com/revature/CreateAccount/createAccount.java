package com.revature.CreateAccount;

import com.revature.clientAccount.clientAccount;
import com.revature.daos.AccountDaos;
import com.revature.daos.UserAccountsDaos;
import com.revature.daos.UserDaos;
import com.revature.model.account.Account;
import com.revature.model.account.User;
import com.revature.model.account.UserAccounts;
import com.revature.util.AccountTypeUtil;
import com.revature.util.FirstBalanceUtil;
import com.revature.util.JointUserIdUtil;
import com.revature.util.PasswordUtil;
import com.revature.util.setNameUtil;


public class createAccount{	
	
	private static int UserId;
	private static String FirstName;
	private static String LastName;
	private static String password;
	private static int balance;
	private static String accountType;
	private static int accountNumber;
	//getting persons First and Last name
	
	public static void getFirstName() {
		
		//set first name
		FirstName = setNameUtil.setFirstName();
		//set last name
		LastName = setNameUtil.setLastName();
		//pass names to password to get finalized
		CreatePassword(FirstName, LastName);
		
	}


	
	//creating password and confirming it
	
	public static void CreatePassword(String FirstName, String LastName) {
		//setting and confirming password
		password = PasswordUtil.CreatePassword();
		//send to create user
		User user = new User(UserId, FirstName, LastName, password);
		//create user in database
		user = UserDaos.createUser(user);
		//set first balance for new user account
		createAccount.setFirstBalance(user);
		
	}

	//sets a starting balance for your account
	public static void setFirstBalance(User user) {
		
		//choose account type and set the balance
		balance = FirstBalanceUtil.SetFirstBalance();
		accountType = AccountTypeUtil.SetAccountType();
		//make account class and assign values
		Account account = new Account(accountNumber, balance, accountType);
		//create account in database
		account = AccountDaos.createAccount(account);
		accountNumber = account.getBalance();
		//asking about joint user
		boolean joint = JointUserIdUtil.chooseUserAccountJoint(account);
		//getting userId for user account
		int userId = user.getUserId();
		//make UserAccounts class and assign values
		UserAccounts userAccount = new UserAccounts(userId, account.getAccountNumber(), joint);
		//creating user account in database
		UserAccountsDaos.createUserAccount(userAccount);
		//calling customer menu and passing the signed in user
		clientAccount.customerChoice(user);
		
	}


}
