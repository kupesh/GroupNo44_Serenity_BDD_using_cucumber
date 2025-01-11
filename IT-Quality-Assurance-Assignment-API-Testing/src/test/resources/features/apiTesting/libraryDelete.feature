Feature: Library API DELETE Operations

  Background:
    Given the library API is running and book with ID 2 available


  Scenario: Admin delete a book by ID 2
    When Admin delete a book using book ID 2
    Then the response code after deleting the book should be 200

  Scenario Outline: <role> delete a book by ID <bookId>When <role> try to delete a book using book ID <bookId>
    Then the response code should be <code> as user is not permitted

    Examples:
      | role  | bookId | code |
      | User  | 3      | 403        |
      | Non registered user | 2 | 401 |

