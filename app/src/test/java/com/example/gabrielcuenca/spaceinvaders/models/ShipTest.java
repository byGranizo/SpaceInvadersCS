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
    
    @Test
    public void setShipMoving() {
        double delta = 0.1;
        float output;
        float expected;

        for (int shipMoving = 0; shipMoving <= 4; shipMoving ++){
            ship.setShipMoving(shipMoving);
            expected = shipMoving;
            output = ship.getShipMoving();
            assertEquals(expected, output, delta);
        }
    }
    
    @Test
    public void update() {
        double delta = 0.1;
        float outputTop;
        float outputLeft;
        float outputBotton;
        float outputRight;
        float expectedTop;
        float expectedLeft;
        float expectedBottom;
        float expectedRight;
        float x = 1000;
        float y = 1000;
        float shipSpeed = 200;
        float length = 500;
        float height = 500;

        for (long fps = 1; fps <= 10; fps ++){
            for (int shipMoving = 1; shipMoving <= 4; shipMoving ++){
                ship.setX(x);
                ship.setY(y);
                ship.setSpeed(shipSpeed);
                ship.setLength(length);
                ship.setHeight(height);
                ship.setShipMoving(shipMoving);
                ship.update(fps);
                outputTop = ship.getRect().top;
                outputBotton = ship.getRect().bottom;
                outputLeft = ship.getRect().left;
                outputRight = ship.getRect().right;

                if(shipMoving == 1){
                    if(x>0){
                        x = x - shipSpeed / fps;
                    }
                }else if(shipMoving == 2){
                    if(x<length*9){
                        x = x + shipSpeed / fps;
                    }
                }else if(shipMoving == 3){
                    if (y>0){
                        y = y - shipSpeed / fps;
                    }
                }else if (shipMoving == 4){
                    y = y + shipSpeed / fps;
                }
                expectedTop = y;
                expectedBottom=  y + height;
                expectedLeft = x + 5;
                expectedRight = x + length-5;

                assertEquals(expectedTop, outputTop, delta);
                assertEquals(expectedBottom, outputBotton, delta);
                assertEquals(expectedLeft, outputLeft, delta);
                assertEquals(expectedRight, outputRight, delta);

            }
        }
    }
    
    @Test
    public void desaparecer() {
        double delta = 0.1;
        float output;
        float expected;

       
        ship.desaparecer();
        output = ship.getX();
        expected = -300;
        assertEquals(expected, output, delta);
    }
}