package com.example.serenity.apitesting.base;

import com.example.serenity.config.Constants;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = Constants.BASE_URI;
    }
}
