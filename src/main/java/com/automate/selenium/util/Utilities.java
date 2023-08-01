package com.automate.selenium.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utilities {

	public static Properties loadConfigProperties() {
		Properties prop = null;
		try {
			prop = new Properties();
			File file = new File(TestConstants.CONFIG_PROPERTIES_FILE_PATH);
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			System.out.println("Configuration properties have been loaded successfully");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	public static void launchReportInBrowser(File reportFile) {
		try {
			Desktop.getDesktop().browse(reportFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
