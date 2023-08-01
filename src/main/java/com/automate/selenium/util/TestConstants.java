package com.automate.selenium.util;

import java.io.File;

public class TestConstants {
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_WAIT_TIME = 5;
	public static final String WARNING_EMAIL_PASSWORD_NOT_MATCHING = "Warning: No match for E-Mail Address and/or Password.";
	public static final String MSG_ACCOUNT_CREATION_CONFIRMATION = "Your Account Has Been Created!";
	public static final String WARNING_EMAIL_ALREADY_REGISTERED = "Warning: E-Mail Address is already registered!";
	public static String CONFIG_PROPERTIES_FILE_PATH = System.getProperty("user.dir") + 
			File.separator + "src" +
			File.separator + "test" +
			File.separator + "resources" +
			File.separator + "config.properties";
	public static String EXTENT_REPORT_FILE_PATH = System.getProperty("user.dir") + 
			File.separator + "ExtentReport" +
			File.separator + "extentReport" +
			 "_" + System.currentTimeMillis() + ".html";
}
