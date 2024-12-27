package com.example.serenity;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

@ExtendWith(SerenityJUnit5Extension.class)
public class LibraryApiTest {

    static {

        RestAssured.baseURI = "http://localhost:7081/api";
    }

    private final String username = "admin";
    private final String password = "password";

    @Test
    public void shouldFetchAllBooks() {
        given()
                .auth().basic(username, password) // Add Basic Auth
                .when()
                .get("/books")
                .then()
                .statusCode(200) // Expect a 200 response
                .body("size()", greaterThanOrEqualTo(0)); // Validate response
    }

//    @Test
//    public void shouldAddNewBook() {
//        String newBook = """
//        {
//            "title": "New Book Title",
//            "author": "Author Name"
//        }
//        """;
//
//        Response response = given()
//                .auth().basic(username, password)
//                .contentType(ContentType.JSON)
//                .body(newBook)
//                .when()
//                .post("/books");
//
//        response
//                .then()
//                .statusCode(201); // Expect a 201 response
//
//        // Verify the created book
//        int id = response.jsonPath().getInt("id");
//        given()
//                .auth().basic(username, password)
//                .when()
//                .get("/books/" + id)
//                .then()
//                .statusCode(200)
//                .body("title", equalTo("New Book Title"))
//                .body("author", equalTo("Author Name"));
//    }

    @Test
    public void shouldFetchBookById() {
        int bookId = 1; // Replace with a valid book ID for your API

        given()
                .auth().basic(username, password) // Add Basic Auth
                .when()
                .get("/books/" + bookId)
                .then()
                .statusCode(200)
                .body("id", equalTo(bookId));
    }

//    @Test
//    public void shouldDeleteBook() {
//        int bookId = 1;
//
//        given()
//                .auth().basic(username, password)
//                .when()
//                .delete("/books/" + bookId)
//                .then()
//                .statusCode(200);
//    }
}
