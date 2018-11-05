package com.finallab2.basquet.service;

import java.util.List;

import com.finallab2.basquet.dao.IClubDAO;
import com.finallab2.basquet.entity.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService implements IClubService {
	@Autowired
	private IClubDAO clubDao;
	@Override
	public Club getClubById(int clubId) {
		Club obj = clubDao.getClubById(clubId);
		return obj;
	}	

	@Override
	public List<Club> getAllClub() {
		return clubDao.getAllClubs();
	}

	@Override
	public synchronized boolean addClub(Club club){
       if (clubDao.clubExists(club.getNombre(), club.getDireccion())) {
    	   return false;
       } else {
    	   clubDao.addClub(club);
    	   return true;
       }
	}

	@Override
	public void updateClub(Club club) {
		clubDao.updateClub(club);
	}

	@Override
	public void deleteClub(int clubId) {
		clubDao.deleteClub(clubId);
	}
}
