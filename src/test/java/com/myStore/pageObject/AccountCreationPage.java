package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage {
	WebDriver ldriver;

	// Constructor
	public AccountCreationPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	// identifying WebElements 
	
	@FindBy(id="uniform-id_gender1")
	WebElement title;
	
	@FindBy(name="customer_firstname")
	WebElement firstName;
	
	@FindBy(name="customer_lastname")
	WebElement lastName;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="uniform-newsletter")
	WebElement signUpCheckBox;
	
	@FindBy(id="submitAccount")
	WebElement registerButton;
	
	// DropDown for Date of Birth
	
	@FindBy(id="days")
	WebElement birthDate;
	
	@FindBy(id="months")
	WebElement birthMonths;
	
	@FindBy(id="years")
	WebElement birthYear;
	
	// Actions on Identifying WebElemnts 
	
	public void selectTitle() {
		title.click();
	}
	
	public void enterFirstName(String fName) {
      firstName.sendKeys(fName);
}
	public void enterLastName(String lName) {
	      lastName.sendKeys(lName);
	}
	public void enterEmail(String emailId) {
		email.clear();
	      email.sendKeys(emailId);
	}
	public void enterPassword(String pwd) {
	      password.sendKeys(pwd);
	}
	public void tickOnSignUpCheckBox() {
		signUpCheckBox.click();
	}
	
	public void clickOnRegisterButton() {
		registerButton.click();
	}
	
	// For Birth Details 
	public void selectBirthDate(String bDate) {
		Select sc= new Select(birthDate);
		//sc.selectByValue("17");
		sc.selectByValue(bDate);
	}
	
	public void selectBirthMonth(String bMonth) {
		Select sc= new Select(birthMonths);
		sc.selectByValue(bMonth);
	}
	
	public void selectBirthYear(String bYear) {
		Select sc= new Select(birthYear);
		sc.selectByValue(bYear);
	}
	
	
}
