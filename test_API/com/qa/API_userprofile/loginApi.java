package com.qa.API_userprofile;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ravi.payload.pl_userprofile;
import com.ravi.utilities.TestBase;

import io.restassured.response.Response;

public class loginApi extends TestBase{
	Logger log=Logger.getLogger(getClass().getSimpleName());

	
//	public static void main(String[] args) {

	 int iStatusCode=0;
	
	String sURI, sEmailID, sPassword;
	String sURL;
	Response res_Login;
	
	
	@Test
	public void Login() throws Exception {
		System.out.println("********API******");
		sURI=System.getProperty("UserPro_Login_new");
		sEmailID=System.getProperty("email");
		sPassword=System.getProperty("password");
		sURL=System.getProperty("StageHost")+sURI;
		System.out.println("Stage URL is: "+sURL);
	//	RestAssured.baseURI=sURL;

		//RestAssured.baseURI="https://stg-api.cowrks.team/profile-service/v2/auth/login";
		String sLoadLogin=pl_userprofile.sPayloadLogin.replaceAll("REPLACE_EMAIL", sEmailID).replaceAll("REPLACE_PASSWORD", sPassword);
		res_Login = oResUtil.ufPost(sURL,sLoadLogin);
		
		
		
	System.out.println("Status code is: " +res_Login.getStatusCode());
//	System.out.println(res_Login.asString());
	log.info(iStatusCode=res_Login.getStatusCode());
	log.info(res_Login.asString());
	res_Login.prettyPrint();
	}

}
