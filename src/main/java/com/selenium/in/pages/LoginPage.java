package com.selenium.in.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.in.config.ConfigManager;
import com.selenium.in.utils.ElementActionUtils;


public class LoginPage {
	
//	public LoginPage (ElementActionUtils elementUtils) {
//		this.elementUtils = elementUtils;
//	}
	private By username = By.xpath("//input[@name='username']");
	private By password = By.xpath("//input[@name='password']");
	private By loginBtn = By.xpath("//button[@type='submit']");
//	public LoginPage() {
//		PageFactory.initElements(DriverFactory.getDriver(), this);
//	}
//	@FindBy(xpath="//input[@name='username']")
//	private WebElement usernameele;
//	@FindBy(xpath="//input[@name='password']")
//	private WebElement passwordele;
//	@FindBy(xpath="//button[@type='submit']")
//	private WebElement logBtn;
	
	public void login() {
		ElementActionUtils.getInstance().performAction("input",username, ConfigManager.getPropertyValue("username"));
		ElementActionUtils.getInstance().performAction("wait",null,"3");
		ElementActionUtils.getInstance().performAction("input",password, ConfigManager.getPropertyValue("password"));
		ElementActionUtils.getInstance().performAction("wait",null,"3");
		ElementActionUtils.getInstance().performAction("click",loginBtn,null);
		ElementActionUtils.getInstance().performAction("wait",null,"5");
	}
	
	public void invlaidlogin() {
		ElementActionUtils.getInstance().performAction("input",username, "Ayn");
		ElementActionUtils.getInstance().performAction("wait",null,"3");
		ElementActionUtils.getInstance().performAction("input",password, "123");
		ElementActionUtils.getInstance().performAction("wait",null,"3");
		ElementActionUtils.getInstance().performAction("click",loginBtn,null);
		ElementActionUtils.getInstance().performAction("wait",null,"5");
	}

}
