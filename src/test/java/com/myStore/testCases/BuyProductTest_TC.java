package com.myStore.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//import javax.naming.directory.SearchResult;

import org.testng.annotations.Test;

import com.myStore.pageObject.AddressPage;
import com.myStore.pageObject.IndexPage;
import com.myStore.pageObject.MyAccountPage;
import com.myStore.pageObject.OrderSummaryPage;
import com.myStore.pageObject.PaymentPage;
import com.myStore.pageObject.ProductPage;
import com.myStore.pageObject.RegisteredUserAccount;
import com.myStore.pageObject.SearchResultPage;
import com.myStore.pageObject.ShippingPage;

public class BuyProductTest_TC extends BaseClass {
	
	
	@Test
	public void buyProduct() {
		
		// login to webSite
		logger.info("=== Test Execution Started ============");
		IndexPage ip = new IndexPage(driver);
		// Click On SignIn link
		ip.clickOnSignIn();
		logger.info("clicked on SignIn button");
		
		// Login 
		MyAccountPage map= new MyAccountPage(driver);
		//map.enterAlreadyRegisteredEmail("dheerajmishramfp@gmail.com");
		map.enterAlreadyRegisteredEmail(userName);
		logger.info("Entered Registered Email");
		//map.enterAlreadyRegisteredPassword("Dheeraj123@");
		map.enterAlreadyRegisteredPassword(password);
		logger.info("Entered Registered Password");
		map.clickOnSignButton();
		logger.info("clicked on SignIn button");
		
		// 
		
		RegisteredUserAccount rua = new RegisteredUserAccount(driver);
		rua.enterTextInSearchButton("Blouse");
		logger.info("Entered TextBox key ");
		rua.clickOnSubmitSearchButton();
		logger.info("clicked on submit Search Button");
		
		// 
		SearchResultPage srp = new SearchResultPage(driver);
		
		// =============== Not Possible to click on MoreLink ====   
		// =========== First will Scroll the page ====
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000);");
        logger.info("Performed Scroll Down Operation");
		
		 WebElement elementToScrollTo = driver.findElement(By.linkText("Blouse"));
	     js.executeScript("arguments[0].scrollIntoView(true);", elementToScrollTo);
	     
	     // ===== Perform Mouse over Action to Click On More Link=======
	     
	     Actions act1 = new Actions(driver);
	        act1.moveByOffset(590, 145);
	        act1.click().perform();
	        logger.info(" Performed Mouse Over Action On More Link");
		
//		srp.clickOnMoreLink();
//		logger.info("clicked on more Link");
//		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
		
		//
		ProductPage pg = new ProductPage(driver);
		
//		pg.enterQuantity("2");
//		logger.info("Entered Quantity");
		pg.selectSize("L");
		logger.info("Entered Product Size");
		pg.selectColor();
		logger.info("Color selected ");
		pg.enterQuantity("2");
		logger.info("Entered Quantity");
		pg.clickOnAddToCartButton();
		logger.info("Clicked on AddToCart ");
		pg.clickOnProceedToCheckoutButton();
		logger.info("Clicked on ProceedToCheckout Button");
		
		// To Further Process Towards checkOut
		
		OrderSummaryPage osp = new OrderSummaryPage(driver);
		osp.clickOnProceedToCheckout();
		logger.info("Clicked of Proceed Link");
		
		// To fill Address Information On The Page 
		AddressPage ap = new AddressPage(driver);
//		ap.enterFirstName("Dheeraj K");    // united states
//		logger.info("Entered First Name ");
//		ap.enterLastName("Mishra");
//		logger.info("Entered Last Name ");
//		ap.enterCompanyName("3i Infotech");
//		logger.info("Entered company Name ");
//		ap.enterAddress1("R Block,Janakpuri");
//		logger.info("Entered Address1 ");
//		ap.enterAddress2("Delhi");
//		logger.info("Entered Address2 ");
//		ap.enterCityName("Delhi");
//		logger.info("Entered City Name ");
//		ap.selectState("Florida");
//		logger.info("Selected State");
//		ap.enterPincode("00000");
//		logger.info("Entered Pincode ");
//		
//		ap.selectCountryName("United States");
//		logger.info("Selected Country ");
//		
//		ap.enterHomePhonenumber("8076438804");
//		logger.info("Entered Home Mobile Number");
//		ap.enterMobileNumber("9973222890");
//		logger.info("Entered Mobile Number ");
//		ap.enterAdditionalInformation("None");
//		logger.info("Entered Additional Information");
//		ap.enterAddressTitleForFuture("APna Ghar Kaa Address");
//		logger.info("Entered Title for FR ");
//		
//		ap.clickOnSaveButton();
//		logger.info("Clicked on Save Button ");
		
		// Now Clicked On Proceed to checkOut Button
		ap.clickOnProceedToCheckout();
		logger.info("Clicked on ProceedToCheckOut");
		
		// To Click on Shipping Page 
		
		ShippingPage sp = new ShippingPage(driver);
		sp.clickOnCheckbox();
		logger.info("Clicked on CheckBox ");
		sp.clickOnProceedToCheckout();
		logger.info("Clicked on Proceed To CheckOut ");
		
		// Perform Operation on Payment page
		
		PaymentPage pp= new PaymentPage(driver);
		pp.clickOnCheckBox();
		logger.info("Clicked on checkbox ");
		pp.clickOnConfirmOrder();
		logger.info(" Clicked On order Confirm ");
		
		
		
	}

}
