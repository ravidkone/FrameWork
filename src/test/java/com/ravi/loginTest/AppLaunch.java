package com.ravi.loginTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.ravi.utilities.TestBase;

public class AppLaunch extends TestBase{
	
	@Test
	public void lauchMobileApp(){
		System.out.println("lauched app");
		driverMob.findElement(By.id("registered")).click();
		
	}

}
