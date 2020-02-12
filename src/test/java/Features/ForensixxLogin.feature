@avoid
Feature: Forensixx login test
  Scenario: Login with DSmeritve admin
    Given the forensixx login page
    When I enter login credentials and press Login
    Then I should be logged in