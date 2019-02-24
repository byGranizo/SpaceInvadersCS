package com.example.gabrielcuenca.spaceinvaders.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Clase para testear el metodo cambiarADireccionOpuesta del misile
public class MisileTest {
    Misile misile;

    int screenY;

    @Before
    public void setUp() throws Exception {
        screenY = 1000;

        misile = new Misile(screenY);
    }

    //Hacemos el test
    @Test
    public void cambiarADireccionOpuesta() {
        double delta = 0.1;
        int output;
        int expected;

        //Comprobamos las dos direcciones disponibles (DOWN y UP)
        for (int direccion = 0; direccion<=1; direccion ++){ //Down->0 Up->1
            misile.setDireccion(direccion);
            if (direccion == 0){
                expected = 1; //Esto es lo que esperamos que devuelva
            }else{
                expected = 0; //Esto es lo que esperamos que devuelva
            }
            misile.cambiarADireccionOpuesta(); //Llamamos al metodo a probar
            output = misile.getDireccion(); //Recogemos lo que devuelve
            assertEquals(expected, output, delta); //Comprobamos si lo que devuelve y lo que esperamos es igual
        }
    }
}
