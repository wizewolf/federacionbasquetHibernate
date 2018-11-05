package com.finallab2.basquet.dao;

import com.finallab2.basquet.entity.Jugador;

import java.util.List;

public interface IJugadorDAO {
    List<Jugador> getAllJugadores();
    Jugador getJugadorById(int jugadorId)throws Exception;
    void addJugador(Jugador jugador);
    void updateJugador(Jugador jugador);
    void deleteJugador(int jugadorId);
    boolean jugadorExists(int dni);
    Jugador getDni(int dni);
}
 