package com.example.serenity.apitesting.tests;

import com.example.serenity.apitesting.base.BaseTest;
import com.example.serenity.apitesting.models.Book;
import com.example.serenity.apitesting.utils.RequestHelper;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static com.example.serenity.apitesting.config.Constants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LibraryAdminGetByIdTest extends BaseTest {

    private static Response response;
    private static Book book;


    @When("Admin fetch the book with ID {int} using valid credentials")
    public void fetchBookById(int bookId) {
        RequestHelper requestHelper = new RequestHelper(BASE_URI);
        response = requestHelper
                .withEndpoint(GET_BOOKS_ENDPOINT + "/" + bookId)
                .withAuth(ADMIN_USERNAME, ADMIN_PASSWORD)
                .sendRequest("GET");
        book = response.body().as(Book.class); // Deserialize response into Book object
    }

    @Then("the response code when a book exist should be {int}")
    public void verifyResponseCodeForBookById(int statusCode) {
        assertThat(response.getStatusCode(), is(statusCode));
    }

    @And("the response should contain the book {int} details")
    public void verifyResponseContainsBookDetails(int bookId) {
        assertThat(book, is(notNullValue()));
        assertThat(book.getId(), is(bookId));
        assertThat(book.getTitle(), is(notNullValue()));
        assertThat(book.getAuthor(), is(notNullValue()));
    }


}
