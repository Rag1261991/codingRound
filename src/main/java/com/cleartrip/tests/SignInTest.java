package com.cleartrip.tests;
import com.cleartrip.pages.HomePage;
import com.cleartrip.util.BaseClass;
import com.cleartrip.util.CommonMethods;
import com.sun.javafx.PlatformUtil;

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
		reportConfig();
		hp = new HomePage(driver);
		cm = new CommonMethods(driver);
	}
	
	@Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
		logger = extent.createTest("shouldThrowAnErrorIfSignInDetailsAreMissing");
        cm.clickOn(hp.yourTrips, logger);
        cm.clickOn(hp.SignIn, logger);
   		cm.waitForIFrameAdSwitch(hp.iFrame);
        cm.clickOn(hp.signInButton, logger);
        cm.waitTillElementIsVisible(hp.signinErrorMessage);
        String errors1 = hp.signinErrorMessage.getText();
        System.out.println(errors1);
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        extent.flush();
        driver.quit();
    }

    
}
