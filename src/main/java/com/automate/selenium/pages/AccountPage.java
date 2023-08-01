package com.automate.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	public AccountPage(WebDriver driver){
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Page Objects
	
	@FindBy(linkText="Edit your account information")
	WebElement editYourAccountInformationOption;
	
	//Actions
	public Boolean isEditYourAccountInformationDisplayed() {
		return this.editYourAccountInformationOption.isDisplayed();
	}
	
}
