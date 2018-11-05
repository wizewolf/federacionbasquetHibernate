package com.finallab2.basquet.dao;

import com.finallab2.basquet.entity.Carnet;
import com.finallab2.basquet.entity.Club;

import java.util.List;

public interface ICarnetDAO {
    List<Carnet> getAllCarnet();
    Carnet getCarnetById(int carnetId);
    Carnet getCarnetByIdJugadorAnio(int idjugador, int anio);
    void addCarnet(Carnet carnet);
    void updateCarnet(Carnet carnet);
    void deleteCarnet(int carnetId);
    boolean carnetExists(int anio, int idjugador);

}
 