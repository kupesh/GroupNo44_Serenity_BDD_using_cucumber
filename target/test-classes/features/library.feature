Feature: Library API Testing

  Scenario: Fetch all books
    Given the library API is running
    When I fetch all books
    Then the response code should be 200
    And the response should not be empty

  Scenario: Add a new book
    Given the library API is running
    When I add a book with title "Serenity" and author "BDD"
    Then the response code should be 201
    And the book should be added to the library
