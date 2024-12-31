Feature: Library API Testing
  As a library admin,
  I want to manage books in the library via the API,
  So that I can efficiently handle library operations.

  Scenario: Admin successfully fetches all books from the library
    Given the library API is running using admin
    When Admin fetch all books with valid credentials
    Then the response code should be 200
    And the response should contain a list of books

  Scenario: User successfully fetches all books from the library
    Given the library API is running using user
    When User fetch all books with valid credentials
    Then the response code for user should be 200
    And the response should contain a list of books for user

#  Scenario: Fetch books without authentication
#    When I fetch all books without authentication
#    Then the response code should be 401
#    And the response message should indicate unauthorized access

#  Scenario: Fetch a specific book by ID
#    Given a book with ID 1 exists in the library
#    When I fetch the book with ID 1 using valid credentials
#    Then the response code should be 200
#    And the response should contain the book details
#
#  Scenario: Fetch a non-existent book
#    When I fetch the book with ID 9999 using valid credentials
#    Then the response code should be 404
#    And the response message should indicate the book was not found
#
#  Scenario: Add a new book successfully
#    When I add a book with title "Serenity" and author "BDD" using valid credentials
#    Then the response code should be 201
#    And the book with title "Serenity" and author "BDD" should be added to the library
#
#  Scenario: Attempt to delete a book without sufficient privileges
#    When I delete a book with ID 1 using "user" credentials
#    Then the response code should be 403
#    And the response message should indicate forbidden access
#
