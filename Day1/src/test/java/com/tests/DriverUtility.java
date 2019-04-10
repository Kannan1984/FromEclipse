package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverUtility {
	//Input:browser name
	//Output:Driver Instance
	public static WebDriver getDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
			return new ChromeDriver();
		}else if(browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\WebDriver\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\geckodriver.exe");
			return new FirefoxDriver();
		}else {
			return null;
		}
	}

}
