package features;

import android.content.Context;
import android.view.MotionEvent;

import com.example.gabrielcuenca.spaceinvaders.models.Ship;
import com.example.gabrielcuenca.spaceinvaders.models.View;

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
        float velocidad = 500;
        Ship ship = mock(Ship.class);

        if(velocidad< 500){
            velocidad += 50;
            ship.setSpeed(velocidad);
        }else{
            velocidad -=500;
            ship.setSpeed(velocidad);
        }
        expected = velocidad;
        output = ship.getSpeed();
        assertEquals(expected, output, delta);
    }

    @Then("^change the ship speed$")
    public void changeTheShipSpeed() throws Throwable {

        double delta = 0.1;
        float output;
        float expected;
        float velocidad = 1000;
        Ship ship = mock(Ship.class);

        if(velocidad< 1000){
            velocidad += 50;
            ship.setSpeed(velocidad);
        }else {
            velocidad -= 1000;
            ship.setSpeed(velocidad);
        }
        expected = velocidad;
        output = ship.getSpeed();
        assertEquals(expected, output, delta);
    }

    @When("^screen is touched$")
    public void screenIsTouched() throws Throwable {

        //View.java
        View view = mock(View.class);
        view.onTouchEvent(MotionEvent.ACTION_DOWN);

        //Ship.java
        Ship ship = mock(Ship.class);
        int direccion = ship.getDireccion();
        if (direccion  < 0){
            System.out.println();
            System.out.println("Screen is not touched");
        } else {
            System.out.println();
            System.out.println("Screen is being touched");
        }
    }

    @Then("^ship moves in that direction$")
    public void shipMovesInThatDirection() throws Throwable {
        Ship ship = mock(Ship.class);
        double delta = 0.1;
        float output;
        float expected;
        int shipMoving = 0;

        ship.setShipMoving(shipMoving);
        output = ship.getShipMoving();
        expected = shipMoving;
        assertEquals(expected, output, delta);

    }
}
