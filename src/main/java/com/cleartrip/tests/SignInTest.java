package com.cleartrip.tests;
import com.cleartrip.pages.HomePage;
import com.sun.javafx.PlatformUtil;
import com.util.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignInTest extends BaseClass{

	HomePage hp;
	
	@BeforeTest
	public void setup(){
		setDriverPath();
		startBrowser();
		hp = new HomePage(driver);
	}
	
	@Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        waitFor(2000);
        hp.yourTrips.click();
        hp.SignIn.click();
        waitFor(2000);
        WebDriverWait wait=new WebDriverWait(driver,20);
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(hp.iFrame));
        hp.signInButton.click();
        waitFor(500);
        String errors1 = hp.signinErrorMessage.getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
