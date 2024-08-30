package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
	
	WebDriver ldriver;
	
	public AddressPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	// Identifying Webelements
	
	@FindBy(id="firstname") // clear stmt
	WebElement firstName;
	
	@FindBy(id="lastname") // clear stmt
	WebElement lastName;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="address2")
	WebElement address2;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement state;         // Select class
	
	@FindBy(id="postcode")
	WebElement pincode;
	
	@FindBy(id="id_country")
	WebElement country;     // Select class
	
	@FindBy(id="phone")
	WebElement homePhoneNumber;
	
	@FindBy(id="phone_mobile")
	WebElement mobileNumber;
	
	@FindBy(id="other")
	WebElement additionalInformation;
	
	@FindBy(id="alias")
	WebElement addressTittleForFuture; // clear stmt
	
	@FindBy(id="submitAddress")
	WebElement saveButton;
	
	
	// To Click On Proceed to checkout
	@FindBy(name="processAddress")
	WebElement proceedToCheckout;
	
	
	
	// ===================   Actions of Identifying webElements ====================///
	
	public void enterFirstName(String fName) {
		firstName.clear();
		firstName.sendKeys(fName);
		}
	
	public void enterLastName(String lName) {
		lastName.clear();
		lastName.sendKeys(lName);
		}
	
	public void enterCompanyName(String cName) {
		company.sendKeys(cName);
		}
	
	public void enterAddress1(String add1) {
		address1.sendKeys(add1);
		}
	
	public void enterAddress2(String add2) {
		address2.sendKeys(add2);
		}
	
	public void enterCityName(String cty) {
		city.sendKeys(cty);
		}
	
	public void selectState(String sName) {
		Select sc = new Select(state);
		sc.selectByVisibleText(sName);
		}
	public void enterPincode(String pnCode) {
		
		pincode.sendKeys(pnCode);
	}
	
	public void selectCountryName(String ctyName) {
		
		Select sc1 = new Select(country);
		sc1.selectByVisibleText(ctyName);
		}
	public void enterHomePhonenumber(String hpn) {
		homePhoneNumber.sendKeys(hpn);
		}
	
	public void enterMobileNumber(String mn) {
		mobileNumber.sendKeys(mn);
		}
	
	public void enterAdditionalInformation(String ai) {
		additionalInformation.sendKeys(ai);
		}
	
	
	public void enterAddressTitleForFuture(String at) {
		addressTittleForFuture.sendKeys(at);
		}
	
	public void clickOnSaveButton() {
		saveButton.click();
		}
	
	
	public void clickOnProceedToCheckout() {
		
		proceedToCheckout.click();
	}
	
	
	
	
	
	
	

}
