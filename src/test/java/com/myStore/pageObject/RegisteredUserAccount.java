package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {
	
	WebDriver ldriver;
	
	public RegisteredUserAccount(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	// IDENTIFYING WEBELEMENTS
	
	@FindBy(xpath="//a[@title=\"View my customer account\"]")
	WebElement userAccountName;
	
	@FindBy(xpath="//a[@class=\"logout\"]")
	WebElement signOut;
	
	// Identifying WebElements for Item Search 
	
	@FindBy(id="search_query_top")
	WebElement searchBox;
	
	@FindBy(name="submit_search")
	WebElement submitSearch;
	
	// Actions on WebElement
	
	public String getUserAccountText() {
		
		String userName= userAccountName.getText();
		return userName;
		
	}
	
	public void clickOnsignOut() {
		
		signOut.click();
	   }
	
	public void enterTextInSearchButton(String searchData) {
		
		searchBox.sendKeys(searchData);
		
	}
	
	public void clickOnSubmitSearchButton() {

		submitSearch.click();

	}

	
}
