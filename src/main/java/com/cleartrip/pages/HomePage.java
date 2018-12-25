package com.cleartrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Home Page
	@FindBy(linkText="Your trips")
	public WebElement yourTrips;
	
	@FindBy(id="SignIn")
	public WebElement SignIn;
	
	//Signin window
	@FindBy(id="signInButton")
	public WebElement signInButton;
	
	@FindBy(id="errors1")
	public WebElement signinErrorMessage;
	
	public HomePage(WebDriver driver){
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
