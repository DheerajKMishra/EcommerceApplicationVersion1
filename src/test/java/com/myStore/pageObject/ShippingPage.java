package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {
	
	WebDriver ldriver;
	
	public ShippingPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	// Identifying WebElement 
	
	@FindBy(id="cgv")
	WebElement alertCheckBox;
	
	@FindBy(name="processCarrier")
	WebElement procedToCheckOut;
	
	public void clickOnCheckbox() {
		
		alertCheckBox.click();
	}
	
	public void clickOnProceedToCheckout() {
		procedToCheckOut.click();
	}
	
	

}
