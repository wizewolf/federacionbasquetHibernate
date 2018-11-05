package com.finallab2.basquet.dao;

import com.finallab2.basquet.entity.Carnet;
import org.hibernate.service.spi.ServiceException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CarnetDAOTest {
    private CarnetDAO carnetDAO;
    private Carnet carnet;

    @Before
    public void setUp() throws Exception {
        //this.carnetDAO = new CarnetDAO();
        carnetDAO = mock(CarnetDAO.class);
        this.carnet = new Carnet();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getCarnetById() throws Exception {
        Carnet canert = carnetDAO.getCarnetById(1);
        assertNull(canert);
    }

    @Test
    public void getCarnetByIdJugadorAnio() throws Exception {
        Carnet canert = carnetDAO.getCarnetByIdJugadorAnio(1,2017);
        assertNull(canert);
    }

    @Test
    public void getAllCarnet() throws Exception {

        //when(carnetDAO.getAllCarnet().size()).thenReturn(1);
        List<Carnet> canets = carnetDAO.getAllCarnet();
        assertNotNull(canets);

    }


    //test donde se agrega un usuario
    @Test(expected = ValidationException.class)
    public void addCarnet() throws ServiceException, ValidationException{
        carnetDAO.addCarnet(carnet);
    }

    @Test(expected = ValidationException.class)
    public void updateCarnet() throws Exception {
        carnetDAO.updateCarnet(carnet);
    }

    @Test(expected = ValidationException.class)
    public void deleteCarnet() throws ServiceException, ValidationException {
        carnetDAO.deleteCarnet(carnet.getIdcarnet());
    }

    @Test
    public void carnetExiste() throws Exception {
        boolean band = carnetDAO.carnetExists(2017,1);
        assertFalse(band);
    }
}