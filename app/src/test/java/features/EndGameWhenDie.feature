Feature: End game
    As a player, I want the game to end when the ship has died.

    Scenario: End game 
        Given a game started
        When ship health become 0
        Then disappear the ship and go to ranking