@FunctionalTest
Feature: AddRemoveElements
  Scenario: Add remove elements http://the-internet.herokuapp.com/add_remove_elements/
    Given Add Remove elements page
    When I click on Add element btn
    Then Element should be added and Delete btn should be seen
    When I click Delete btn 10 times
    Then Btns should be removed