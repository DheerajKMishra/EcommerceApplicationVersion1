package com.myStore.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.myStore.utilities.ReadConfig;

public class BaseClass {
	
ReadConfig readConfig = new ReadConfig();
	
	//String url = readConfig.getBaseUrl();
	//String browser = readConfig.getBrowser();
String url= readConfig.getBaseUrl();
String browser = readConfig.getBrowser();

// To Read UserName and PassWord from Read config file
String userName=readConfig.getuserName();
String password=readConfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
    public void setup() {
    	
    	switch(browser.toLowerCase()) {
    	
    	case "chrome":
    		driver=new ChromeDriver();
    		break;
    		
    	case "msedge":
    		driver=new EdgeDriver();
    		break;
    		
    	case "firefox":
    		driver=new FirefoxDriver();
    		break;
    		
    	default:
    		driver=null;
    		break;
    	}
    	
    	// initialize wait 
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	// for maximize 
    	driver.manage().window().maximize();
    	// for logging 
    	logger=LogManager.getLogger("MyStoreVersion1");
    	
    	// Common for All The Test Cases
    	
    			driver.get(url);
    			logger.info("url Opened");
    	
    	
    }
	
	// To Capture ScreenShot Create a method here
	
	public void captureScreenShot(WebDriver driver,String testName ) throws IOException {
		
		// Convert Webdriver object to takescreenShot interface
		
		TakesScreenshot screenShot = ((TakesScreenshot)driver);
		// call get screenShotAS method to create image file
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		
		File des = new File(System.getProperty("user.dir") + "//ScreenShots//" + testName +  ".png");
		
		// Copy image file to destination
		
		FileUtils.copyFile(src, des);
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.close();
		driver.quit();
	}
}

