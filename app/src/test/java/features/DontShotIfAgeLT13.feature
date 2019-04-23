Feature: Younger then 13
    As a player, I want the game prepared for younger people.

    Scenario: Younger player
        Given the app started
        When player is younger then 13
        Then enemies won't be able to shot