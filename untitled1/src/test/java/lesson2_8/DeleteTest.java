package lesson2_8;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class DeleteTest {

    @Test
    public void deleteRequestTest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("https://postman-echo.com/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}