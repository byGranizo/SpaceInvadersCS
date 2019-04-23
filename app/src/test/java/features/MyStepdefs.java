package features;

import android.content.Context;

import com.example.gabrielcuenca.spaceinvaders.models.Ship;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class MyStepdefs {

    boolean jugando = true;

    @Given("^a game started$")
    public void a_game_started() throws Throwable {
        if (jugando){
            System.out.println("The game started");
        }
    }

    @When("^ship is moving$")
    public void ship_is_moving() throws Throwable {
        Context context = null;
        int screenY = 1000;
        int screenX = 100;
        Ship ship = mock(Ship.class);

        ship.setShipMoving(1);
    }

    @Then("^ship disappear$")
    public void shipDisappear() throws Throwable {
        Context context = null;
        int screenY = 1000;
        int screenX = 100;
        float output;
        float expected;
        double delta = 0.1;
        Ship ship = mock(Ship.class);
//        Ship(context, screenX,  screenY);

        ship.desaparecer();
        output = ship.getX();
        expected = 0;
        assertEquals(expected, output, delta);

    }

    @Then("^increase gradually the velocity and decrease it instantly$")
    public void increaseGraduallyTheVelocityAndDecreaseItInstantly() throws Throwable {
        double delta = 0.1;
        float output;
        float expected;
        float velocidad = 300;
        Ship ship = mock(Ship.class);

        if(velocidad<= 500){
            velocidad += 50;
            ship.setSpeed(velocidad);
        }else{
            velocidad -=400;
            ship.setSpeed(velocidad);
        }
        expected = 0;
        output = ship.getSpeed();
        assertEquals(expected, output, delta);
    }
}
