package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	WebDriver ldriver;
	
	public IndexPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// Identifying WebElements 
	
	@FindBy(linkText="Sign in")
	WebElement signIn;
	
	// Action on WebElement 
	
	public void clickOnSignIn() {
		
		signIn.click();
	}

}
