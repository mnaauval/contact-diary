#Author: mnaauval@gmail.com
Feature: Create new event

  Scenario: Create new event with data
    Given User at Main Activity
    When User tap add button
    And User tap create new event button
    And User go to New Event Activity
    And User input even name "Tourney1" and event place "Holy Avenue"
    And User input start date "05072022" and end date "05082022"
    And User input companions "All Squad" and phone "08970987809"
    And User choose encounter type and prevention type
    And User input notes "No Toxic"
    Then User save new event
    And User showed in Main Activity
