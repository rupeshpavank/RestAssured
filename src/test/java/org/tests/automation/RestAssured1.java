package org.tests.automation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RestAssured1 {

	
	  @Test public void restAssured() {
	  
	  
	  Response response= RestAssured.get("https://reqres.in/api/users?page=2");
	  
	  System.out.println(response.getStatusCode());
	  
	  System.out.println(response.getTime());
	  
	  String str=response.getBody().asString();
	  
	  System.out.println(response.getHeader("content-type"));
	  
	  System.out.println(str);
	  
	  }
	 
	  
	  public String getAccessToken(String payload) {
	        return given()
	                .contentType(ContentType.JSON)
	                .body(payload)
	                .post("/token")
	                .then().extract().response()
	                .jsonPath().getString("access_token");
	    }

	  public void userAdminConfigSetup() {
			/*
			 * requestSpecification = given().auth().oauth2(getAccessToken(oauth2Payload))
			 * .header("Accept", ContentType.JSON.getAcceptHeader())
			 * .contentType(ContentType.JSON);
			 */
	    }

	
	  @Test public void restAssuredBDDGet() {
	  
	  given().
	  		when().header("header1", "value1")
	  		.header("header2", "value2")
	  		.get("https://reqres.in/api/users?page=2")
	  		.then().
	  		assertThat(). statusCode(200).
	  and().body("data.id[0]",equalTo(7)).and().body("data.email[1]",
	  equalTo("lindsay.ferguson@reqres.in")).and().assertThat().body("total",
	  equalTo(12)) .log().all();
	  
	  
	  }
	  
	  
	  
	  @Test public void restAssuredBDDGet1() {
	  
	  baseURI="https://reqres.in/api/";
	  
	  given().when().get("users?page=2").then(). assertThat(). statusCode(200).
	  and().body("data.id[0]",equalTo(7)).and().body("data.email[1]",
	  equalTo("lindsay.ferguson@reqres.in")).and().assertThat().body("total",
	  equalTo(12)). body("data.first_name", hasItem("Michael")) .log().all();
	  


      org.apache.http.conn.ssl.SSLSocketFactory clientAuthFactory = new org.apache.http.conn.ssl.SSLSocketFactory(keyStore, password);

	  
	  }
	  
 RestAssured.config().sslConfig(
	            new SSLConfig().keystore("app trust.jks", password)
	                    .keystore("key trust.jks", password));
	 

		
		  @Test public void restAssuredBDDPost() {
			  
			  RequestSpecBuilder builder=new RequestSpecBuilder();
			  
List<Filter> ls=new ArrayList<>();

ls.add(new CookieFilter());
			  
			  builder.setBaseUri("");
			  
			  builder.setBasePath("");
			  
			  builder.addFilters(ls);
			  
			  
			  RequestSpecification requestspec=builder.build();
			  
			  
			  
		Response res=	  RestAssured.given().spec(requestspec).when().get();
		
		res.getBody();
			  
			  
		  baseURI = "https://reqres.in/";
		  
		  File jsonDataInFile = new File(
		  "C:\\Users\\kittu\\eclipse-workspace\\TestAutomationPracice-master\\TestAutomationPracice-master\\src\\main\\resources\\Test.json"
		  );
		  
		  given().
		  	contentType(ContentType.JSON).body(jsonDataInFile).
		  post("/api/users")
		  	.then().assertThat().and() .statusCode(201).assertThat().and().body("name",
		  	 equalTo("morpheus")).log().all();
		  
		  }
		 

}
