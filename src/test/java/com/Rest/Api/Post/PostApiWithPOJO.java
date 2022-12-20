package com.Rest.Api.Post;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostApiWithPOJO {
//POJO - Plain old java object
	//Create User
	//Post- URL
//REQUEST JSON BODY --> 	
//USER JAVA CLASS(pojo) --->JSON object	
//Encapsulation :--> private -->public(getter and setter methods)  Hiding data members	
// POJO -->Simple java class -->--> private -->public(getter and setter methods) 	
//1.create POJO object as we have created here UserCLass then call it and pass all values
/*2.create object of one ObjectMapper class then one method is there 	
    mappper.writeValueAsString(Pass object of POJO); store it to string
    which is basically one json string	
	*/
	
	
	
@Test
public void createuser_With_Pojo_Test() {

UserClass user = new UserClass("Rajat","Praja255@gmail.com","male","active");

//convert pojo to json --Serialization --JACKSON API

ObjectMapper mapper = new ObjectMapper();
String userjson =null;
 try {
	 userjson	= mapper.writeValueAsString(user);
} catch (JsonProcessingException e) {	
	e.printStackTrace();
}
System.out.println(userjson);
 
RestAssured.baseURI="https://gorest.co.in";
 given().log().all().contentType(ContentType.JSON)
		   .header("Authorization","Bearer 7ed0d7f31bc21caed71d3b3ece46fa2dd5a94208ef6215d5eec2b913c71a85a4")
         .body(userjson)
         .when().log().all().post("/public/v2/users")
         .then().assertThat().statusCode(201).contentType(ContentType.JSON).and().body("name",equalTo("Rajat"));
 
}
	
	
} 
