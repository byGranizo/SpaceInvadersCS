Feature: Ship Disappear
  As a player, I want the ship to disappear randomly.

  Scenario: Random ship disappear
    Given a game started
    When ship is moving
    Then ship disappear