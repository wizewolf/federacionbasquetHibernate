package com.finallab2.basquet.dao;

import com.finallab2.basquet.entity.Carnet;
import com.finallab2.basquet.entity.Club;
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
public class ClubDAOTest {
    private ClubDAO clubDAO;
    private Club club;

    @Before
    public void setUp() throws Exception {
        //this.carnetDAO = new CarnetDAO();
        clubDAO = mock(ClubDAO.class);
        this.club = new Club();
    }

    @After
    public void tearDown() throws Exception {
        clubDAO = null;
        this.club = null;

    }

    @Test
    public void getCarnetById() throws Exception {
        Club club = clubDAO.getClubById(1);
        assertNull(club);
    }

     @Test
    public void getAllCarnet() throws Exception {

        //when(carnetDAO.getAllCarnet().size()).thenReturn(1);
        List<Club> clubs = clubDAO.getAllClubs();
        assertNotNull(clubs);

    }


    //test donde se agrega un usuario
    @Test(expected = ValidationException.class)
    public void addCarnet() throws ServiceException, ValidationException{
        clubDAO.addClub(club);
    }

    @Test(expected = ValidationException.class)
    public void updateCarnet() throws Exception {
        clubDAO.updateClub(club);
    }

    @Test(expected = ValidationException.class)
    public void deleteCarnet() throws ServiceException, ValidationException {
        clubDAO.deleteClub(club.getIdClub());
    }
    @Test
    public void clubExists() throws Exception {
        boolean band = clubDAO.clubExists("sarmiento","avalos");
        assertFalse(band);
    }

}