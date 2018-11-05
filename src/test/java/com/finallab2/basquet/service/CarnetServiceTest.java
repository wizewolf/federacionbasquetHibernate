package com.finallab2.basquet.service;

import com.finallab2.basquet.dao.*;
import com.finallab2.basquet.entity.Carnet;
import com.finallab2.basquet.entity.CarnetView;
import com.finallab2.basquet.entity.Jugador;
import org.hibernate.service.spi.ServiceException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.ValidationException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by WIZERWOLF on 11/7/2017.
 */
public class CarnetServiceTest {

    private CarnetService carnetService;
    private Carnet carnet;

    @Before
    public void setUp() throws Exception {
        carnetService = mock(CarnetService.class);
        this.carnet = new Carnet();
    }

    @After
    public void tearDown() throws Exception {
        carnetService=null;
        this.carnet=null;
    }

    @Test
    public void getCarnetById() throws Exception {
        Carnet carnet = carnetService.getCarnetById(1);
        assertNull(carnet);

    }

    @Test
    public void getCarnetByIdJugador() throws Exception {
        Carnet carnet = carnetService.getCarnetByIdJugador(1,2017);
        assertNull(carnet);
    }

    @Test
    public void getAllCarnet() throws Exception {
        List<Carnet> canets = carnetService.getAllCarnet();
        assertNotNull(canets);
    }

    @Test(expected = ValidationException.class)
    public void addCarnet() throws ServiceException, ValidationException {
        boolean band = carnetService.addCarnet(carnet);
        assertNull(band);
    }

    @Test(expected = ValidationException.class)
    public void updateCarnet() throws ServiceException, ValidationException {
        carnetService.updateCarnet(carnet);
    }

    @Test(expected = ValidationException.class)
    public void deleteCarnet() throws ServiceException, ValidationException{
        carnetService.deleteCarnet(1);
    }

    @Test
    public void getCarnetxDNI() throws Exception {
        Carnet carnet = carnetService.getCarnetxDNI(1234678,2017);
        assertNull(carnet);
    }

    @Test
    public void mostrarCarnet() throws Exception {
        CarnetView cw = carnetService.mostrarCarnet(12345678);
        assertNull(carnet);
    }

}