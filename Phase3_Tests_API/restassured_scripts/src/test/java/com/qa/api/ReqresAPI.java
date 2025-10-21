package com.qa.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ReqresAPI {

    static {
        // URL de base
        RestAssured.baseURI = "https://reqres.in/api";
    }

    // GET user by ID
    public static Response getUser(int userId) {
        return given()
                .when()
                .get("/users/" + userId)
                .then()
                .extract().response();
    }

    // GET list of users (with page)
    public static Response listUsers(int page) {
        return given()
                .queryParam("page", page)
                .when()
                .get("/users")
                .then()
                .extract().response();
    }

    // POST create user
    public static Response createUser(String name, String job) {
        String requestBody = "{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }";
        return given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .extract().response();
    }

    // PUT update user
    public static Response updateUser(int userId, String name, String job) {
        String requestBody = "{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }";
        return given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/users/" + userId)
                .then()
                .extract().response();
    }

    // DELETE user
    public static Response deleteUser(int userId) {
        return given()
                .when()
                .delete("/users/" + userId)
                .then()
                .extract().response();
    }
}
