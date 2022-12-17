package com.Rest.Api.Get;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
public class PostCalls {

    
 //below we are hitting api with Post calls but this is not good approach
//but there are multiple option
//1
@Test
    public void Token_BDD_Post_Call_API_TEST(){

    RestAssured.baseURI="https://restful-booker.herokuapp.com";
    given().log().all().contentType(ContentType.JSON)
            .body("{\"username\" : \"admin\",\"password\" : \"password123\"}")
            .when().log().all().post("/auth")
            .then().log().all().assertThat().statusCode(200);

}

//2 we are passing body as file

    @Test
    public void Token_BDD_Post_Call_API_FILE_TEST(){

          RestAssured.baseURI="https://restful-booker.herokuapp.com";
       String TokenID = given().log().all().contentType(ContentType.JSON)
                .body(new File("src\\test\\java\\DataFiles\\credential.json"))
                .when().log().all().post("/auth")
                .then().extract().path("token");
  //for getting token we usually take JsonPath().getString("")  we use this but there is another 
  //     short cut after
  // then().Extract().path("JSON PATH")
        System.out.println(TokenID);
        Assert.assertNotNull(TokenID);
    }
    
    
    
//Go Rest Practice Post api we can use below method    
    
    @Test
    public void Token_BDD_Post_Call_API_USER_TEST(){

          RestAssured.baseURI="https://gorest.co.in";
       String UserName = given().log().all().contentType(ContentType.JSON)
    		   .header("Authorization","Bearer 7ed0d7f31bc21caed71d3b3ece46fa2dd5a94208ef6215d5eec2b913c71a85a4")
                .body(new File("src\\test\\java\\DataFiles\\User.json"))
                .when().log().all().post("/public/v2/users")
                .then().extract().path("name");
  //for getting token we usually take JsonPath().getString("")  we use this but there is another 
  //     short cut after
  // then().Extract().path("JSON PATH")
        System.out.println(UserName);
        Assert.assertNotNull(UserName);

    }
    
    
    
    
    
}
