Feature: Accelerate and brake
    As a player, I want the ship tho increase velocity and brake instantly.

    Scenario: Accelerate and brake the ship
        Given a game started
        When ship is moving
        Then increase gradually the velocity and decrease it instantly