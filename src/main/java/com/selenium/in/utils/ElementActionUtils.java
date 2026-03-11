package com.selenium.in.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.in.actiondriver.ActionDriver;
import com.selenium.in.reports.ExtentManager;

public class ElementActionUtils {
	
	private static ElementActionUtils elementActionUtils;
	public static ElementActionUtils getInstance() {
		if(elementActionUtils == null) {
			elementActionUtils = new ElementActionUtils();
		}
		return elementActionUtils;
	}
	
	List<String> nonElementActions = List.of("wait","screenshot");
	
	public void performAction(String action,By locator,String data) {
		
		WebElement ele = null;
		if (!nonElementActions.contains(action)) {
			try {
				ele = LocateElementUtils.getInstance().findElement(locator);
				ExtentManager.logStepSucess("Successfully locate the element");
			} catch (Exception e) {
				ExtentManager.logStepFailure("Unable to locate the element on this locator", "Failed locate element");
			}
		}
		
		if(ele != null) {
			
			try {
				switch (action) {
				case "input":
					ActionDriver.getInstance().enterValue(ele, data);
					//ExtentManager.logStepSucess("Value entered successfully");
					break;
				case "click":
					ActionDriver.getInstance().click(ele);
					//ExtentManager.logStepSucess("Click action successfully performed");
					break;
				case "getValue" :
					ActionDriver.getInstance().getText(ele);
					//ExtentManager.logStepSucess("Value captured successfully");
					break;
				case "wait" :
					ActionDriver.getInstance().waitAction(data);
					//ExtentManager.logStepSucess("Waited successfully for the specific timeout");
				default:
					break;
				}
			} catch (Exception e) {
				//ExtentManager.logStepFailure("Action failed to perform :"+locator, "PageEleScreenshot "+action);
			}
		}else {
			System.out.println("Element not found");
		}
		
	}

}
