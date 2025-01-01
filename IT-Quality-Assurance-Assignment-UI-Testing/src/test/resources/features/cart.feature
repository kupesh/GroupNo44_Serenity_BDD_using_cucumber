Feature: Add to Cart Functionality

  Scenario: Adding a single product to the cart
    Given I open the product page for "Refrigerator"
    When I click Add to Cart
    Then I should see the message "added to"
    And the cart should show 1 item

  Scenario: Adding multiple quantities of the same product to the cart
    Given I open the product page for "Microwave"
    When I set the quantity to "2"
    And I click Add to Cart
    Then I should see the message "Product added to cart"
    And the cart should show 2 items of "Microwave"

#  Scenario: Adding different products to the cart
#    Given I add "Toaster" to the cart
#    And I add "Blender" to the cart
#    Then the cart should show 2 items
#    And the cart total should be updated correctly
#
#  Scenario: Adding a product when not logged in
#    Given I am not logged in
#    When I open the product page for "Washing Machine"
#    When I click Add to Cart
#    Then I should be prompted to log in or continue as a guest
#
#  Scenario: Adding an out-of-stock product to the cart
#    Given I open the product page for "Vacuum Cleaner"
#    And the product is marked as "Out of Stock"
#    When I click Add to Cart
#    Then I should see the message "Product is out of stock and cannot be added to the cart"
#
#  Scenario: Adding a product with invalid quantity
#    Given I open the product page for "Air Conditioner"
#    When I set the quantity to "-1"
#    And I click "Add to Cart"
#    Then I should see the message "Invalid quantity. Please enter a valid number"
#    And the product should not be added to the cart