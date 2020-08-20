package com.ravi.utilities;

import org.apache.log4j.Logger;

public class Constants extends TestBase{
	Logger log=Logger.getLogger(getClass().getSimpleName());
	
	//Environment and Running app (to avoid driver.quit error)
	public static final String sConstEnvironment="PROD",sAutomationAPI="API",sAutomationWeb="Web",sAutomationAPP="App";
	public static final String sContentType="application/json";

	
}
