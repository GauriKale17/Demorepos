Feature: Login functionality

  Scenario Outline: Login with valid credentials
    Given User is on the login page
    When User enters "<email>" and "<password>"
    Then User should be navigated to dashboard

    Examples:
      |email|password  |
      |gaurikale2003@gmail.com|gauri@123|
