package com.finallab2.basquet.service;

import java.util.List;

import com.finallab2.basquet.entity.Club;

public interface IClubService {
     List<Club> getAllClub();
     Club getClubById(int clubId);
     boolean addClub(Club club);
     void updateClub(Club club);
     void deleteClub(int clubId);
}
