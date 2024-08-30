package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
	WebDriver ldriver;
	
	public PaymentPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// Identifying WebElements
	
	@FindBy(xpath="//a[@class=\"bankwire\"]")
	WebElement checkBookMode;
	
	@FindBy(xpath="//span[text()='I confirm my order']")
	WebElement confirmOrder;
	
	// Actions on Webelements 
	
	public void clickOnCheckBox() {
		checkBookMode.click();
	}
	
	public void clickOnConfirmOrder() {
		confirmOrder.click();
	}

}
