package com.myStore.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.myStore.pageObject.AccountCreationPage;
import com.myStore.pageObject.IndexPage;
import com.myStore.pageObject.MyAccountPage;
import com.myStore.pageObject.RegisteredUserAccount;

import junit.framework.Assert;

public class TC_01_MyAccountPageTest extends BaseClass {
	//	
	//	@Test(enabled=false)
	//	public void verifyUserRegistrationAndLogin() {
	//		
	//		// open url
	//		driver.get(url);
	//		logger.info("url Opened");
	//	
	//		// Create index page object for clickOn sign Link
	//		
	//		IndexPage pg = new IndexPage(driver);
	//		pg.clickOnSignIn();
	//		logger.info("clicked on SignIn");
	//		
	//		
	//		// Create an object of MyAccountPage
	//		MyAccountPage map= new MyAccountPage(driver);
	//		map.EnterEmailAddress("mishra@gmail.com");
	//		logger.info("Email Entered ");
	//		map.clickOnSubmitCreate();
	//		logger.info("clicked on submit create");
	//		
	//	}

	// Another Test Case for Details of this Page

	@Test(enabled=false)
	public void verifyUserRegistrationAndLogin() {

		//		// open url
		//    driver.get(url);
		//	logger.info("url Opened");

		// Create index page object for clickOn sign Link

		IndexPage pg = new IndexPage(driver);
		pg.clickOnSignIn();
		logger.info("clicked on SignIn");


		// Create an object of MyAccountPage
		MyAccountPage map= new MyAccountPage(driver);
		map.EnterEmailAddress("dkumar1@gmail.com");
		logger.info("Email Entered ");
		map.clickOnSubmitCreate();
		logger.info("clicked on submit create");

		// For Registration Page

		AccountCreationPage acp = new AccountCreationPage(driver);

		acp.enterFirstName("Dheeraj");
		logger.info("First Name Entered");
		acp.enterLastName("Mishra");
		logger.info("Last Name Entered");
		acp.enterEmail("dkumar1@gmail.com");
		//logger.info("Email Entered");
		acp.enterPassword("Dheeraj@123");
		logger.info("Password Entered");
		//		acp.selectBirthDate("17");
		//		logger.info("Birthdate  Entered");
		//		acp.selectBirthMonth("November");
		//		logger.info("Birth Month Entered");
		//		acp.selectBirthYear("2000");
		//		logger.info("Birth Year Entered");
		acp.selectTitle();
		logger.info("title Selected");
		acp.tickOnSignUpCheckBox();
		logger.info("Clicked on signUp Tik");
		acp.clickOnRegisterButton();
		logger.info("Clicked on Register Button");

		// To Validate user is created or Not 

		RegisteredUserAccount res = new RegisteredUserAccount(driver);

		String userName = res.getUserAccountText();
		// to validate 
		Assert.assertEquals("Dheeraj Mishra", userName);

	}
	@Test(enabled=true)
	public void verifyLogin() throws IOException {
		// for signIn Link we create indexpage object here
		
		IndexPage pg = new IndexPage(driver);
		pg.clickOnSignIn();
		logger.info("clicked on SignIn");
        // for Login we create myaccountpage object here 
		MyAccountPage mp= new MyAccountPage(driver);
		// Enter userName/Email
		mp.enterAlreadyRegisteredEmail("dkumar@gmail.com");
		logger.info("Entered Registered Email");
		mp.enterAlreadyRegisteredPassword("Dheeraj@123");
		logger.info("Entered Registered Password");
		mp.clickOnSignButton();
		logger.info("clicked on signIn");
		
		// Verify Logged in userName is visible on WebPage 
		RegisteredUserAccount rua = new RegisteredUserAccount(driver);
		String userName = rua.getUserAccountText();
		// for Verification 
//		Assert.assertEquals("Dheeraj Mishra", userName);
//		logger.info("Verified user, It is Available on Webpage");
		
		//if(userName.equals("Dheeraj Mishra123")) {
		if(userName.equals("Dheeraj Mishra")) {
			
			logger.info("Verify Login: Passed");
			// to capture ScreenShot of Verify Login
			//captureScreenShot(driver,"verifyLogin");
			//Assert.assertTrue(true);
			Assert.assertTrue(true);
			
		}else {
			logger.info("Verify Login:Failed");
			captureScreenShot(driver,"verifyLogin");
			Assert.assertTrue(false);
		}
//		
		// Now for SIGN OUT FROM WEBPAGE 
		rua.clickOnsignOut();
		logger.info("clicked on SignOut");
	}



}
