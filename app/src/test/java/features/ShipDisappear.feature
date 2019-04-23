Feature: Ship Disappear
  As a player, I want the ship to disappear randomly.

  Scenario: Random change of color
    Given a game started
    When ship is moving
    Then ship disappear