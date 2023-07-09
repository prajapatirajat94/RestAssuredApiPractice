package com.Rest.Api.Get;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetNonBDDApi {

	
	
	
	
@Test
public void getUser_non_Bdd_Test() throws FileNotFoundException {
	
//prepare the request
//hit the API
//get the response
//fetch the value from response	
	
	RestAssured.baseURI="https://gorest.co.in";
	RequestSpecification request =RestAssured.given();
	request.header("Authorization","Bearer 7ed0d7f31bc21caed71d3b3ece46fa2dd5a94208ef6215d5eec2b913c71a85a4");
	Response response =request.get("/public/v2/users");
	System.out.println(response.statusCode());
	System.out.println(response.prettyPrint());
	System.out.println(response.header("Server"));
	
	/**
	 * below method is to write json response to file
	 */
	try (FileWriter file = new FileWriter("employees.json")) {
        //We can write any JSONArray or JSONResponse instance to the file
        file.write(response.prettyPrint()); 
        file.flush();

    } catch (IOException e) {
        e.printStackTrace();
    }
	
}
	
	
//with Query params	
@Test
public void getUser_non_Bdd_WithParameter_Test() {
	
//prepare the request
//hit the API
//get the response
//fetch the value from response	
	
	RestAssured.baseURI="https://gorest.co.in";
	RequestSpecification request =RestAssured.given();
	request.queryParam("name","kamal");
	request.queryParam("gender","female");
	request.header("Authorization","Bearer 7ed0d7f31bc21caed71d3b3ece46fa2dd5a94208ef6215d5eec2b913c71a85a4");
	Response response =request.get("/public/v2/users");
	System.out.println(response.statusCode());
	System.out.println(response.prettyPrint());
	System.out.println(response.header("Server"));
	
}	
	
//with hashmap	
@Test
public void getUser_non_Bdd_HASHMAP_WithParameter_Test() {
	Map<String,String> params = new HashMap<String,String>(); 
	params.put("name", "kamal");
	params.put("gender", "female");
	params.put("status", "active");

	
	RestAssured.baseURI="https://gorest.co.in";
	RequestSpecification request =RestAssured.given();
	request.queryParams(params);
	request.header("Authorization","Bearer 7ed0d7f31bc21caed71d3b3ece46fa2dd5a94208ef6215d5eec2b913c71a85a4");
	Response response =request.get("/public/v2/users");
	
	JsonPath js = response.jsonPath();
	System.out.println(js.getString("id[0]"));
	System.out.println(response.statusCode());
	System.out.println(response.prettyPrint());
	System.out.println(response.header("Server"));
	System.out.println(response.getStatusLine());
	System.out.println(response.body().jsonPath().getString("id[0]"));
	
}		
	
	
	
	
	
	
	
	
}
