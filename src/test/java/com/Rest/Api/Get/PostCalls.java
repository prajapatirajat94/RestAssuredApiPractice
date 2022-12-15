
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
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
        given().log().all().contentType(ContentType.JSON)
                .body(new File("C:\\Users\\s2743085\\OneDrive - The Bank of Nova Scotia\\Documents\\ProjectRunRajat\\src\\main\\java\\DataFiles\\credential.json"))
                .when().log().all().post("/auth")
                .then().log().all().assertThat().statusCode(200);

    }







}
