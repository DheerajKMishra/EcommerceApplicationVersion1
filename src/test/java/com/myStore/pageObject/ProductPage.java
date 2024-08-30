package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	
	WebDriver ldriver;
	
	public ProductPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// IDENTIFYING WEB ELEMENTS 
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(id="group_1")   // Select class
	WebElement size;
	
	@FindBy(name="White")
	WebElement color;
	
	@FindBy(name="Submit")
	WebElement addToCart;
	
	@FindBy(xpath="//a[@class='btn btn-default button button-medium']")
	WebElement proceddToCheckout;
	
	// Actions on WebElements 
	
	public void enterQuantity(String qty) {
		
		quantity.sendKeys(qty);
		
	}
	
   public void selectSize(String sizee) {
		
		Select sc = new Select(size);
		sc.selectByVisibleText(sizee);
		
	}
   public void selectColor() {
	   color.click();
   }
   
   public void clickOnAddToCartButton() {
	   
	   addToCart.click();
   }
   
   public void clickOnProceedToCheckoutButton() {
	   
	   proceddToCheckout.click();
   }

}
