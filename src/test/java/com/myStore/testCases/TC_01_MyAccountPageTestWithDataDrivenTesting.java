package com.myStore.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.myStore.pageObject.AccountCreationPage;
import com.myStore.pageObject.IndexPage;
import com.myStore.pageObject.MyAccountPage;
import com.myStore.pageObject.RegisteredUserAccount;
import com.myStore.utilities.ReadExcelFile;

import junit.framework.Assert;

public class TC_01_MyAccountPageTestWithDataDrivenTesting extends BaseClass {
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
	
	
	//=====================================================================================================//
	//===================================================================================================//
	
	
	// We use here data provider to pass the test data 
		  @Test(dataProvider="LoginDataProvider")
		  
		  public void verifyLogin(String userEmail, String userPWD, String expectedUsername) throws IOException {
			/*  
			    
			  // open url
			  driver.get(url);
			  logger.info("url opened");
			  
			  */
			  
	       IndexPage pg = new IndexPage(driver);
			  
			  pg.clickOnSignIn();
			  logger.info("clicked on signIn link");
			  // Enter an Email address in create an Account 
			  
			  MyAccountPage map= new MyAccountPage(driver);
			  
			 // map.enterRegisteredCusEmailAddress("dheerajmishramfp@gmail.com"); HardCorded value
			  map.enterAlreadyRegisteredEmail(userEmail);
			  
			  logger.info("Entered Registerd email ");
			  map.enterAlreadyRegisteredPassword(userPWD);
			  logger.info("Entered Registerd Password ");
			  map.clickOnSignButton();
			  logger.info("clicked on SignIn Button ");
			  
			  // for Verification 
			  RegisteredUserAccount rua= new RegisteredUserAccount(driver);
//			  
		      String userName = rua.getUserAccountText();
//			  
			//  Assert.assertEquals("Dheeraj Mishra", userName);
//			  Assert.assertEquals("Dheeraj Raj", userName);
		      
		     // if(userName.equals("Dheeraj Mishra123")) {
		      
		      if(userName.equals(expectedUsername)) {
		    	  
			  logger.info("Verify Login:: Passed");
			  Assert.assertTrue(true);
			  
			  // Sign Out Action 
			  
			  rua.clickOnsignOut();
			  logger.info("Successfully Sign Out done ");
			  
			  
		      }
		      else {
		    	  
		    	  logger.info("Verify Login:: failed");
		    	// To Capture ScreenShot when failed
				 // captureScreenShot(driver, "verifyLogin");
		    	  captureScreenShot(driver, "verifyLogin");
		    	  Assert.assertTrue(false);
		      }
			  
			  
		  }
		  
		  @DataProvider(name="LoginDataProvider")
		  public String [][] LoginDataProvider(){
			  
			//System.out.println(System.getProperty("user.dir"));
				String fileName = System.getProperty("user.dir") + "\\TestData\\LoginTestData.xlsx";
			 // String fileName = System.getProperty("D:\\Automation Testing Projects( E_Commerce Store)\\MyStoreV1\\TestData\\LoginTestData.xlsx");


				int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
				int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
			

				String data[][]=new String[ttlRows-1][ttlColumns];

				for(int i=1;i<ttlRows;i++)//rows =1,2
				{
					for(int j=0;j<ttlColumns;j++)//col=0, 1,2
					{

						data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
					}

				}
				return data;
			}
		  }
		
		


