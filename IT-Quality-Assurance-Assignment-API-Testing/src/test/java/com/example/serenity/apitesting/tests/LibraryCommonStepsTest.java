package com.example.serenity.apitesting.tests;

import com.example.serenity.apitesting.base.BaseTest;
import com.example.serenity.apitesting.models.Book;
import com.example.serenity.apitesting.utils.RequestHelper;

import io.cucumber.java.AfterAll;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import static com.example.serenity.apitesting.config.Constants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LibraryCommonStepsTest  extends BaseTest {

    private String createdBookId;
    private static boolean isSetupDone = false;

    @BeforeAll
    public static void setup() {
        if (!isSetupDone) {

                Book book = new Book();
                book.setTitle("Sample Book for Test");
                book.setAuthor("Test Author");

                RequestHelper requestHelper = new RequestHelper(BASE_URI);
                Response response = requestHelper
                        .withEndpoint(BOOKS_ENDPOINT)
                        .withAuth(ADMIN_USERNAME, ADMIN_PASSWORD)
                        .withBody(book)
                        .sendRequest("POST");

                if (response.getStatusCode() == 201) {
                    String bookId = response.jsonPath().getString("id");
                    System.out.println("Sample book created successfully with ID: " + bookId);
                } else {
                    System.err.println("Failed to create sample book: " + response.body().asString());
                }

                // Set the flag to true so the setup runs only once
                isSetupDone = true;
            }
        }


    @Given("the library API is running and a book is created")
    public void theLibraryAPIIsRunningAndBookCreated() {
        RequestHelper requestHelper = new RequestHelper(BASE_URI);
        Response response = requestHelper.fetchBook(BOOKS_ENDPOINT, ADMIN_USERNAME, ADMIN_PASSWORD);
        assertThat("API is not running", response.getStatusCode(), is(200));

    }

    @Given("the library API is running and book with ID {int} available")
    public void theLibraryAPIIsRunningAndBookCreated(int bookId) {
        RequestHelper requestHelper = new RequestHelper(BASE_URI);
        Response response = requestHelper.fetchBookById(BOOKS_ENDPOINT, bookId, ADMIN_USERNAME, ADMIN_PASSWORD);
        assertThat("Book ID 2 is not available", response.getStatusCode(), is(200));

    }

}
