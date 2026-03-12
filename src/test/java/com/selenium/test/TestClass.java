package com.selenium.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.selenium.in.actiondriver.DriverFactory;
import com.selenium.in.base.BaseClass;
import com.selenium.in.config.ConfigManager;
import com.selenium.in.pages.LoginPage;
import com.selenium.in.pages.LogoutPage;
import com.selenium.in.reports.ExtentManager;

@Listeners(com.selenium.in.listeners.TenjinTestCaseListener.class)
public class TestClass extends BaseClass {
	
	private LoginPage logpage;

	public TestClass() {
		logpage = new LoginPage();
	}
	
	@Test(testName = "Login Test",priority = 1)
	public void loginFunctionality() throws Exception {
		//ExtentManager.startTest("Valid Login Test");
		System.out.println("Start execution...............");
		//ExtentManager.logStep("Navigate to the application url");
		logpage.login();
	}
	
	@Test(testName = "Logout Test",priority = 3)
	public void logoutTest() throws Exception {
		
		logpage.logout();
		
	}
	
	@Test(testName = "LogInvalid Test",priority = 2)
	public void invalidLogin() throws Exception {
		// check invalid login
		logpage.invalidlogin();
		//logpage.logout();
		
	}

}
