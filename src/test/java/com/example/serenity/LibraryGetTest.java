package com.example.serenity;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class LibraryGetTest {

    static {
        RestAssured.baseURI = "http://localhost:7081/api"; // Base URI for API
    }

    private final String adminUsername = "admin";
    private final String adminPassword = "password";
    private final String userUsername = "user";
    private final String userPassword = "password";

    /**
     * Test for fetching all books with valid admin credentials.
     */
    @Test
    public void adminShouldFetchAllBooks() {
        given()
                .auth().basic(adminUsername, adminPassword)
                .when()
                .get("/books")
                .then()
                .statusCode(200) // Expect 200 for valid credentials
                .contentType(ContentType.JSON)
                .body("size()", greaterThanOrEqualTo(0));
    }

    /**
     * Test for fetching all books with valid user credentials.
     */
    @Test
    public void userShouldFetchAllBooks() {
        given()
                .auth().basic(userUsername, userPassword)
                .when()
                .get("/books")
                .then()
                .statusCode(200) // Validate based on user permissions
                .contentType(ContentType.JSON)
                .body("size()", greaterThanOrEqualTo(0));
    }

    /**
     * Test for fetching all books with incorrect credentials.
     */
    @Test
    public void shouldFailWithIncorrectCredentials() {
        given()
                .auth().basic(adminUsername, "wrongpassword")
                .when()
                .get("/books")
                .then()
                .statusCode(401); // Expect 401 for unauthorized access
    }

    /**
     * Test for fetching all books without authentication.
     */
    @Test
    public void shouldFailWithoutAuthentication() {
        given()
                .when()
                .get("/books")
                .then()
                .statusCode(401); // Expect 401 for missing authentication
    }

    /**
     * Test for fetching a specific book with valid admin credentials.
     */
    @Test
    public void adminShouldFetchBookById() {
        int bookId = 1; // Replace with a valid ID in your API

        given()
                .auth().basic(adminUsername, adminPassword)
                .when()
                .get("/books/" + bookId)
                .then()
                .statusCode(200)
                .body("id", equalTo(bookId))
                .body("title", notNullValue())
                .body("author", notNullValue());
    }

    /**
     * Test for forbidden access (e.g., user attempting admin-only actions).
     */
    @Test
    public void userShouldBeForbiddenForRestrictedActions() {
        int bookId = 1; // Replace with a valid ID in your API

        given()
                .auth().basic(userUsername, userPassword)
                .when()
                .delete("/books/" + bookId) // Assuming delete is restricted to admin
                .then()
                .statusCode(403); // Expect 403 for forbidden access
    }

    /**
     * Test for fetching a non-existent book.
     */
    @Test
    public void shouldReturnNotFoundForInvalidBookId() {
        int invalidBookId = 9999; // Use a non-existent ID

        given()
                .auth().basic(adminUsername, adminPassword)
                .when()
                .get("/books/" + invalidBookId)
                .then()
                .statusCode(404); // Expect 404 for book not found
    }
}