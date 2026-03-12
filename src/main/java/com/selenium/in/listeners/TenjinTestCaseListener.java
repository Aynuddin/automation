package com.selenium.in.listeners;

import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.selenium.in.reports.ExtentManager;

public class TenjinTestCaseListener implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		
		ExtentManager.logStep("Start execution_"+result.getName());
		
	}
	
	@Override
	public void onStart(ITestContext context) {
		ExtentManager.startTest("Start the Test Suite Execution");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentManager.logStepFailure("Failed to ExecuteTest", result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentManager.logStepSucess("Successfully executed test case "+result.getName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.endTest();
	}
	
	

}
