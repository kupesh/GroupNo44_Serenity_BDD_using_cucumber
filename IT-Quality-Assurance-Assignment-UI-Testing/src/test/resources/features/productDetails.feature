Feature: Search Functionality on UI-Testing

  Scenario: Viewing details of a valid product
    Given I navigate to the product detail page for product "12345"
    Then I should see the product title "Sample Product"
    And I should see a product description that is not empty
    And I should see a price displayed in "USD"

  Scenario: Validating product images on the product detail page
    Given I navigate to the product detail page for product "12345"
    Then I should see a high-quality main product image
    And I should be able to navigate through the image gallery
    And the zoom feature should work on the product image

  Scenario: Adding a product to the cart from the product detail page
    Given I navigate to the product detail page for product "12345"
    When I click on the "Add to Cart" button
    Then the product should be successfully added to the cart
    And the cart icon should display the updated item count
    And the total price in the cart should be updated correctly

  Scenario: Viewing an out-of-stock product
    Given I navigate to the product detail page for product "67890"
    Then I should see the product title "Unavailable Product"
    And I should see a message indicating "Out of Stock"
    And the "Add to Cart" button should be disabled

  Scenario: Viewing details for a non-existent product
    Given I navigate to the product detail page for product "99999"
    Then I should see an error message "Product not found"
    And the page should redirect to the home page after 5 seconds
