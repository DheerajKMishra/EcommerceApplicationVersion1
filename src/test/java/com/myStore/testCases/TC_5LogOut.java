package com.myStore.testCases;

import org.testng.annotations.Test;

import com.myStore.pageObject.IndexPage;
import com.myStore.pageObject.MyAccountPage;
import com.myStore.pageObject.RegisteredUserAccount;

import junit.framework.Assert;

public class TC_5LogOut extends BaseClass {
	
	String pTitle="Login - My Shop";
	@Test
	public void logOutOperation() {
	
		// Launch Browser
		// click on SignIn Link
		IndexPage ip = new IndexPage(driver);
		ip.clickOnSignIn();
		logger.info("Clicked on SignIn");
		// Perform Account Login Operation
		MyAccountPage map = new MyAccountPage(driver);
		//map.enterAlreadyRegisteredEmail("dheerajmishramfp@gmail.com");
		map.enterAlreadyRegisteredEmail(userName);
		logger.info("Entered Email");
		//map.enterAlreadyRegisteredPassword("Dheeraj123@");
		map.enterAlreadyRegisteredPassword(password);
		logger.info("Entered PassWord");
		map.clickOnSignButton();
		logger.info("Clicked on SignIn Link");
		String ttitle=driver.getTitle();
		System.out.println("Title Before SignOut:"+ttitle);
		
		// To Click On SignOut 
		RegisteredUserAccount rua = new RegisteredUserAccount(driver);
		rua.clickOnsignOut();
		logger.info("Clicked on SignOut Button");
		String title=driver.getTitle();
		System.out.println("Title After SignOut:"+title);
		
		// For Validation 
		
		Assert.assertEquals(pTitle, title);
		logger.info("LogOut Test case Passes::");
		
	}
	
	

}
