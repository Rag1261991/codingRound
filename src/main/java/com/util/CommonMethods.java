package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
	
	public void clickOn(WebElement we){
        try {
        	WebDriverWait wait=new WebDriverWait(driver,20);
        	wait.until(ExpectedConditions.elementToBeClickable(we));
        	we.click();
      } catch (Exception e) {
            e.printStackTrace();
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
