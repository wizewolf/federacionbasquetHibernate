package com.finallab2.basquet.service;

import com.finallab2.basquet.dao.ICarnetDAO;
import com.finallab2.basquet.dao.IClubDAO;
import com.finallab2.basquet.dao.IJugadorDAO;
import com.finallab2.basquet.entity.Carnet;
import com.finallab2.basquet.entity.CarnetView;
import com.finallab2.basquet.entity.Club;
import com.finallab2.basquet.entity.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarnetService implements ICarnetService {
    @Autowired
    private ICarnetDAO carnetDAO;
    @Autowired
    private IJugadorDAO jugadorDAO;
    @Autowired
    private IClubDAO clubDAO;

    @Override
    public Carnet getCarnetById(int carnetId) {
        Carnet obj = carnetDAO.getCarnetById(carnetId);
        if (obj == null) {
            return null;
        }
        return obj;
    }

    @Override
    public Carnet getCarnetByIdJugador(int idjugador, int anio) {
        Carnet obj = carnetDAO.getCarnetByIdJugadorAnio(idjugador, anio);
        if (obj == null) {
            return null;
        }
        return obj;
    }

    @Override
    public List<Carnet> getAllCarnet() {
        return carnetDAO.getAllCarnet();
    }

    @Override
    public synchronized boolean addCarnet(Carnet carnet) {
        if (carnetDAO.carnetExists(carnet.getAnioDeSeguro(), carnet.getIdjugador())) {
            return false;
        } else {
            carnetDAO.addCarnet(carnet);
            return true;
        }
    }

    @Override
    public void updateCarnet(Carnet carnet) {
        carnetDAO.updateCarnet(carnet);
    }

    @Override
    public void deleteCarnet(int carnetId) {
        carnetDAO.deleteCarnet(carnetId);
    }

    @Override
    public Carnet getCarnetxDNI(int dni, int anio) {
        Jugador jg = jugadorDAO.getDni(dni);
        if (jg != null) {
            return carnetDAO.getCarnetByIdJugadorAnio(jg.getIdJugador(), anio);
        } else {
            return null;
        }

    }

    @Override
    public CarnetView mostrarCarnet(int dni) {
        Jugador jugador = jugadorDAO.getDni(dni);
        if (jugador == null) {
            return null;
        }
        Club club = clubDAO.getClubById(jugador.getIdclub());
        if (club == null) {
            return null;
        }
        CarnetView cw = new CarnetView();
        cw.setApellidoJ(jugador.getApellido());
        cw.setNombreJ(jugador.getNombre());
        cw.setDni(jugador.getDni());
        cw.setFechanac(jugador.getFechanac());
        cw.setFoto(jugador.getFoto());
        cw.setNombreClub(jugador.getNombre());
        cw.setDireccionClub(club.getDireccion());
        return cw;
    }
}
