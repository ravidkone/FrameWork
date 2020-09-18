package com.ravi.loginTest;

import org.testng.annotations.Test;

import com.ravi.utilities.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TriggerApi extends TestBase{

	String sHost = "http://api.openweathermap.org/data/2.5/weather?";

	@Test
	public void userProfile() {

		String sURI = "/employees/1";

		// RestAssured.baseURI=sHost+sURI;
		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather?q=Kanpur&appid=“7fe67bf08c80ded756e598d6f8fedaea";
		// System.out.println("URL is: "+sHost+sURI);
	//	Response res  = oResUtil.ufGet(sURL,sMapAuthorizationHeader);
		
		
		Response res = RestAssured.given().contentType("application/json").get();

		System.out.println("status code is: " + res.getStatusCode());
		res.prettyPrint();

	}

}
