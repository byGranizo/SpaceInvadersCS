package com.example.gabrielcuenca.spaceinvaders;

import android.content.Context;
import com.example.gabrielcuenca.spaceinvaders.models.Invader;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvaderTest {

    Context context;
    Invader invader;

    int columna;
    int fila;
    int pantallaY;
    int pantallaX;


    @Before
    public void setUp() throws Exception {
        context = null;
        columna = 1;
        fila = 1;
        pantallaY = 1000;
        pantallaX = 100;

        invader = new Invader(context, columna, fila, pantallaY, pantallaX);
    }

    @Test
    public void automaticMove() {
        int yup = 1;
        double delta = 0.1;
        float outputDireccion;
        float outputYup;
        float expectedDireccion;
        float expectedYup;
float pantallY = 1000;

        for (int direccion=1; direccion<=2; direccion++){
            invader.setDireccion(direccion);
            if (direccion == 1){
                expectedDireccion = 2;
            }else{
                expectedDireccion = 1;
            }
            invader.automaticMove();
            outputDireccion = invader.getDireccion();
            assertEquals(expectedDireccion, outputDireccion, delta);
        }


//        expectedYup = pantallaY/15 + yup; // pantallaY = 1000 yup =1
//        invader.setYup(yup);
//        invader.automaticMove();
//        outputYup = invader.getY();
//        assertEquals(expectedYup, outputYup, delta);


    }
}