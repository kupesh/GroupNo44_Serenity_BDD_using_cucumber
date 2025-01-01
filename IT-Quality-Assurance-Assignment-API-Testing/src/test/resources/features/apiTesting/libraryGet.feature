Feature: Library API GET Operations
  As a user of the library system,
  I want to retrieve information about books via the API,
  So that I can access library resources based on my user role.

  Background:
    Given the library API is running and a book is created

  Scenario: Admin successfully fetches all books from the library
    When Admin fetch all books with valid credentials
    Then the response code for admin should be 200
    And the response should contain a list of books

  Scenario: Registered user tries to fetch all books
    When the registered user fetches all books
    Then the response code for registered user should be 200
    And the response should contain a list of books for user

  Scenario: Non-registered user tries to fetch all books
    When the non-registered user fetches all books
    Then the response code for non-registered should be 401

  Scenario: Fetch books without authentication
    When the user fetches all books without providing authentication
    Then the response code without authentication should be 401

  Scenario: Admin fetch a specific book by ID
    When Admin fetch the book with ID 6 using valid credentials
    Then the response code when a book exist should be 200
    And the response should contain the book 6 details

#  Scenario: Fetch a non-existent book
#    When I fetch the book with ID 9999 using valid credentials
#    Then the response code should be 404
#    And the response message should indicate the book was not found

