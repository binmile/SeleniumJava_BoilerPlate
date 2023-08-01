package com.automate.selenium.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automate.selenium.exception.BrowserNotSupportedException;
import com.automate.selenium.util.DriverFactory;
import com.automate.selenium.util.TestConstants;
import com.automate.selenium.util.Utilities;

public class TestBase {

	protected WebDriver driver;
	
	@BeforeMethod
	    public void setUp() {
	        try {
	        	Properties prop = Utilities.loadConfigProperties();
				driver = new DriverFactory().createInstance(prop.getProperty("browser"));
				driver.get(prop.getProperty("appURL"));
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestConstants.IMPLICIT_WAIT_TIME));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestConstants.PAGE_WAIT_TIME));	
				System.out.println("WebDriver initialized and Application launched successfully");
			} catch (BrowserNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

		
	
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Tear Down completed");
		}
	
	}

}
