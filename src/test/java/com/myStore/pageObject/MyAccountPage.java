package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	WebDriver ldriver;
	
	// Create constructor 
	
	public MyAccountPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	// Identifying WebElements 
	
	@FindBy(id="email_create")
	WebElement createEmailAddress;
	
	@FindBy(id="SubmitCreate")
	WebElement submitCreate;
	
	// Now for Login Test Case Identify WebElements
	
	@FindBy(id="email")
	WebElement enterAlreadyRegisteredEmailAddress;
	
	@FindBy(id="passwd")
	WebElement enterAlreadyRegisteredPass;
	
	@FindBy(id="SubmitLogin")
	WebElement signIn;
	
	
	// Actions of WeBElements 
	
	public void EnterEmailAddress(String emailAddress) {
		createEmailAddress.clear();
		createEmailAddress.sendKeys(emailAddress);
		// After Entring it will clear email 
		
	}
	
	public void clickOnSubmitCreate() {
		submitCreate.click();
	}

	// Now for Login Test Case Actions
	
	public void enterAlreadyRegisteredEmail(String aREmail) {
		
		enterAlreadyRegisteredEmailAddress.sendKeys(aREmail);
		
	}
	
    public void enterAlreadyRegisteredPassword(String aRPwd) {
		
    	enterAlreadyRegisteredPass.sendKeys(aRPwd);
		
	}
    
    public void clickOnSignButton() {
    	
    	signIn.click();
    }
	
}
