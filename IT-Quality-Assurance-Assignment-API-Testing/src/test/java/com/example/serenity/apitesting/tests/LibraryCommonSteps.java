package com.example.serenity.apitesting.tests;

import com.example.serenity.apitesting.models.Book;
import com.example.serenity.apitesting.utils.RequestHelper;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import static com.example.serenity.apitesting.config.Constants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LibraryCommonSteps {

    private String createdBookId;

    @Given("the library API is running and a book is created")
    public void theLibraryAPIIsRunningAndBookCreated() {
        // Check API health
        RequestHelper requestHelper = new RequestHelper(BASE_URI);
        Response healthResponse = requestHelper
                .withEndpoint(GET_BOOKS_ENDPOINT)
                .withAuth(ADMIN_USERNAME, ADMIN_PASSWORD)
                .sendRequest("GET");
        assertThat("API is not running", healthResponse.getStatusCode(), is(200));

        // Create a book
        createdBookId = createInitialBook("Default Book Title", "Default Author");
    }

    private String createInitialBook(String title, String author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);

        RequestHelper requestHelper = new RequestHelper(BASE_URI);
        Response response = requestHelper
                .withEndpoint(CREATE_BOOK_ENDPOINT)
                .withAuth(ADMIN_USERNAME, ADMIN_PASSWORD)
                .withBody(book)
                .sendRequest("POST");

        assertThat("Failed to create initial book", response.getStatusCode(), is(201));
        String bookId = response.jsonPath().getString("id");
        System.out.println("Initial book created successfully with ID: " + bookId);
        return bookId;
    }

    public void deleteCreatedBook() {
        if (createdBookId != null) {
            RequestHelper requestHelper = new RequestHelper(BASE_URI);
            Response response = requestHelper
                    .withEndpoint(CREATE_BOOK_ENDPOINT + "/" + createdBookId)
                    .withAuth(USER_USERNAME, ADMIN_PASSWORD)
                    .sendRequest("DELETE");

            assertThat("Failed to delete the book", response.getStatusCode(), is(200));
            System.out.println("Book deleted successfully with ID: " + createdBookId);
        }
    }

    @After
    public void cleanUp() {
        if (createdBookId != null) {
            deleteCreatedBook();
        }
    }
}
