package com.Rest.Api.Schema;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckSchemaTest {

	
@Test
public void bookings_Schema_Test() {
	
// here if we want to validate jsonschema of Json file then below step follow
//1. import :- import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
//2. copy your json response to json to jsonschema converter https://www.liquid-technologies.com/online-json-to-schema-converter
//3. For validation :- after then().body(matchesJsonSchemaInClasspath("Path of json schema file")) add this line with correct parameter
		
	RestAssured.baseURI="https://restful-booker.herokuapp.com";
	 given().log().all()
	 .contentType(ContentType.JSON)
	 .body(new File("src\\test\\java\\com\\Rest\\Api\\Schema\\bookings.json"))
	 .when().log().all()
	 .post("/booking")
	 .then().log().all()
	 .assertThat()
	 .statusCode(200)
	 .and().body(matchesJsonSchemaInClasspath("bookingsSchemas.json"));
	
}
	
	
	
	
	
	
	
}
