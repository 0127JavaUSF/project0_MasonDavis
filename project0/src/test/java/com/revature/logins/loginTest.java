package com.revature.logins;

import com.revature.login.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class loginTest {
	
	private loginImplement userLogin;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		userLogin = new loginImplement();
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void getUsername() {
		
		assertTrue(loginImplement.enterUsername(checkPassword).equals(loginImplement.enterUsername(passwordHolder)));
		
	}
	
	@Test
	public void enterPasswordTest() {
		assertTrue(userLogin.confirmPassword() != null);
	}


}
