package com.Rest.Api.Authentication;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class OAuth2APITest {

	@Test
public void CheckOAuth2Test() {
	
	RequestSpecification request=RestAssured.given().auth()
			.oauth2("Token")	;
	
	Response response=request.get("https://gmail.googleapis.com/gmail/v1/users/prajapatirajat2020@gmail.com/messages/184f7f3cf6f440c0");
	
	System.out.println(response.getStatusCode());
	
	
	
}
//1.Generate token id at run time by using token api
//2.String TokenId from Response
//3.hit the next APi with this token id



//@Test
public void GetOauth2TokenAPiTest() {
	
	RequestSpecification request =RestAssured.given()
	.formParam("Client_id", "value")
	.formParam("Client_secret", "value")
	.formParam("Grant type", "value");
	 Response response=request.post("url to generate token");
	 System.out.println(response.getStatusCode());
	 System.out.println(response.prettyPrint());
	String TokenId= response.jsonPath().getString("access_token");
 
}
	
}
