package com.myStore.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.myStore.pageObject.IndexPage;
import com.myStore.pageObject.MyAccountPage;
import com.myStore.pageObject.RegisteredUserAccount;
import com.myStore.pageObject.SearchResultPage;

import junit.framework.Assert;

public class SProductPageTest extends BaseClass {
	
	
	@Test
	public void verifySearchProduct() throws IOException {
		
		// Search Keybord 
		String searchKeyword="Blouse";
		logger.info("============= Test case Search product Started =================");
		// Click on SignIn link
		IndexPage ip= new IndexPage(driver);
		ip.clickOnSignIn();
		
		// For login 
		MyAccountPage mcp= new MyAccountPage(driver);
		
		//mcp.enterAlreadyRegisteredEmail("dheerajmishramfp@gmail.com");
		mcp.enterAlreadyRegisteredEmail(userName);
		logger.info("==Email Entered ==");
		//mcp.enterAlreadyRegisteredPassword("Dheeraj123@");
		mcp.enterAlreadyRegisteredPassword(password);
		logger.info("== Password  Entered ==");
		mcp.clickOnSignButton();
		
		logger.info("== Clicked On SignIn link ==");
		
		// ============ Enter and click search keyword in field===========
		RegisteredUserAccount rua = new RegisteredUserAccount(driver);
		rua.enterTextInSearchButton("Blouse");
		logger.info("Search Key(Item) entered ");
		rua.clickOnSubmitSearchButton();
		logger.info(" Clicked on searchButton ");
		
		
		// Verify that text is present in textBox or not
		
		SearchResultPage srp = new SearchResultPage(driver);
		String text = srp.getSearchResultProductText();
		System.out.println("Text:"+text);
		
		if(text.contains(searchKeyword)) {
			logger.info("VerifySearchProduct test case  :: Passed ");
			Assert.assertTrue(true);
			rua.clickOnsignOut();
		}else {
			logger.info("VerifySearchProduct test case  :: Failed ");
			
			captureScreenShot(driver, "verifySearchProduct");
			Assert.assertTrue(false);
		}
		
	}

}
