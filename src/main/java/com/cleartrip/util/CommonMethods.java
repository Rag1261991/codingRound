package com.cleartrip.util;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class CommonMethods {
	
	private WebDriver driver;

	public CommonMethods(WebDriver driver){
		this.driver=driver;
	}

	public void waitFor(int durationInMilliSeconds, ExtentTest logger) throws IOException {
        try {
            Thread.sleep(durationInMilliSeconds);
            logger.log(Status.PASS,"wait for "+durationInMilliSeconds);
        } catch (InterruptedException e) {
        	logger.fail(e.toString(), MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
        }
    }
	
	public void clickOn(WebElement we, ExtentTest logger) throws IOException{
        try {
        	WebDriverWait wait=new WebDriverWait(driver,20);
        	wait.until(ExpectedConditions.elementToBeClickable(we));
        	logger.log(Status.PASS,"Clicking :"+we.getText()+" element");
        	we.click();
      } catch (Exception e) {
    	    logger.fail(e.toString(), MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
      }		
	}

	public void waitForIFrameAdSwitch(WebElement we, ExtentTest logger) throws IOException{			
        try {
        	WebDriverWait wait=new WebDriverWait(driver,20);
    		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(we));
    		logger.log(Status.PASS,"Switched to frame:");
      } catch (Exception e) {
    	  logger.fail(e.toString(), MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
      }	
	}

	public void waitTillElementIsVisible(WebElement we, ExtentTest logger) throws IOException{			
        try {
        	WebDriverWait wait=new WebDriverWait(driver,20);
    		wait.until(ExpectedConditions.visibilityOf(we));
    		logger.log(Status.PASS,"Element:"+we.getText()+" is visible");
      } catch (Exception e) {
    	  logger.fail(e.toString(), MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
      }	
	}
	
	public String getScreenshot(){
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try{
			FileHandler.copy(src, destination);
		}catch(IOException e){
			e.printStackTrace();
		}
		return path;
	}
}
