Feature: Red Loyalty Points Functionality

  Scenario: Accessing the Red Loyalty Points page
    Given I am on the homepage
    When I click the Red Loyalty Tab
    Then I should be redirected to the Red Loyalty page

  Scenario: Navigating to the form page
    Given I am on the Red Loyalty page
    When I click the "Check Red Points and Loyalty Status" button
    Then I should be redirected to the form page

#  Scenario: Checking Red Points with a valid NIC
#    Given I am on the form page
#    When I enter a valid NIC "199012345678"
#    And I click the Submit button
#    Then I should see the available red points
#
#  Scenario: Checking Red Points with an invalid NIC
#    Given I am on the form page
#    When I enter an invalid NIC "12345678"
#    And I click the Submit button
#    Then I should see the message as "Invalid NIC"
#
#  Scenario: Checking Red Points with no validation
#    Given I am on the form page
#    When I enter a random NIC "invalidNIC123"
#    And I click the Submit button
#    Then the system should not return points but show an error message
#
#  Scenario: Checking whether the points show with a blank NIC field
#    Given I am on the form page
#    When I submit the form without entering a NIC
#    Then I should see a validation message asking to enter a NIC



