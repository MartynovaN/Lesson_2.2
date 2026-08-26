package lesson2_8;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PostTest {

    @Test
    public void postRawTextTest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}