package com.cleartrip.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class CommonMethods {
	
	private WebDriver driver;

	public CommonMethods(WebDriver driver){
		this.driver=driver;
	}

	public void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
	
	public void clickOn(WebElement we, ExtentTest logger){
        try {
        	WebDriverWait wait=new WebDriverWait(driver,20);
        	wait.until(ExpectedConditions.elementToBeClickable(we));
        	logger.log(Status.INFO,"Clicking :"+we.getText()+" element");
        	we.click();
      } catch (Exception e) {
    	    logger.log(Status.FAIL, e.toString());
      }		
	}

	public void waitForIFrameAdSwitch(WebElement we){			
        try {
        	WebDriverWait wait=new WebDriverWait(driver,20);
    		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(we));
      } catch (Exception e) {
            e.printStackTrace();
      }	
	}

	public void waitTillElementIsVisible(WebElement we){			
        try {
        	WebDriverWait wait=new WebDriverWait(driver,20);
    		wait.until(ExpectedConditions.visibilityOf(we));
      } catch (Exception e) {
            e.printStackTrace();
      }	
	}
}
