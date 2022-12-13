
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;



public class ResponseSpecificationBuilderTest {


// here inorder to avoid duplication of the code we use ResponseSpec builder and We can create multiple for different request
    ResponseSpecBuilder Spec1 = new ResponseSpecBuilder();
    ResponseSpecification res_Spec_200_Ok=Spec1.expectContentType(ContentType.JSON).expectStatusCode(200).expectHeader("Server","cloudflare").build();
    ResponseSpecBuilder Spec2 = new ResponseSpecBuilder();
    ResponseSpecification res_Spec_400_AUTH_FAILED=Spec2.expectContentType("text/html").expectStatusCode(404).expectHeader("Server","cloudflare").build();


    @Test
    public void ResponseSpecTestoK(){

        RestAssured.baseURI="https://gorest.co.in";
        given().log().all()
                .when().log().all().get("/public/v2/users?name=Kamalesh Khatri")
                .then().log().all()
                .assertThat()
               .spec(res_Spec_200_Ok)
               .and().body("id[0]",equalTo(4927));

    }

    @Test
    public void ResponseSpecTest_Bad_REQUEST_TEST(){

        RestAssured.baseURI="http://gorest.co.in";
        given().header("Authorization","Bearer d5cc61a6a4db902af5cf78eacaab23b723a1453633dce8b7d26249e7c717001d").log().all()
                .when().log().all().get("/public/v2/uses?name=Kamala Pilla")
                .then()
                .assertThat().spec(res_Spec_400_AUTH_FAILED);


    }




}
