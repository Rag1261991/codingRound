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
        cm.clickOn(hp.hotelLink, logger);
        cm.enterTextInTextbox(hp.localityTextBox, logger, "Indiranagar, Bangalore");
        cm.clickOn(hp.checkInDate, logger);
        cm.clickOn(hp.checkOutDate, logger);
        cm.selectFromVisibleText(hp.travellerSelection, logger, "1 room, 2 adults");
        cm.clickOn(hp.searchButton, logger);
    }
    
    @AfterTest
	public void teardown(){
        extent.flush();
        driver.quit();
	}
}
