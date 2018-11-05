package com.finallab2.basquet.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by WIZERWOLF on 11/7/2017.
 */
public class CarnetTest {
    private Carnet carnet;
    @Before
    public void setUp() throws Exception {
        this.carnet = new Carnet();
    }

    @After
    public void tearDown() throws Exception {
        this.carnet = null;
    }
    @Test
    public void getIdcarnet() throws Exception {
        carnet.setIdcarnet(14);
        assertEquals(14,carnet.getIdcarnet());
    }

    @Test
    public void setIdcarnet() throws Exception {
        int temporal = carnet.getIdcarnet();
        carnet.setIdcarnet(14);
        assertNotEquals(temporal,carnet.getIdcarnet());
    }

    @Test
    public void getAnioDeSeguro() throws Exception {
        carnet.setgetAnioDeSeguro(2014);
        assertEquals(2014,carnet.getAnioDeSeguro());
    }

    @Test
    public void setgetAnioDeSeguro() throws Exception {
        int temporal = carnet.getAnioDeSeguro();
        carnet.setgetAnioDeSeguro(2014);
        assertNotEquals(temporal,carnet.getAnioDeSeguro());
    }

    @Test
    public void getIdjugador() throws Exception {
        carnet.setIdjugador(14);
        assertEquals(14,carnet.getIdjugador());
    }

    @Test
    public void setIdjugador() throws Exception {
        int temporal = carnet.getIdjugador();
        carnet.setIdjugador(14);
        assertNotEquals(temporal,carnet.getIdjugador());
    }



}