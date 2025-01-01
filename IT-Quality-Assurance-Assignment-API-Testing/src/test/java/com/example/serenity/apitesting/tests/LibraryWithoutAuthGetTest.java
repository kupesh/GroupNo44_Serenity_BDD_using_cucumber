package com.example.serenity.apitesting.tests;

import com.example.serenity.apitesting.base.BaseTest;
import com.example.serenity.apitesting.utils.RequestHelper;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static com.example.serenity.apitesting.config.Constants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LibraryWithoutAuthGetTest extends BaseTest {
    private static Response response;


    @When("the user fetches all books without providing authentication")
    public void fetchBooksWithoutAuthentication() {
        RequestHelper requestHelper = new RequestHelper(BASE_URI);
        response = requestHelper
                .withEndpoint(GET_BOOKS_ENDPOINT)
                .sendRequest("GET"); // No authentication headers included
    }

    @Then("the response code without authentication should be {int}")
    public void verifyUnauthorizedResponseCode(int statusCode) {
        assertThat(response.getStatusCode(), is(statusCode));
    }


}
