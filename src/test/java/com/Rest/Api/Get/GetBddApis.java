package com.Rest.Api.Get;
// below is we have to do import static import
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class GetBddApis {

//http://md5.jsontest.com/?text=text	
	//Rest Assured BDD:-
//	given()
//	when()
//	then()
//	and()
	
	@Test()
	public void GetApiCircuitTest1() {
		given().log().all().
		when().log().all()
		.get("https://ergast.com/api/f1/2017/circuits.json")
		.then().log().all()
		.assertThat().body("MRData.CircuitTable.Circuits.circuitId", hasSize(20))
		.body("MRData.CircuitTable.Circuits.circuitId[0]", equalTo("albert_park"))
		
		
		;
		
	}
	
	@Test
	public void GetApiCircuitTest2() {
//below we can use it and modify test		
		Response response =given().log().all().
		when().log().all()
		.get("https://ergast.com/api/f1/2017/circuits.json")
		;
		int statusCode=response.getStatusCode();
		System.out.print(statusCode);
		Assert.assertEquals(statusCode,200 );
		
		//System.out.println(response.prettyPrint());
	
	}
	
	@Test
	public void GetApiCircuitTest3() {
//below we can use it and modify test		
		
		
		RestAssured.baseURI="http://ergast.com";
		
		given().log().all()
		.when().log().all()
		.get("/api/f1/2017/circuits.json")
		.then().log().all()
		    .assertThat()
		    .statusCode(200)
		.and()
		    .contentType(ContentType.JSON)
		.and()
		    .header("Content-Length",equalTo("4552") );
	
	}
	
	@Test
	public void GetJsonAPiVerifymd5Value() {
		
		
// Passing Url with quary parameter for Query we write with ?
//http://md5.jsontest.com/?text=text	
		
		String ParamValue="test";
		given().
		param("text", ParamValue)
		.log().all()
		.when().log().all()
		.get("http://md5.jsontest.com")
		.then().log().all()
		.assertThat().body("md5", equalTo("098f6bcd4621d373cade4e832627b4f6"));
		
	}
	
	@DataProvider
	public Object[][] GetCircuitData(){
		return new Object[][] {
			{"2017",20},
			{"2018",21},
			{"2019",21}
		};
	}
	
	@Test(dataProvider="GetCircuitData")
	public void NumberofCircuitEachYear(String Year,int size) {
		
		given().log().all()
		.pathParam("raceSeason", Year)
		.when().log().all().get("https://ergast.com/api/f1/{raceSeason}/circuits.json")
		.then().log().all().assertThat().body("MRData.CircuitTable.Circuits.circuitId", hasSize(size));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
