package com.test.program;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class zaleniumTest {
	 RemoteWebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc=new DesiredCapabilities();

		if(browser.equalsIgnoreCase("chrome")) {
			dc.setCapability(CapabilityType.BROWSER_NAME,BrowserType.CHROME);
			dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC );
		}else if(browser.equalsIgnoreCase("firefox")) {
			dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
			dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
		}
		
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc);
		driver.get("https://www.google.com");
		Thread.sleep(3000);
	}
	
	@Test
	public void test1() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("waiting");
	}
	
	
	
//	@Test
//	public void test1() throws MalformedURLException, InterruptedException {
//		DesiredCapabilities cap=new DesiredCapabilities();
//		cap.setBrowserName(BrowserType.FIREFOX);
//		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
//		driver.get("https://www.google.com");
//		Thread.sleep(3000);
//		System.out.println("title of the page is: "+driver.getTitle());
//		Thread.sleep(3000);
//		System.out.println("title of the page is: "+driver.getCurrentUrl());
//		Thread.sleep(3000);
//
//		driver.quit();
//
//	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		System.out.println("browser closed");
	}
	
	
}

