package com.ravi.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserUtilities extends TestBase{

	Logger log=Logger.getLogger(BrowserUtilities.class);
	
	@BeforeClass
	public void launchBrowser(String browser) throws Exception {
		log.info("Launching "+browser+" browser");
		
		// Check if parameter passed from TestNG is 'firefox'/chrome
		if (browser.equalsIgnoreCase(System.getProperty("Browser"))) {
			//Chrome options class is used to manipulate various properties of Chrome driver.	
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions=new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			
		// Create Chrome instance
			driver=new ChromeDriver(chromeOptions);
		} else if(browser.equalsIgnoreCase(System.getProperty("Browser"))) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
			
	}
	
	public boolean isDisplayed(WebElement ele) {
		boolean bRes_flag = false;
		try {
			if (ele.isDisplayed()) {
				bRes_flag = true;
			}
		} catch (Exception e) {
		}

		return bRes_flag;
	}

	public boolean waitForElementVisible(WebDriver driver, WebElement ele, int iTimeInSeconds)
			throws InterruptedException {
		boolean bRes_flag = false;
		for (int i = 0; i < iTimeInSeconds; i++) {
			if (!isDisplayed(ele))
				Thread.sleep(1000);
			else
				break;
		}

		return bRes_flag;

	}
	

	
}
	
