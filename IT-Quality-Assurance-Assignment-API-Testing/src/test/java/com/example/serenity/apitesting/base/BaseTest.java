package com.example.serenity.apitesting.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static com.example.serenity.apitesting.config.Constants.*;

public abstract class BaseTest {

    @BeforeAll
    public static void setup() {

        RestAssured.baseURI = BASE_URI;
    }

}
