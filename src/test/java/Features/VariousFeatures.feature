@FunctionalTest
Feature: Various elements Features I

  Scenario:Check for broken images
    Given subpage for broken images and list of all images on page
    Then we check all images for Http response code

  Scenario: Right click inside context Box
    Given the subpage for context click
    When clicking inside context box
    Then alert window is displayed

  Scenario: Dropdown menu selection
    Given the subpage with dropdown menu
    When we select Option1
    Then Option1 should be selected
    When we select Option2
    Then Option2 should be selected