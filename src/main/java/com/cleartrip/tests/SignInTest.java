package com.cleartrip.tests;
import com.cleartrip.pages.HomePage;
import com.sun.javafx.PlatformUtil;
import com.util.BaseClass;
import com.util.CommonMethods;

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
	CommonMethods cm;
	@BeforeTest
	public void setup(){
		setDriverPath();
		startBrowser();
		hp = new HomePage(driver);
		cm = new CommonMethods(driver);
	}
	
	@Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
        cm.clickOn(hp.yourTrips);
        cm.clickOn(hp.SignIn);
   		cm.waitForIFrameAdSwitch(hp.iFrame);
        cm.clickOn(hp.signInButton);
        cm.waitTillElementIsVisible(hp.signinErrorMessage);
        String errors1 = hp.signinErrorMessage.getText();
        System.out.println(errors1);
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }

    
}
