package com.automate.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Objects
	@FindBy(xpath="//span[normalize-space(text())='My Account']")
	WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	WebElement loginOption;
	
	@FindBy(linkText="Register")
	WebElement registerOption;

	
	//Actions
	public void clickOnMyAccount() {
		myAccountDropMenu.click();	
	}
	
	public void clickOnLoginOption() {
		loginOption.click();
	}
	
	public void clickOnRegisterOption() {
		registerOption.click();
	}
}
