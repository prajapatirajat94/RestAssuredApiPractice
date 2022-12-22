package com.Rest.Api.PUT;

import org.testng.annotations.Test;

import com.Rest.Api.Post.UserClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PUTAPITest {

//create a user with post call
//user info	
//update info with put call	
//1. other attribute should remain same
//2. the attribute which has been changed, need to check
	
@Test
public void update_user_PUT_API_Test() {
//1.Create POST REQUEST with payload	
	UserClass user = new UserClass("Rajat", "Praj20@gmail.com",
			"male","active");

//2.Convert this POJO to json --using JACKSON API -> ObjectMapper 
	ObjectMapper mapper = new ObjectMapper();
	String userJson=null;
	try {
		userJson=	mapper.writeValueAsString(user);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("POST Call JSOn :- "+userJson);
//3.write POST Call
	RestAssured.baseURI="https://gorest.co.in";
	Integer userId=given().log().all()
	.contentType(ContentType.JSON)
	.header("Authorization", "Bearer 7ed0d7f31bc21caed71d3b3ece46fa2dd5a94208ef6215d5eec2b913c71a85a4")
	.body(userJson)
	.when().log().all().post("/public/v2/users")
	.then().log().all()
	.assertThat().contentType(ContentType.JSON)
	.extract().path("id") // :::----> we are using extract method here
	;

	
	System.out.println("User id is :::::> "+userId);

//Call the PUT API
	
	user.setEmail("Praj21@gmail.com");
	String UpdateduserJson=null;
	
	try {
		UpdateduserJson=mapper.writeValueAsString(user);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	given().log().all()
	.contentType(ContentType.JSON)
	.header("Authorization", "Bearer 7ed0d7f31bc21caed71d3b3ece46fa2dd5a94208ef6215d5eec2b913c71a85a4")
	.body(UpdateduserJson)
	.when().log().all().put("/public/v2/users/"+userId)
	.then().log().all()
	.assertThat().contentType(ContentType.JSON)
	.and()
	.body("email",equalTo(user.getEmail()))
	.and()
	.body("id", equalTo(userId))
	.and()
	.body("name", equalTo(user.getName()));	
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
