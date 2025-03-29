Feature: Add Customer functionality

  Scenario Outline: Add new customer
    Given User is on the Add Customer page
    When User enters "<name>" and "<email>" and "<phone>"
    Then The customer should be added successfully

    Examples:
      |name|email|phone|
      |shruti|shruti2003@gmail.com|9765963623|
