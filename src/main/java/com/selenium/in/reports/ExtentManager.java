package com.selenium.in.reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.selenium.in.actiondriver.DriverFactory;

public class ExtentManager {
	
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static Map<Long,WebDriver> driverMap = new HashMap<>();
	
	
	public static ExtentReports getReporter() {
		String path = System.getProperty("user.dir") + "/src/test/resources/ExtentReport/extent-reports.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setReportName("TenjinOnlineReport");
		spark.config().setDocumentTitle("Tenjin-TestCase");
		spark.config().setTheme(Theme.DARK);

		if (extent == null) {
			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
		// Adding system info
		extent.setSystemInfo("OS Name", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extent;
	}
	
	// create the start test method
	public static ExtentTest startTest(String testName) {
		ExtentTest extentTest = getReporter().createTest(testName);
		test.set(extentTest);
		return extentTest;
	}
	
	// create test end
	public static void endTest() {
		getReporter().flush();
	}
	
	// fetch the current thread test 
	public static ExtentTest getCurrentThreadTest() {
		return test.get();
	}
	
	// fetch the current thread test name
	public String getCurrentTestName() {
		ExtentTest currTest = getCurrentThreadTest();
		if(currTest != null) {
			return currTest.getModel().getName();
		}else {
			return "Test not found for this thread!";
		}
	}
	
	// log step method
	public static void logStep(String message) {
		getCurrentThreadTest().info(message);
	}
	
	// log for failure Test case with screenshot
	public static void logStepFailure(String message,String screenshotMessage) {
		getCurrentThreadTest().fail(message);
		// capture screenshot
		captureScreenshotMethod(screenshotMessage);
	}
	
	
	private static String captureScreenshotMethod(String screenshotName) {

	    String dateTime = new SimpleDateFormat("yy-MM-dd_HH-mm-ss").format(new Date());

	    String capturePath = System.getProperty("user.dir") +
	            "/src/test/resources/Screenshots/screenshots/" +
	            screenshotName + "_" + dateTime + ".png";

	    TakesScreenshot sc = (TakesScreenshot) DriverFactory.getDriver();

	    File scfile = sc.getScreenshotAs(OutputType.FILE);

	    try {
	        FileUtils.copyFile(scfile, new File(capturePath));
	    } catch (IOException e) {
	        System.out.println("Unable to copy the screenshot file");
	    }

	    return convertScreenshotToBase64(scfile);
	}
	
	// convert screenshot file to base64
	public static String convertScreenshotToBase64(File screenshotfile) {
		// read file content to byte array
		try {
			byte [] filecontent = FileUtils.readFileToByteArray(screenshotfile);
			return Base64.getEncoder().encodeToString(filecontent);
		} catch (IOException e) {
			return null;
		}
	}

	// log method for success test case
	public static void logStepSucess(String message) {
		getCurrentThreadTest().pass(message);
	}
	
	
	// register driver
	public static void registerDriver() {
		driverMap.put(Thread.currentThread().getId(), DriverFactory.getDriver());
	}
	
	

}
