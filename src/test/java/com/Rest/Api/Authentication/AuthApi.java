package com.Rest.Api.Authentication;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;




public class AuthApi {

//Basic Auth
// username and Password
	
@Test
public void BasicAuthApi_Test() {
	given().log().all()
	.auth()
	.preemptive()
	.basic("admin","admin" )
	.when().log().all()
	.get("https://the-internet.herokuapp.com/basic_auth")
	.then().log().all()
	.assertThat()
	.statusCode(200);
	
}


//	OAuth 2.0
//1.some time with Oauth2.0 just Pass Token instead of "Bearer Token" if doesnot work
//2.When Passing As header Authorization append with "Bearer" Token
@Test
public void Oauth1_API_Test() {
	given()
	.auth().oauth2("d5cc61a6a4db902af5cf78eacaab23b723a1453633dce8b7d26249e7c717001d")
	.when().get("https://gorest.co.in/public/v2/users/?name=kamal")
	.then().assertThat().statusCode(200)
	;
	
}


@Test
public void Oauth_API_Test_with_AuthHeader() {
	RestAssured.baseURI="https://gorest.co.in";
	
given().log().all()
.contentType("application/json")
.header("Authorization", "Bearer d5cc61a6a4db902af5cf78eacaab23b723a1453633dce8b7d26249e7c717001d")
.when().log().all().get("/public/v2/users/?name=kamal")
.then().log().all().statusCode(200).and().header("Server","cloudflare");
}

@Test
public void Oauth_API_TwoQueryParams_Api() {
	
	RestAssured.baseURI="https://gorest.co.in";
	
 given().log().all()
.contentType("application/json")
.header("Authorization", "Bearer d5cc61a6a4db902af5cf78eacaab23b723a1453633dce8b7d26249e7c717001d")
.queryParam("name", "Kamala Patel")
.queryParam("gender", "female")
.when().log().all().get("/public/v2/users/")
.then().log().all().statusCode(200).and().header("Server","cloudflare");
}









	
}
