package com.qa.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReqresTests {

    @BeforeAll
    public static void setup() {
        // URL de base de l'API
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void testSingleUser() {
        Response response = given()
                .when()
                .get("/users/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", notNullValue())
                .extract().response();

        assertNotNull(response);
        assertTrue(response.asString().contains("janet"));
    }

    @Test
    public void testListUsers() {
        Response response = given()
                .queryParam("page", 2)
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("data[0].id", notNullValue())
                .body("data[0].email", notNullValue())
                .extract().response();

        assertNotNull(response);
        assertTrue(response.asString().contains("michael"));
    }

    @Test
    public void testCreateUser() {
        String requestBody = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"))
                .extract().response();

        assertNotNull(response);
        assertTrue(response.asString().contains("id"));
    }

    @Test
    public void testUpdateUser() {
        String requestBody = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/users/2")
                .then()
                .statusCode(200)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("zion resident"))
                .extract().response();

        assertNotNull(response);
        assertTrue(response.asString().contains("updatedAt"));
    }

    @Test
    public void testDeleteUser() {
        given()
                .when()
                .delete("/users/2")
                .then()
                .statusCode(204);  // Pas de contenu

        // Pas de body à vérifier pour delete, juste le code HTTP
    }
}
