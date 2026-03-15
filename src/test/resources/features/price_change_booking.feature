Feature: Handle price change during booking

  Scenario:Price change during booking
    Given I search and select a flight
    When I start the booking process
    And a price change modal appears
    Given Select Flight

