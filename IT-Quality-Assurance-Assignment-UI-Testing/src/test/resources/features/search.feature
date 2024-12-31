Feature: Search Functionality on UI-Testing

  Scenario: Searching for a single product
    Given I open the homepage
    When I search for "laptop"
    Then I should see search results related to "laptop"

  Scenario: Searching for a product with multiple keywords
    Given I open the homepage
    When I search for "gaming laptop"
    Then I should see search results related to "gaming laptop"

  Scenario: Searching for a product with special characters
    Given I open the homepage
    When I search for "laptop - 2022 edition"
    Then I should see search results related to "laptop - 2022 edition"

  Scenario: Searching for a non-existent product
    Given I open the homepage
    When I search for "xyz123nonexistentproduct"
    Then I should see a message indicating no search results were found

