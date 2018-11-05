package com.finallab2.basquet.dao;
import java.util.List;
import com.finallab2.basquet.entity.Club;

public interface IClubDAO {
    List<Club> getAllClubs();
    Club getClubById(int clubId);
    void addClub(Club club);
    void updateClub(Club club);
    void deleteClub(int clubId);
    boolean clubExists(String nombre, String direccion);
}
 