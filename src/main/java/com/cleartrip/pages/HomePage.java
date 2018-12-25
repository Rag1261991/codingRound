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
	
	@FindBy(id="modal_window")
	public WebElement iFrame;
	
	//Hotel Booking
    @FindBy(linkText = "Hotels")
    public WebElement hotelLink;

    @FindBy(id = "Tags")
    public WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    public WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    public WebElement travellerSelection;

    @FindBy(xpath = "//a[@class='ui-state-default ui-state-highlight ui-state-active ']")
    public WebElement checkInDate; 
    
    @FindBy(xpath = "//a[@class='ui-state-default ui-state-active ']")
    public WebElement checkOutDate; 
    
    @FindBy(xpath = "//i[@class='calendarIcon datePicker']")
    public WebElement datepicker; 
    
    //Flight
    @FindBy(id = "OneWay")
    public WebElement oneWay;

    @FindBy(id = "FromTag")
    public WebElement fromTag;

    @FindBy(id = "toTag")
    public WebElement toTag;

    @FindBy(id = "SearchBtn")
    public WebElement searchBtn;
    
    public HomePage(WebDriver driver){
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
