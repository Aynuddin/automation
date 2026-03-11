package com.selenium.in.base;

import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import com.selenium.in.actiondriver.DriverFactory;
import com.selenium.in.config.ConfigManager;
import com.selenium.in.reports.ExtentManager;

public class BaseClass {
	
	@BeforeSuite
	//@Parameters("browser")
	// initalize the browser
	public void setUp() {
		String browserName = ConfigManager.getPropertyValue("browser");
		System.out.println("Browser name :"+browserName);
		DriverFactory.initDriver(browserName);
		configBrowser();
		
	}
	
	@AfterSuite
	public void destoryApplication() {
		//ExtentManager.endTest();
		if(DriverFactory.getDriver() != null) {
			DriverFactory.quitDriver();
		}
	}
	
	public void configBrowser() {
		try {
			DriverFactory.getDriver().get(ConfigManager.getPropertyValue("url"));
			DriverFactory.getDriver().manage().window().maximize();
			DriverFactory.getDriver().manage().timeouts().implicitlyWait(
					Duration.ofSeconds(Integer.parseInt(ConfigManager.getPropertyValue("implicitWait"))));
		} catch (Exception e) {
          System.out.println("Failed to navigate the url");
		}
		
	}

}
