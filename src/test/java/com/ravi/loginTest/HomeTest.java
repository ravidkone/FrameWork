package com.ravi.loginTest;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ravi.pom.login.HomePage;
import com.ravi.pom.login.LoginPage;
import com.ravi.utilities.TestBase;

public class HomeTest extends TestBase{
	
	HomePage hm;
	LoginPage ln;
	Logger log=Logger.getLogger(LoginTest.class);
	@BeforeMethod
	public void setup() {
		hm=new HomePage(driver);
		ln=new LoginPage(driver);
		ln.verifyTitle();
		ln.EnterCredentials();
		ln.clickOnSubmit();
		ln.homepage();
	}
	
	@Test
	public void navigateToTask() {
		hm.verifyHomeTitle();
		hm.clickOnTask();
		hm.taskPageDisplayed();
		log.info("moved to task page");
	}

}
