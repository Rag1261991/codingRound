package com.util;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.javafx.PlatformUtil;

public class BaseClass {
	public WebDriver driver;

	public void startBrowser()
	{
		try
		{
			driver = new ChromeDriver();
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
