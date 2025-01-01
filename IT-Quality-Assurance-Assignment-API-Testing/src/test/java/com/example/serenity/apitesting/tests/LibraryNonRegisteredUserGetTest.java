package com.example.serenity.apitesting.tests;

import com.example.serenity.apitesting.utils.RequestHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static com.example.serenity.apitesting.config.Constants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LibraryNonRegisteredUserGetTest {
    private static Response response;


    @When("the non-registered user fetches all books")
    public void nonRegisteredUserFetchesAllBooks() {
        RequestHelper requestHelper = new RequestHelper(BASE_URI);
        response = requestHelper
                .withEndpoint(GET_BOOKS_ENDPOINT)
                .sendRequest("GET"); // Simulating a request from a non-registered user
    }

    @Then("the response code for non-registered should be {int}")
    public void verifyResponseCodeForNonRegisteredUser(int statusCode) {
        assertThat(response.getStatusCode(), is(statusCode));
    }



}
