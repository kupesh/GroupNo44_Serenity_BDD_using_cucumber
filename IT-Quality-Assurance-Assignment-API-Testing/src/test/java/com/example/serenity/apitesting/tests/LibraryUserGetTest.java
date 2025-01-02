package com.example.serenity.apitesting.tests;

import com.example.serenity.apitesting.base.BaseTest;
import com.example.serenity.apitesting.models.Book;
import com.example.serenity.apitesting.utils.RequestHelper;
import com.google.gson.reflect.TypeToken;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.lang.reflect.Type;
import java.util.List;

import static com.example.serenity.apitesting.config.Constants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LibraryUserGetTest extends BaseTest {

    private static List<Book> bookList;
    private static Response response;

    @Given("the library API is running using user")
    public void theLibraryAPIIsRunning() {
        RequestHelper requestHelper = new RequestHelper(BASE_URI);
        Response healthResponse = requestHelper
                .withEndpoint(GET_BOOKS_ENDPOINT)
                .withAuth(USER_USERNAME, USER_PASSWORD)
                .sendRequest("GET");
        assertThat(healthResponse.getStatusCode(), is(200));
    }

    @When("User fetch all books with valid credentials")
    public void fetchAllBooksWithValidCredentials() {
        Type bookListType = new TypeToken<List<Book>>() {}.getType();
        RequestHelper requestHelper = new RequestHelper( BASE_URI);
        response = requestHelper
                .withEndpoint(GET_BOOKS_ENDPOINT) 
                .withAuth(USER_USERNAME, USER_PASSWORD)
                .sendRequest("GET");
        bookList = response.body().as(bookListType);
    }

    @Then("the response code for user should be {int}")
    public void verifyResponseCode(int statusCode) {
        assertThat(response.getStatusCode(), is(statusCode));
    }

    @Then("the response should contain a list of books for user")
    public void verifyResponseContainsBooks() {
        assertThat(bookList, is(notNullValue()));
        assertThat(bookList.size(), greaterThan(0));
    }
}
