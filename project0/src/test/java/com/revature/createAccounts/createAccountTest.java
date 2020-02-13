package com.revature.createAccounts;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.CreateAccount.createAccount;
import com.revature.util.setNameUtil;


public class createAccountTest {
	 
	private createAccount newAccount;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		newAccount = new createAccount();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getFirstNameTest() {

		assertTrue(setNameUtil.setFirstName() != null);
		
	}
	
	@Test
	public void getLastNameTest() {

		assertTrue(setNameUtil.setLastName() != null);
		
	}

	@Test
	public void getUserNameTest() {
		
		assertTrue(createAccount.CreateUsername() != null);
		
	}
	
	@Test
	public void setPasswordTest() {
		
		assertTrue(createAccount.CreatePassword() != null);
		
	}
	
	@Test
	public void setFirstBalanceTest() {
		
		assertTrue(newAccount.setFirstBalance() >= 5.00);
		
	}
	
	@Test
	public void generateAcountNumberTest() {
		
		assertTrue(createAccount.generateAccountNumber() > 0);
		
	}
}
