package com.automate.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {
	
	WebDriver driver;
	
	public RegisterAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page objects
	
	@FindBy(id="input-firstname")
	WebElement firstName;
	
	@FindBy(id="input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-telephone")
	WebElement telephone;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(id="input-confirm")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='newsletter'][@value=0]")
	WebElement newsLetter;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueBtn;
	
	@FindBy(css="div#content>h1")
	WebElement accountCreationSuccessMsg;
	
	@FindBy(css="div.alert-dismissible")
	WebElement accountCreationErrorMsg;
	
	//Actions
	
	public void enterFirstName(String fName) {
		this.firstName.sendKeys(fName);
	}
	
	public void enterLastName(String lName) {
		this.lastName.sendKeys(lName);
	}
	
	public void enterEmail(String emailID) {
		this.email.sendKeys(emailID);
	}
	
	public void enterTelephone(String telephone) {
		this.telephone.sendKeys(telephone);
	}
	
	public void enterPassword(String pwd) {
		this.password.sendKeys(pwd);
	}
	
	public void enterConfirmPassword(String confirmPwd) {
		this.confirmPassword.sendKeys(confirmPwd);
	}
	
	public void clickOnNewsLetter() {
		this.newsLetter.click();
	}
	
	public void clickOnAgree() {
		this.agree.click();
	}
	
	public void clickOnContinue() {
		this.continueBtn.click();
	}
	
	public String getAccountCreationSuccessMessage() {
		return this.accountCreationSuccessMsg.getText();
	}
	
	public String getAccountCreationErrorMessage() {
		return this.accountCreationErrorMsg.getText();
	}

}
