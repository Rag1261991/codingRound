package com.cleartrip.util;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import com.sun.javafx.PlatformUtil;

public class BaseClass {
	public WebDriver driver;

	public void startBrowser()
	{
		try
		{
			driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, true);
			driver.manage().window().maximize();
			driver.get("https://www.cleartrip.com/");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("restriction")
	public void setDriverPath() {
        if (PlatformUtil.isMac()) {
        	System.out.println("MAC");
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
        	 System.out.println("Windows");
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
}