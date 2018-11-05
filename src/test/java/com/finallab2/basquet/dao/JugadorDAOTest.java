package com.finallab2.basquet.dao;

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
public class JugadorDAOTest {
    private JugadorDAO jugadorDAO;
    private Jugador jugador;

    @Before
    public void setUp() throws Exception {
        jugadorDAO= mock(JugadorDAO.class);
        this.jugador = new Jugador();
    }

    @After
    public void tearDown() throws Exception {
        jugadorDAO=null;
        this.jugador = null;

    }

    @Test
    public void getJugadorById() throws Exception {

    }

    @Test
    public void getAllJugadores() throws Exception {
        List<Jugador> jugadors = jugadorDAO.getAllJugadores();
        assertNotNull(jugadors);
    }
    //si tira la exepcion es porq paso el test
    @Test(expected = ValidationException.class)
    public void addJugador() throws ServiceException,ValidationException {
        jugadorDAO.addJugador(jugador);
    }

    @Test(expected = ValidationException.class)
    public void updateJugador() throws ServiceException,ValidationException {
        jugadorDAO.updateJugador(jugador);
    }

    @Test(expected = ValidationException.class)
    public void deleteJugador() throws ServiceException,ValidationException{
        jugadorDAO.deleteJugador(jugador.getIdJugador());

    }

    @Test
    public void jugadorExists() throws Exception {
        boolean band = jugadorDAO.jugadorExists(123);
        assertFalse(band);
    }

    @Test
    public void getDni() throws Exception {
        Jugador jugador = jugadorDAO.getDni(124);
        assertNull(jugador);
    }

}