Feature: Product Filtering

  Scenario: Filter by Price Range
    Given User is on the product page
    When User filters with price range "2000" to "10000"
    Then Products should be filtered to within that price range

  Scenario: Filter by Category
    Given User is on the product page
    When User filters by category "Computers"
    Then Products should be filtered by category "Computers"

  Scenario: Filter by Availability
    Given User is on the product page
    When User filters by "Exclude Stock Out"
    Then Out of stock product should not be listed

  Scenario: Filter by Offers
    Given User is on the product page
    When User filters by offer "20% or More"
    Then Products that are not in the offer category should not be listed

  Scenario: Combine Multiple Filters
    Given User is on the product page
    When User applies category "Computers", price range "2000" to "5000", and offer "10% or More"
    Then Products should be filtered by all specified criteria

   Scenario: Filter by Sorting option
     Given User is on the product page
     When User sorts by "Price - Low to High"
     Then products should be sorted in "Price - Low to High" order.

   Scenario: Clear all filters
     Given User is on the product page
     When User filters with various options
     And clicks the clear all filter button
     Then all filters should be cleared