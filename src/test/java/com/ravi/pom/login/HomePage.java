package com.ravi.pom.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ravi.utilities.TestBase;

public class HomePage extends TestBase{
	
	public HomePage(WebDriver driver) {
		TestBase.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHomeTitle() {
		System.out.println("Home Title Verified");
	}
	public void clickOnTask() {
		System.out.println("Clicked on Task");
	}
	public void taskPageDisplayed(){
		System.out.println("Navigated to task");
	}

}
