package com.finallab2.basquet.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by WIZERWOLF on 11/7/2017.
 */
public class ClubTest {
    private  Club club;
    @Before
    public void setUp() throws Exception {
        club = new Club();
    }

    @After
    public void tearDown() throws Exception {
        club=null;
        assertNull(club);
    }

    @Test
    public void getIdClub() throws Exception {
        club.setIdClub(12);
        assertEquals(12,club.getIdClub());
    }

    @Test
    public void setIdClub() throws Exception {
        int temporal = club.getIdClub();
        club.setIdClub(14);
        assertNotEquals(temporal,club.getIdClub());
    }

    @Test
    public void getNombre() throws Exception {
        club.setNombre("matias");
        assertNotNull(club.getNombre());
    }

    @Test
    public void setNombre() throws Exception {
        String temporal = club.getNombre();
        club.setNombre("juan");
        assertNotEquals(temporal,club.getNombre());

    }

    @Test
    public void getDireccion() throws Exception {
        club.setDireccion("pitagoras");
        assertNotNull(club.getDireccion());
    }

    @Test
    public void setDireccion() throws Exception {
        String temporal = club.getDireccion();
        club.setDireccion("boggio");
        assertNotEquals(temporal,club.getDireccion());
    }

}