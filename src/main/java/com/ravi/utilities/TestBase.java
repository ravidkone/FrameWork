package com.ravi.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.ravi.listeners.ExtentManager;

import io.appium.java_client.AppiumDriver;

@Listeners(com.ravi.listeners.TestListener.class)
public class TestBase {
	
	public static MobileUtilities oMobUtil=new MobileUtilities();
	public static CommonUtilities oCommonUtil=new CommonUtilities();
	public static BrowserUtilities oBrowser=new BrowserUtilities();
	public static ExtentManager oExt = new ExtentManager();
	public static RestUtilities oResUtil = new RestUtilities();
	public static WebDriver driver;
	public static AppiumDriver<WebElement> driverMob=null;

	public static String sClassNameForScreenShot;
	public static String sHost;


	Logger log=Logger.getLogger(getClass().getSimpleName());
	
	@BeforeSuite
	public void TriggerDependencies() throws Exception {
		
		oCommonUtil.LoadConfigPropertyFile(System.getProperty("user.dir")+"/src/main/java/com/ravi/properties/config.properties");
		oCommonUtil.LoadConfigPropertyFile(System.getProperty("user.dir")+"/src/main/java/com/ravi/properties/TestData.properties");
		oCommonUtil.loadLog4jPropertyFile(System.getProperty("user.dir")+"/src/main/java/com/ravi/properties/TestData.properties");
		

		if(System.getProperty("AutomationRunning").equalsIgnoreCase(Constants.sAutomationWeb)) {
			oBrowser.launchBrowser(System.getProperty("Browser"));
			
			log.info("Automation running on: "+System.getProperty("AutomationRunning"));
			log.info("Environment is: "+System.getProperty("Environment"));
		}
		if(System.getProperty("AutomationRunning").equalsIgnoreCase(Constants.sAutomationAPI)) {
			if(System.getProperty("Environment").equalsIgnoreCase("staging")) {
				sHost=System.getProperty("StageHost");
			}else
				throw new Exception("Environment is not found OR Give the RIGHT Environment");
			System.out.println(sHost);
		}
		if(System.getProperty("AutomationRunning").equalsIgnoreCase(Constants.sAutomationAPP)) {
			oMobUtil.launchMobileApp();

		}
	}
	
	
	@AfterSuite
	public void shuttingDownAllDependancy() throws Exception{
		if(System.getProperty("AutomationRunning").equalsIgnoreCase(Constants.sAutomationWeb.toLowerCase())){
		driver.quit();
		log.info("Browser Closed");
		}
	}

}
