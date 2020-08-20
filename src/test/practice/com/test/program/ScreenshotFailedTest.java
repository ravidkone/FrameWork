package com.test.program;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomeListner.class)
public class ScreenshotFailedTest extends Base{
	
	@BeforeMethod
	public void setUp() {
		initialization();
	}
	
	@Test
	public void takeScreenshot() {
		Assert.assertEquals(false, false);
	}
	@Test
	public void takeScreenshot1() {
		Assert.assertEquals(false, true);
	}
	@Test
	public void takeScreenshot2() {
		Assert.assertEquals(false, true);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
