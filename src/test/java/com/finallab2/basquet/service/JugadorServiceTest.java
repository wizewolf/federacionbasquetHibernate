package com.finallab2.basquet.service;

import com.finallab2.basquet.entity.Jugador;
import org.hibernate.service.spi.ServiceException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.ValidationException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by WIZERWOLF on 11/7/2017.
 */
public class JugadorServiceTest {
    private JugadorService jugadorService;
    private Jugador jugador;
    @Before
    public void setUp() throws Exception {
        jugadorService = mock(JugadorService.class);
        this.jugador = new Jugador();
    }

    @After
    public void tearDown() throws Exception {
        jugadorService = null;
        this.jugador = null;
    }

    @Test
    public void getJugadorById() throws Exception {
        Jugador jugador = jugadorService.getJugadorById(17);
        assertNull(jugador);
    }

    @Test
    public void getAllJugadores() throws Exception {
        List<Jugador> jugadors = jugadorService.getAllJugadores();
        assertNotNull(jugadors);
    }

    @Test
    public void addJugador() throws Exception {
        boolean band = jugadorService.addJugador(jugador);
        assertFalse(band);
    }

    @Test(expected = ValidationException.class)
    public void updateJugador() throws ServiceException, ValidationException {
        jugadorService.updateJugador(jugador);
    }

    @Test(expected = ValidationException.class)
    public void deleteJugador()  throws ServiceException, ValidationException {
        jugadorService.deleteJugador(jugador.getIdJugador());
    }



}