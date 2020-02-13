package com.revature.util;

import java.util.Scanner;
import com.revature.daos.AccountDaos;
import com.revature.daos.TransferDoas;
import com.revature.model.account.Account;

public class transferUtil {

	public static void transferMoney(Account account) {
		
		Scanner t = new Scanner(System.in);
		
		//get the account number your trying to transfer to
		System.out.println("What is the account number they are transfering to?");
		int transferToAccount = t.nextInt();
		
		//get the transfer amount
		System.out.println("How much are they wanting to transfer?");
		int amountToTransfer = t.nextInt();
		
		//assign the account to a object/class
		Account transferAccount = AccountDaos.getAccountNumber(transferToAccount);
		
		//assigning the balance for the account receiving the money
		int transferAccountBalance = transferAccount.Balance;
		
		//assigning the balance from the account sending the money
		int accountBalance = account.getBalance();
		
		//switching the money
		accountBalance = accountBalance - amountToTransfer;
		transferAccountBalance = transferAccountBalance + amountToTransfer;
		
		//set account balances
		transferAccount.setBalance(transferAccountBalance);
		account.setBalance(accountBalance);
		
		//update the accounts 
		TransferDoas.transferFunds(account, transferAccount);
		
	}
	
}
