package com.finallab2.basquet.service;

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
public class ClubServiceTest {
    private ClubService clubService;
    private Club club;
    @Before
    public void setUp() throws Exception {
        clubService = mock(ClubService.class);
        this.club = new Club();
    }

    @After
    public void tearDown() throws Exception {
        clubService = null;
        this.club = null;

    }

    @Test
    public void getClubById() throws Exception {
        Club club = clubService.getClubById(1);
        assertNull(club);
    }

    @Test
    public void getAllClub() throws Exception {
        List<Club> clubs = clubService.getAllClub();
        assertNotNull(clubs);
    }

    @Test(expected = ValidationException.class)
    public void addClub() throws ServiceException, ValidationException{
        boolean band = clubService.addClub(club);
        assertNull(band);
    }

    @Test(expected = ValidationException.class)
    public void updateClub()throws ServiceException, ValidationException {
        clubService.updateClub(club);
    }

    @Test(expected = ValidationException.class)
    public void deleteClub()throws ServiceException, ValidationException {
        clubService.deleteClub(1);
    }

}