package com.ravi.pom.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ravi.utilities.TestBase;

public class LoginPage extends TestBase{
	
	public HomePage hm;
	public LoginPage(WebDriver driver) {
		TestBase.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyTitle() {
		System.out.println("Title Verified");
	}
	public void EnterCredentials() {
		System.out.println("enter username and password");
	}
	public void clickOnSubmit(){
		System.out.println("Clicked on Submit button");
	}
	public HomePage homepage() {
		return hm;
	}

}
