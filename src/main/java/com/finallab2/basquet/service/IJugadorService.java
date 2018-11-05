package com.finallab2.basquet.service;

import com.finallab2.basquet.entity.Jugador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IJugadorService {
     List<Jugador> getAllJugadores();
     Jugador getJugadorById(int jugadorId) throws Exception;
     boolean addJugador(Jugador jugador) throws IOException, SQLException;
     void updateJugador(Jugador jugador);
     void deleteJugador(int jugadorId);
}
