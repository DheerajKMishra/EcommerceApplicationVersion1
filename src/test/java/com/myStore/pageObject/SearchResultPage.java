package com.myStore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import groovyjarjarantlr4.v4.codegen.model.Action;

public class SearchResultPage {
	WebDriver ldriver;
	
	public SearchResultPage(WebDriver rdriver){
	
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}



// IDENTIFYING WEBELEMENTS 

   @FindBy(xpath="/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/h5/a")
   WebElement searchResultProduct;
   
   @FindBy(linkText="More")
   //@FindBy(xpath="//a[@class=\"button lnk_view btn btn-default\"]")
   WebElement moreLink;
   
          
   public String getSearchResultProductText() {
	   
	   String text = searchResultProduct.getText();
	  //return searchResultProduct.getText();
	   
	   return text;
   }
   
   public void clickOnMoreLink() {
//	   Actions act = new Actions(ldriver);
//	   act.click(moreLink);
//	   act.build().perform();
	   
	   moreLink.click();
   }
   
}