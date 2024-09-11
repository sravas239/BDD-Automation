Feature: Print product details and cost from Automation Exercise

  Scenario: Print details of all products from the product page
    Given the user is on the Automation Exercise product page
    When the user retrieves the product names and prices
    Then the system prints the product details and their corresponding prices