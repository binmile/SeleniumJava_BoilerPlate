package com.automate.selenium.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automate.selenium.base.TestBase;
import com.automate.selenium.pages.HomePage;
import com.automate.selenium.pages.RegisterAccountPage;
import com.automate.selenium.util.TestConstants;

public class RegisterTest extends TestBase {
	
	@Test
	public void registerUser() {
		System.out.println("Testing register with valid credentials");
		HomePage page = new HomePage(driver);
		page.clickOnMyAccount();
		page.clickOnRegisterOption();
		RegisterAccountPage register = new RegisterAccountPage(driver);
		register.enterFirstName("TestUserFName");
		register.enterLastName("TestUserLName");
		register.enterEmail("TestUser"+System.currentTimeMillis()+"@gmail.com");
		register.enterTelephone("9922992299");
		register.enterPassword("password123");
		register.enterConfirmPassword("password123");
		register.clickOnNewsLetter();
		register.clickOnAgree();
		register.clickOnContinue();
		
		Assert.assertEquals(TestConstants.MSG_ACCOUNT_CREATION_CONFIRMATION,register.getAccountCreationSuccessMessage());
		
	}
	
	@Test
	public void registerUserWithAldreadyRegisteredEmail() {	
		System.out.println("Testing register with valid credentials");
		HomePage page = new HomePage(driver);
		page.clickOnMyAccount();
		page.clickOnRegisterOption();
		RegisterAccountPage register = new RegisterAccountPage(driver);
		register.enterFirstName("TestUserFName");
		register.enterLastName("TestUserLName");
		register.enterEmail("testmail@gmail.com");
		register.enterTelephone("9922992299");
		register.enterPassword("password123");
		register.enterConfirmPassword("password123");
		register.clickOnNewsLetter();
		register.clickOnAgree();
		register.clickOnContinue();
		
		Assert.assertEquals(TestConstants.WARNING_EMAIL_ALREADY_REGISTERED,register.getAccountCreationErrorMessage());
		
		
	}
	
}


