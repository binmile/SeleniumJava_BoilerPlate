package com.automate.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Objects
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(css=".alert-dismissible")
	WebElement emailPasswordNotMatchingWarningText;

	
	//Actions
	
	public void enterEmail(String username) {
		email.sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginButton() {
		loginBtn.click();
	}
	
	public String getEmailPasswordNotMatchingWarningText() {
		return emailPasswordNotMatchingWarningText.getText();
	}
}
