package com.ravi.utilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileUtilities{	
	
	public void launchMobileApp() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities dcap=new DesiredCapabilities();
		dcap.setCapability("platformName", "Android");
		dcap.setCapability("deviceName", "2d3bbb1c");
		dcap.setCapability("appPackage", System.getProperty("packageName"));
		dcap.setCapability("appActivity", System.getProperty("appActivity"));
		dcap.setCapability("automationName", "UiAutomator2");
		dcap.setCapability("noReset", "true");
		dcap.setCapability(MobileCapabilityType.APP,new File(System.getProperty("user.dir") + "/apk/app-staging.apk").getAbsolutePath());

		TestBase.driverMob=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dcap);

		System.out.println("App launched");
		Thread.sleep(10000);
	}

}
