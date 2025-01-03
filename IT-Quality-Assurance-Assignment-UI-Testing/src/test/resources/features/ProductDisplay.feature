Feature: Product Availability and Details

  Scenario: Verify product availability and details
    Given I open the product page for Dell Optical Wired Mouse MS116
    When I check if the product is available
    Then I should see the product image and price displayed
