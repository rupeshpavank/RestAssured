package org.tests.automation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class TestHeaders {
	
	 @Test
	   public void addMultipleHeader() {
	      String baseUrl =
	      "https://api.reverb.com/api/articles?page=1&per_page=24";

	      //input details with multiple headers
	      RequestSpecification r =  
	       given()
	      .header("Accept", "application/hal+json")
	      .header("Content-Type", "application/json")
	      .header("Accept-Version", "3.0");

	      //obtain get Response
	      Response res = r.get(baseUrl);

	      //get status code
	      int c = res.getStatusCode();
	      System.out.println(c);
	   }

}
