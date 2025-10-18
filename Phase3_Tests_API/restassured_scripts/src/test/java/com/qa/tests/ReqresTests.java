package com.qa.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReqresTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void testGetUsersList() {
        given()
        .when()
            .get("/api/users?page=2")
        .then()
            .statusCode(200)
            .body("data", not(empty()));
    }

    @Test
    public void testGetSingleUser() {
        given()
        .when()
            .get("/api/users/2")
        .then()
            .statusCode(200)
            .body("data.id", equalTo(2));
    }

    @Test
    public void testCreateUser() {
        String body = """
                {
                  "name": "Ayoub",
                  "job": "developer"
                }
                """;

        given()
            .header("Content-Type", "application/json")
            .body(body)
        .when()
            .post("/api/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Ayoub"))
            .body("job", equalTo("developer"))
            .body("id", notNullValue())
            .body("createdAt", notNullValue());
    }

    @Test
    public void testUpdateUser() {
        String body = """
                {
                  "name": "Ayoub",
                  "job": "senior developer"
                }
                """;

        given()
            .header("Content-Type", "application/json")
            .body(body)
        .when()
            .put("/api/users/2")
        .then()
            .statusCode(200)
            .body("name", equalTo("Ayoub"))
            .body("job", equalTo("senior developer"))
            .body("updatedAt", notNullValue());
    }

    @Test
    public void testDeleteUser() {
        given()
        .when()
            .delete("/api/users/2")
        .then()
            .statusCode(204);
    }

    @Test
    public void testLoginSuccess() {
        String body = """
                {
                  "email": "eve.holt@reqres.in",
                  "password": "cityslicka"
                }
                """;

        Response response = given()
            .header("Content-Type", "application/json")
            .body(body)
        .when()
            .post("/api/login")
        .then()
            .statusCode(200)
            .body("token", notNullValue())
            .extract().response();

        String token = response.jsonPath().getString("token");
        assertNotNull(token);
        assertTrue(token.length() > 0);
    }

    @Test
    public void testLoginFailureMissingPassword() {
        String body = """
                {
                  "email": "peter@klaven"
                }
                """;

        given()
            .header("Content-Type", "application/json")
            .body(body)
        .when()
            .post("/api/login")
        .then()
            .statusCode(400)
            .body("error", equalTo("Missing password"));
    }
}
