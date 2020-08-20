package com.ravi.utilities;

import org.apache.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestUtilities {
	public static int iStatusCode=0;
	Logger log = Logger.getLogger(getClass().getSimpleName());
	
	public Response ufPost(String sURL, String sBody) throws Exception{
		log.info("setting Base URL as : "+sURL+"\nBody: "+sBody);
		RestAssured.baseURI=sURL;
		Response res = RestAssured.given().contentType(Constants.sContentType).body(sBody).post();
		log.info(iStatusCode=res.getStatusCode());
		log.info(res.asString());
		return res;
	}

}
