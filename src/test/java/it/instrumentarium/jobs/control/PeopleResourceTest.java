package it.instrumentarium.jobs.control;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import it.instrumentarium.jobs.entity.PeopleRepository;

@QuarkusTest
public class PeopleResourceTest {

    @Inject
    PeopleRepository repo;

    @BeforeEach
    @Transactional
    void beforeEach() {
        repo.deleteAll();
    }

    @Test
    public void testEmptyList() {
        given()
                .when().get("/people")
                .then()
                .statusCode(200)
                .body("$.size()", is(0));
    }

    @Test
    public void testNewValidUser() {
        given()
            .body("{\"login\": \"john123\", \"name\": \"John Doe\", \"password\": \"secret\"}")
            .header("Content-Type", MediaType.APPLICATION_JSON)
            .when().post("/people")
            .then()
            .statusCode(201)
            .body("id", is(greaterThan(0)));
    }

    @Test
    public void testNewInvalidUserAka4xx() {
        given()
            .body("{\"login\": \"john123\", \"name\": \"John Doe\"}")
            .header("Content-Type", MediaType.APPLICATION_JSON)
            .when().post("/people")
            .then()
            .statusCode(Status.BAD_REQUEST.getStatusCode())
            .body("msg", not(is(emptyString())));

        given()
            .body("{\"login\": \"john123\", \"password\": \"secret\"}")
            .header("Content-Type", MediaType.APPLICATION_JSON)
            .when().post("/people")
            .then()
            .statusCode(Status.BAD_REQUEST.getStatusCode())
            .body("msg", not(is(emptyString())));

        given()
            .body("{\"name\": \"John Doe\", \"password\": \"secret\"}")
            .header("Content-Type", MediaType.APPLICATION_JSON)
            .when().post("/people")
            .then()
            .statusCode(Status.BAD_REQUEST.getStatusCode())
            .body("msg", not(is(emptyString())));
        
        given()
            .body("{}")
            .header("Content-Type", MediaType.APPLICATION_JSON)
            .when().post("/people")
            .then()
            .statusCode(Status.BAD_REQUEST.getStatusCode())
            .body("msg", not(is(emptyString())));

        // valid body but w/o Content-Type
        given()
            .body("{\"login\": \"john123\", \"name\": \"John Doe\", \"password\": \"secret\"}")
            .when().post("/people")
            .then()
            .statusCode(415);
    }

    @Test
    @Transactional
    public void testTakenLogin() {
        String body = "{\"login\": \"john123\", \"name\": \"John Doe\", \"password\": \"secret\"}";

        given()
            .body(body)
            .header("Content-Type", MediaType.APPLICATION_JSON)
            .when().post("/people")
            .then()
            .statusCode(201)
            .body("id", is(greaterThan(0)));

        given()
            .body(body)
            .header("Content-Type", MediaType.APPLICATION_JSON)
            .when().post("/people")
            .then()
            .statusCode(400)
            .body("msg", not(is(emptyString()))); // cannot use the same login twice
    }

    @Test
    @Transactional
    public void testDeleteUser() {

        // removing non-existing user should be OK
        given()
            .when().delete("/people/99")
            .then()
            .statusCode(Status.NO_CONTENT.getStatusCode());

        
        Object userId = given()
            .body("{\"login\": \"john123\", \"name\": \"John Doe\", \"password\": \"secret\"}")
            .header("Content-Type", MediaType.APPLICATION_JSON)
            .when().post("/people").then()
            .extract()
            .path("id");
            assertNotNull(userId);
        
        given()
            .when().delete("/people/" + userId.toString())
            .then()
            .statusCode(Status.NO_CONTENT.getStatusCode());  

    }

    @Transactional
    @Test
    public void testReadingUser() {
        given()
            .when().get("/people/99")
            .then()
            .statusCode(Status.NOT_FOUND.getStatusCode());

        Object userId = given()
            .body("{\"login\": \"john123\", \"name\": \"John Doe\", \"password\": \"secret\"}")
            .header("Content-Type", MediaType.APPLICATION_JSON)
            .when().post("/people").then()
            .extract()
            .path("id");

        assertNotNull(userId);

        given()
            .when().get("/people/" + userId)
            .then()
            .statusCode(Status.OK.getStatusCode());
    }

}
