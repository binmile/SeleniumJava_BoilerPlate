package com.automate.selenium.util;

import java.io.File;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerator {

	public static ExtentReports generateReport() {
		ExtentReports extentReports = new ExtentReports();

		// add test environment info
		Properties prop = Utilities.loadConfigProperties();
		extentReports.setSystemInfo("appURL", prop.getProperty("appURL"));
		extentReports.setSystemInfo("OS", prop.getProperty("os"));
		extentReports.setSystemInfo("username", prop.getProperty("username"));
		extentReports.setSystemInfo("browser", prop.getProperty("browser"));

		File reportFile = new File(TestConstants.EXTENT_REPORT_FILE_PATH);

		ExtentSparkReporter spartReporter = new ExtentSparkReporter(reportFile);
		extentReports.attachReporter(spartReporter);
		
		// add configurations for look and feel
		spartReporter.config().setTheme(Theme.STANDARD);
		spartReporter.config().setDocumentTitle("Test Run Report");
		spartReporter.config().setReportName("Test Report");
		spartReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		return extentReports;
	}
}
