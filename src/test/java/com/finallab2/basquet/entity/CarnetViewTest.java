package com.finallab2.basquet.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by WIZERWOLF on 11/7/2017.
 */
public class CarnetViewTest {
    private CarnetView cw;

    @Before
    public void setUp() throws Exception {
        this.cw=new CarnetView();
    }

    @After
    public void tearDown() throws Exception {
        cw=null;
    }

    @Test
    public void getNombreJ() throws Exception {
        cw.setNombreJ("pedro");
        assertEquals("pedro",cw.getNombreJ());
    }

    @Test
    public void setNombreJ() throws Exception {
        String temporal = cw.getNombreJ();
        cw.setNombreJ("jose");
        assertNotEquals(temporal,cw.getNombreJ());
    }

    @Test
    public void getApellidoJ() throws Exception {
        cw.setApellidoJ("gonzales");
        assertEquals("gonzales",cw.getApellidoJ());
    }

    @Test
    public void setApellidoJ() throws Exception {
        String temporal = cw.getApellidoJ();
        cw.setApellidoJ("perez");
        assertNotEquals(temporal,cw.getApellidoJ());
    }

    @Test
    public void getFoto() throws Exception {
        cw.setFoto("soy una url con una foto");
        assertEquals("soy una url con una foto",cw.getFoto());
    }

    @Test
    public void setFoto() throws Exception {
        String temporal = cw.getFoto();
        cw.setFoto("www.soyunafoto.com");
        assertNotEquals(temporal,cw.getFoto());
    }

    @Test
    public void getNombreClub() throws Exception {
        cw.setNombreClub("rodolfo ac");
        assertEquals("rodolfo ac",cw.getNombreClub());
    }

    @Test
    public void setNombreClub() throws Exception {
        String temporal = cw.getNombreClub();
        cw.setNombreClub("jdbc");
        assertNotEquals(temporal,cw.getNombreClub());
    }

    @Test
    public void getDireccionClub() throws Exception {
        cw.setDireccionClub("casco 156");
        assertEquals("casco 156",cw.getDireccionClub());
    }

    @Test
    public void setDireccionClub() throws Exception {
        String temporal = cw.getDireccionClub();
        cw.setDireccionClub("alegre 1234");
        assertNotEquals(temporal,cw.getDireccionClub());
    }

    @Test
    public void getDni() throws Exception {
        cw.setDni(15487);
        assertEquals(15487,cw.getDni());
    }

    @Test
    public void setDni() throws Exception {
        int temporal = cw.getDni();
        cw.setDni(12345);
        assertNotEquals(temporal,cw.getDni());
    }

    @Test
    public void getFechanac() throws Exception {
        Date fecha = new Date("04/04/1990");
        Date temp = cw.getFechanac();
        cw.setFechanac(fecha);
        assertEquals(temp,cw.getFechanac());

    }

    @Test
    public void setFechanac() throws Exception {
        Date temporal = cw.getFechanac();
        cw.setFechanac(new Date("02/04/1989"));
        assertNotEquals(temporal,cw.getFechanac());
    }

}