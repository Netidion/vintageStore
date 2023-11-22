package org.net.quarkus.microservices.book;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void createBookTest() {
        given()
                .formParam("title", "Quarkus")
                .formParam("author", "Antonio Goncalves")
                .formParam("year", 2021)
                .formParam("genre", "IT")
                .when()
                .post("/api/books")
                .then()
                .statusCode(201)
                .body("isbn_13", startsWith("13-"))
                .body("title", startsWith("Quarkus"))
                .body("author", startsWith("Antonio"))
                .body("year_of_publication", is(2021))
                .body("genre", is("IT"))
                .body("creation_date", startsWith("22"));
    }
}