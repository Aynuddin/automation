package com.selenium.in.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.in.actiondriver.DriverFactory;

public class WaitUtils {

	private WebDriverWait wait;

	public WaitUtils(WebDriverWait wait) {
		this.wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));

	}
	
	public void waitUntillElementClickable(By by) {
		 try {
			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			System.out.println("Element is not clickable: "+e.getMessage());
		}
	}

}
