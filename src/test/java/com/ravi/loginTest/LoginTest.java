package com.ravi.loginTest;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ravi.pom.login.LoginPage;
import com.ravi.utilities.TestBase;

public class LoginTest extends TestBase{
	
	LoginPage ln;
	Logger log=Logger.getLogger(LoginTest.class);
	@BeforeMethod
	public void setup() {
		ln=new LoginPage(driver);
	}

	@Test
	public void logintoAccount() {
		ln.verifyTitle();
		ln.EnterCredentials();
		ln.clickOnSubmit();
		ln.homepage();
		log.debug("This is debug message");
		log.info("This is info message");
		log.warn("This is warn message");
		log.fatal("This is fatal message");
		log.error("This is error message");
        System.out.println("Logic executed successfully....");

	}
}
