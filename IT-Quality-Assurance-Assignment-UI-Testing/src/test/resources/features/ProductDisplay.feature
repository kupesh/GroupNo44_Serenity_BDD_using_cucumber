Feature: Product Display on the Product Listing Page

  Scenario: Checking the product name
    Given I am on the product listing page to check the name
    When I check if the product name is visible

  Scenario: Checking the product image
    Given I am on the product listing page to check the image
    When I check if the product image is visible

  Scenario: Checking the product price
    Given I am on the product listing page to check the price
    When I check if the product price is visible
