package com.qa.tests;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.config = RestAssured.config()
                .sslConfig(SSLConfig.sslConfig().allowAllHostnames().relaxedHTTPSValidation());
    }
}
