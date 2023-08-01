package com.automate.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.automate.selenium.exception.BrowserNotSupportedException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver createInstance(String browser) throws BrowserNotSupportedException{
        WebDriver driver;
        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());

        switch (browserType) {
        case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case IE:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		case SAFARI:
			WebDriverManager.safaridriver().setup();;
			driver = new SafariDriver();
			break;
			
		default:
            throw new BrowserNotSupportedException(browser + " browser is not currently supported!");
        }
        return driver;
    }

    public enum BrowserList {
        CHROME, FIREFOX, EDGE, SAFARI, IE
    }
}
