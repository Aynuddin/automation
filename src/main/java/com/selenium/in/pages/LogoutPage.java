package com.selenium.in.pages;

import org.openqa.selenium.By;

import com.selenium.in.utils.ElementActionUtils;

public class LogoutPage {
	
	By logntfobtn = By.xpath("/html/body/div[1]/div[1]/div/header/div/div[3]/div[3]");
	By logoutbtn = By.xpath("/html/body/div[3]/div[3]/ul/li[2]");
	
	
	public void logout() {
		ElementActionUtils.getInstance().performAction("click", logntfobtn, null);
		ElementActionUtils.getInstance().performAction("wait", null, "3");
		ElementActionUtils.getInstance().performAction("click", logoutbtn, null);
	}
	
	

}
