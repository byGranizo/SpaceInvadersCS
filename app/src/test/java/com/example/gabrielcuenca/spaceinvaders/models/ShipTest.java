package com.example.gabrielcuenca.spaceinvaders.models;

import org.junit.Before;
import org.junit.Test;

import android.content.Context;

import static org.junit.Assert.*;

//Clase para testear el metodo cambiarVelocidad de Ship. Esta funcionalidad se ha añadido
// mediante TDD, por lo que hemos implementado primero el test.
public class ShipTest {
    Ship ship;
    Context context;


    int screenY;
    int screenX;



    @Before
    public void setUp() throws Exception {
        context = null;

        screenY = 1000;
        screenX = 100;

        ship = new Ship(context, screenX,  screenY);
    }

    //Hacemos el test
    @Test
    public void cambiarVelocidad() {
        double delta = 0.1;
        float output;
        float expected;
        float velocidad = 300;

        if(velocidad<= 500){
            velocidad += 50;
            ship.setSpeed(velocidad);
        }else{
            velocidad -=400;
            ship.setSpeed(velocidad);
        }
        expected = velocidad;
        output = ship.getSpeed();
        assertEquals(expected, output, delta);
    }
}