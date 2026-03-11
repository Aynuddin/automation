package com.selenium.in.actiondriver;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ActionDriver {
	
	public static ActionDriver actionDriver;
	
	public static ActionDriver getInstance() {
		if (actionDriver == null) {
			actionDriver = new ActionDriver();
		}
		return actionDriver;
	}
	
	//click,entervalue,gettext,textcompare
	/**
	 * click method
	 * @param element
	 */
	public void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("Unable to click :" + e.getMessage());
		}
	}
	/**
	 * enter value
	 * @param element
	 * @param value
	 */
	public void enterValue(WebElement element,String value) {
		try {
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Unable to enter value :" + e.getMessage());
		}
	}
	/**
	 * get text
	 * @param element
	 * @return
	 */
	public String getText(WebElement element) {
		try {		
			return element.getText();
		} catch (Exception e) {
			System.out.println("Unable to enter value :" + e.getMessage());
			return null;
		}
	}
	
	public boolean compareText(WebElement element,String text) {
		try {
			if(element.getText().equals(text))
			return true;
		} catch (Exception e) {
			System.out.println("value is diff :" + element.getText()+"AND"+text );
			return false;
		}
		return false;
	}
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public void waitAction(String time) {
		try {
			Thread.sleep(Duration.ofSeconds(Integer.parseInt(time)));
		} catch (InterruptedException e) {
			System.out.println("Failed to wait :"+e.getMessage());
		}
	}
	

}
