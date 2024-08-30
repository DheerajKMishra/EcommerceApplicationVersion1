package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
	
	WebDriver ldriver;
	
	public OrderSummaryPage(WebDriver rdriver ) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// Identifying The WebElements 
	@FindBy(xpath="//a[@class=\"button btn btn-default standard-checkout button-medium\"]")
	WebElement proceedToCheckOut;
	
	// Actions on Webelement
	
	public void clickOnProceedToCheckout() {
		proceedToCheckOut.click();
		
	}
	
	

}
