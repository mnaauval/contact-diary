#Author: mnaauval@gmail.com
Feature: Create new contact

  Scenario: Create new contact with data
    Given User at Main Activity
    When User tap add button
    And User tap create new contact button
    And User go to New Contact Activity
    And User input contact name "Flopson" and place "Wings Scarlet"
    And User input start date "21072022" and end date "28112022"
    And User input phone "09871234" and notes "Mid player"
    And User choose known and type
    Then User save new contact
    And Contact showed in Main Activity
