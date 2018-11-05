package com.finallab2.basquet.service;

import com.finallab2.basquet.entity.Carnet;
import com.finallab2.basquet.entity.CarnetView;


import java.util.List;

public interface ICarnetService {
     List<Carnet> getAllCarnet();
     Carnet getCarnetById(int carnetId);
     Carnet getCarnetByIdJugador(int idjugador,int anio);
     boolean addCarnet(Carnet carnet);
     void updateCarnet(Carnet carnet);
     void deleteCarnet(int carnetId);
     Carnet getCarnetxDNI(int dni, int anio);
     CarnetView mostrarCarnet(int dni);
}
