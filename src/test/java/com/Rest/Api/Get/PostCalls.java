
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class PostCalls {

@Test
    public void Token_BDD_Post_Call_API_TEST(){

    RestAssured.baseURI="https://restful-booker.herokuapp.com";
    given().log().all().contentType(ContentType.JSON)
            .body("{\"username\" : \"admin\",\"password\" : \"password123\"}")
            .when().log().all().post("/auth")
            .then().log().all().assertThat().statusCode(200);

}







}
