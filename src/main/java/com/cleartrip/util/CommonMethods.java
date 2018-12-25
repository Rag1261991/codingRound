package com.cleartrip.util;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class CommonMethods {
	
	private WebDriver driver;

	public CommonMethods(WebDriver driver){
		this.driver=driver;
	}

	public boolean waitFor(int durationInMilliSeconds, ExtentTest logger) throws IOException {
        try {
            Thread.sleep(durationInMilliSeconds);
            logger.log(Status.PASS,"wait for "+durationInMilliSeconds);
        } catch (InterruptedException e) {
        	logger.fail(e.toString(), MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
        	return false;
        }
        return true;
    }
	
	public boolean clickOn(WebElement we, ExtentTest logger) throws IOException{
        try {
        	WebDriverWait wait=new WebDriverWait(driver,20);
        	wait.until(ExpectedConditions.elementToBeClickable(we));
        	logger.log(Status.PASS,"Clicking :"+we.getText()+" element");
        	we.click();
      } catch (Exception e) {
    	    logger.fail(e.toString(), MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
    	    return false;
      }	
        return true;
	}

	public boolean enterTextInTextbox(WebElement we, ExtentTest logger,String text) throws IOException{
        try {
        	WebDriverWait wait=new WebDriverWait(driver,20);
        	wait.until(ExpectedConditions.visibilityOf(we)).sendKeys(text);
        	logger.log(Status.PASS,text+" :text is entered");
      } catch (Exception e) {
    	    logger.fail(e.toString(), MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
    	    return false;
      }		
        return true;
	}
	
	public boolean selectFromVisibleText(WebElement we, ExtentTest logger,String text) throws IOException{
        try {
        	WebDriverWait wait=new WebDriverWait(driver,20);
        	wait.until(ExpectedConditions.visibilityOf(we));
        	Select sel = new Select(we);
        	sel.selectByVisibleText(text);
        	logger.log(Status.PASS,text+" :text is Selected");
      } catch (Exception e) {
    	    logger.fail(e.toString(), MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
    	    return false;
      }		
        return true;
	}
	
	public boolean pressEnter(ExtentTest logger) throws IOException{
		try{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			logger.log(Status.PASS," Enter is Pressed");
		}catch(Exception e){
			logger.fail(e.toString(), MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
    	    return false;
		}
		return true;
	}
	public boolean waitForIFrameAdSwitch(WebElement we, ExtentTest logger) throws IOException{			
        try {
        	WebDriverWait wait=new WebDriverWait(driver,20);
    		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(we));
    		logger.log(Status.PASS,"Switched to frame:");
      } catch (Exception e) {
    	  logger.fail(e.toString(), MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
    	  return false;
      }	
        return true;
	}

	public boolean waitTillElementIsVisible(WebElement we, ExtentTest logger) throws IOException{			
        try {
        	WebDriverWait wait=new WebDriverWait(driver,20);
    		wait.until(ExpectedConditions.visibilityOf(we));
    		logger.log(Status.PASS,"Element:"+we.getText()+" is visible");
      } catch (Exception e) {
    	  logger.fail(e.toString(), MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
    	  return false;
      }	
        return true;
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
