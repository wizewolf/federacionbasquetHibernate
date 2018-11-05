package com.finallab2.basquet.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by WIZERWOLF on 11/7/2017.
 */
public class JugadorAddTest {
         private JugadorAdd jugador;
        @Before
        public void setUp() throws Exception {
            this.jugador = new JugadorAdd();
        }

        @After
        public void tearDown() throws Exception {
            jugador = null;
        }

        @Test
        public void getIdJugador() throws Exception {
            jugador.setIdjugador(12);
            assertEquals(12,jugador.getIdjugador());
        }

        @Test
        public void setIdJugador() throws Exception {

        }

        @Test
        public void getDni() throws Exception {
            jugador.setDni(123456);
            assertEquals(12,jugador.getDni());
        }

        @Test
        public void setDni() throws Exception {
        }

        @Test
        public void getIdclub() throws Exception {
            jugador.setIdclub(1234);
            assertEquals(12,jugador.getIdclub());
        }

        @Test
        public void setIdclub() throws Exception {
            int temporal = jugador.getIdjugador();
            jugador.setIdjugador(14);
            assertNotEquals(temporal,jugador.getIdjugador());

        }

        @Test
        public void getNombre() throws Exception {
            jugador.setNombre("mati");
            assertEquals("mati",jugador.getNombre());
        }

        @Test
        public void setNombre() throws Exception {
            String temporal = jugador.getNombre();
            jugador.setNombre("jose");
            assertNotEquals(temporal,jugador.getNombre());
        }

        @Test
        public void getApellido() throws Exception {
            jugador.setApellido("mati");
            assertEquals("mati",jugador.getApellido());
        }

        @Test
        public void setApellido() throws Exception {
            String temporal = jugador.getApellido();
            jugador.setApellido("perez");
            assertNotEquals(temporal,jugador.getApellido());

        }

        @Test
        public void getFechanac() throws Exception {
            String temp = jugador.getFechanac();
            jugador.setFechanac("02/12/2012");
            assertEquals(temp,jugador.getFechanac());

        }

        @Test
        public void setFechanac() throws Exception {
            String temporal = jugador.getFechanac();
            jugador.setFechanac("02/04/1989");
            assertNotEquals(temporal,jugador.getFechanac());
        }

        @Test
        public void getFoto() throws Exception {
            jugador.setFoto("soy una url con una foto");
            assertEquals("soy una url con una foto",jugador.getFoto());
        }
        @Test
        public void setFoto() throws Exception {
            String temporal = jugador.getFoto();
            jugador.setFoto("www.soyunafoto.com");
            assertNotEquals(temporal,jugador.getFoto());
        }

    }

