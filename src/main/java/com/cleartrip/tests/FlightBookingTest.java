package com.cleartrip.tests;
import com.cleartrip.pages.HomePage;
import com.cleartrip.util.BaseClass;
import com.cleartrip.util.CommonMethods;
import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class FlightBookingTest  extends BaseClass{
	HomePage hp;
	CommonMethods cm;
	@BeforeTest
	public void setup(){
		setDriverPath();
		startBrowser();
		reportConfig("FlightBooking");
		hp = new HomePage(driver);
		cm = new CommonMethods(driver);
	}
	
    @Test
    public void testThatResultsAppearForAOneWayJourney() throws IOException {
    	logger = extent.createTest("testThatResultsAppearForAOneWayJourney");
    	Assert.assertTrue(cm.clickOn(hp.oneWay, logger), "Not able to click element");
    	Assert.assertTrue(cm.enterTextInTextbox(hp.fromTag, logger, "Bangalore"), "Not able to enter text");
        //wait for the auto complete options to appear for the origin
    	Assert.assertTrue(cm.waitFor(2000, logger), "Not able to wait for element");
        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        cm.waitTillElementsAreVisible(originOptions, logger);
        Assert.assertTrue(cm.clickOn(originOptions.get(0), logger), "Not able to click element");
        Assert.assertTrue(cm.enterTextInTextbox(hp.toTag, logger, "Delhi"), "Not able to enter text");
        //wait for the auto complete options to appear for the destination

        Assert.assertTrue(cm.waitFor(2000, logger), "Not able to wait for element");
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        cm.waitTillElementsAreVisible(destinationOptions, logger);
        Assert.assertTrue(cm.clickOn(destinationOptions.get(0), logger), "Not able to click element");

        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();

        //all fields filled in. Now click on search
        Assert.assertTrue(cm.clickOn(hp.searchBtn, logger), "Not able to click element");
        Assert.assertTrue(cm.waitFor(4000, logger), "Not able to wait for element");
        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(By.className("searchSummary")));
    }
    
    @AfterTest
	public void teardown(){
        extent.flush();
        driver.quit();
	}

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
