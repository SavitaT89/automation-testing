Feature: Open WizzAir App

  Scenario: Launch application
    Given open the app
    When open deep link to flight
    Then verify flight details screen is displayed
