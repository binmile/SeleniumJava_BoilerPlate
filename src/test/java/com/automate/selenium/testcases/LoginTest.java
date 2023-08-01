package com.automate.selenium.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automate.selenium.base.TestBase;
import com.automate.selenium.pages.AccountPage;
import com.automate.selenium.pages.HomePage;
import com.automate.selenium.pages.LoginPage;
import com.automate.selenium.util.CSVUtility;
import com.automate.selenium.util.TestConstants;

public class LoginTest extends TestBase{
	
	@Test(priority = 1,dataProvider = "readTestData")
	public void verifyLoginWithValidCredentials(String username, String password) {
		System.out.println("Testing login with valid credentials");
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.clickOnLoginOption();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		AccountPage accountPage = new AccountPage(driver);
		System.out.println("flag ="+accountPage.isEditYourAccountInformationDisplayed());
		Assert.assertTrue(accountPage.isEditYourAccountInformationDisplayed());
		
	}
	
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {		
		System.out.println("Testing login with invalid credentials");
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.clickOnLoginOption();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail("t" + System.currentTimeMillis() +"@gmail.com");
		loginPage.enterPassword("password123");
		loginPage.clickOnLoginButton();
		
		String actualErrorMsg = loginPage.getEmailPasswordNotMatchingWarningText();
		
		Assert.assertEquals(TestConstants.WARNING_EMAIL_PASSWORD_NOT_MATCHING,actualErrorMsg);
	}
	

	@DataProvider
	public Object[][] readTestData() {
		return CSVUtility.readDataFromCSV("LoginTestData");
	}
	
}
