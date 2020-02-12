@FunctionalTest
Feature: CheckBoxes

  Scenario:  CheckBoxes
    Given The checkboxes page
    When I click checkbox1
    Then it should be selected
    When I click checkbox2
    Then Checkbox2 should be de-selected