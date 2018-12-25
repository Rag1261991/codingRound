package com.cleartrip.tests;
import com.cleartrip.pages.HomePage;
import com.cleartrip.util.BaseClass;
import com.cleartrip.util.CommonMethods;
import com.sun.javafx.PlatformUtil;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HotelBookingTest extends BaseClass {
	
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
    public void shouldBeAbleToSearchForHotels() throws IOException {
    	logger = extent.createTest("shouldBeAbleToSearchForHotels");
        Assert.assertTrue(cm.clickOn(hp.hotelLink, logger), "Not able to click element");
        Assert.assertTrue(cm.enterTextInTextbox(hp.localityTextBox, logger, "Indiranagar, Bangalore"), "Not able to enter text");
        Assert.assertTrue(cm.waitFor(2000, logger), "Not able to wait for element");
        Assert.assertTrue(cm.pressEnter(logger), "Not able to press escape");
        Assert.assertTrue(cm.clickOn(hp.datepicker, logger), "Not able to click element");
        Assert.assertTrue(cm.clickOn(hp.checkInDate, logger), "Not able to click element");
        Assert.assertTrue(cm.clickOn(hp.checkOutDate, logger), "Not able to click element");
        Assert.assertTrue(cm.selectFromVisibleText(hp.travellerSelection, logger, "1 room, 2 adults"), "Not able to select element");
        Assert.assertTrue(cm.clickOn(hp.searchButton, logger), "Not able to click element");
    }
    
    @AfterTest
	public void teardown(){
        extent.flush();
        driver.quit();
	}
}
