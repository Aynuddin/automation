package com.selenium.in.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.selenium.in.actiondriver.DriverFactory;

public class LocateElementUtils {
	
	private FluentWait<WebDriver> fluentWait;
	private static LocateElementUtils locateElementUtils;
	
	public static LocateElementUtils getInstance() {
		if (locateElementUtils == null) {
			locateElementUtils = new LocateElementUtils();
		}
		return locateElementUtils;
	}
	
	public WebElement findElement(By by) {

		fluentWait = new FluentWait<>(DriverFactory.getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		return fluentWait.until(driver -> driver.findElement(by));
	}
	
	public List<WebElement> findElements(By by) {

		fluentWait = new FluentWait<>(DriverFactory.getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		return fluentWait.until(driver -> driver.findElements(by));
	}

}
