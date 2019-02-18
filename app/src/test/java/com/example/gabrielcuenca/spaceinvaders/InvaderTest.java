package com.example.gabrielcuenca.spaceinvaders;

import com.example.gabrielcuenca.spaceinvaders.models.Invader;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Clase para testear el metodo automaticMove del invader
public class InvaderTest {

    Invader invader;

    int columna;
    int fila;
    int pantallaY;
    int pantallaX;


    @Before
    public void setUp() throws Exception {
        columna = 1;
        fila = 1;
        pantallaY = 1000;
        pantallaX = 100;

        invader = new Invader(null, columna, fila, pantallaY, pantallaX);
    }

    //Hacemos el test
    @Test
    public void automaticMove() {
        int yup = 1;
        double delta = 0.1;
        float outputDireccion;
        float outputYup;
        float expectedDireccion;
        float expectedYup;

        //Comprobamos las dos direcciones disponibles (Right y left)
        for (int direccion=1; direccion<=2; direccion++){ //Left->1 Right->2
            invader.setDireccion(direccion);
            if (direccion == 1){
                expectedDireccion = 2; //Esto es lo que esperamos que devuelva
            }else{
                expectedDireccion = 1; //Esto es lo que esperamos que devuelva
            }
            invader.automaticMove(); //Llamamos al metodo a probar
            outputDireccion = invader.getDireccion(); //Recogemos lo que devuelve
            assertEquals(expectedDireccion, outputDireccion, delta); //Comprobamos si lo que devuelve y lo que esperamos es igual
        }


        expectedYup = pantallaY/15 + yup; //Esto es lo que esperamos que devuelva
        invader.setYup(yup);
        invader.automaticMove(); //Llamamos al metodo a probar
        outputYup = invader.getY(); //Recogemos lo que devuelve
        assertEquals(expectedYup, outputYup, delta); //Comprobamos si lo que devuelve y lo que esperamos es igual


    }
}