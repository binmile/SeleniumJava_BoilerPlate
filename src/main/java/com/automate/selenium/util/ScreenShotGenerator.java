package com.automate.selenium.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class ScreenShotGenerator {
	
	public void captureScreenshot(WebDriver driver, String pageName) {
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File desFile=new File(System.getProperty("user.dir")+"\\Screenshots\\"+"pageName_"+System.currentTimeMillis());
			FileUtils.copyFile(srcFile, desFile);
		} catch (WebDriverException e) {
			System.out.println("WebDriverException caught while capturing screenshot");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException caught while capturing screenshot");
			e.printStackTrace();
		}

	}
	
	
}
