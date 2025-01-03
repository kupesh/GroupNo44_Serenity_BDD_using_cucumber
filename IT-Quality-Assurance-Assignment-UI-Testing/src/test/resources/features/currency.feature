Feature: Currency Functionality

  As a user
  I want to be able to change the currency
  So that I can view prices in my preferred currency

  Scenario: Change Currency and Verify Selected Value
    Given I open the HomePage for currency testing
    When I change the currency to "usd"
    Then the currency should be changed to "USD"

  Scenario: Verify Consistent Currency Display Across Website
    Given I open the HomePage for currency testing
    When I change the currency to "usd"
    Then the currency should be changed to "USD"
    And I should verify the currency displayed is "USD" across the website

    Scenario: Verify that the page shows the LKR by default
    Given I open the HomePage for currency testing
    Then the currency should be changed to "LKR"