package com.finallab2.basquet.controller;

import com.finallab2.basquet.entity.Club;
import com.finallab2.basquet.entity.Jugador;
import com.finallab2.basquet.entity.JugadorAdd;
import com.finallab2.basquet.service.IJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;


@Controller
@RequestMapping("federacion")
public class JugadorController {
	@Autowired
	private IJugadorService jugadorService;
	@GetMapping("jugador/{id}")
	public ResponseEntity<Jugador> getJugadorById(@PathVariable("id") Integer id)throws Exception {
		Jugador jugador = jugadorService.getJugadorById(id);
		if (jugador==null){
			return new ResponseEntity<Jugador>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Jugador>(jugador, HttpStatus.OK);
	}
	@GetMapping("jugadores")
	public ResponseEntity<List<Jugador>> getAllJugadores() {
		List<Jugador> list = jugadorService.getAllJugadores();
		if (list==null){
			return new ResponseEntity<List<Jugador>>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<List<Jugador>>(list, HttpStatus.OK);
	}
	@PostMapping("jugador")
	public ResponseEntity<Void> addJugador(@RequestBody Jugador jugador, UriComponentsBuilder builder) throws IOException, SQLException {
		boolean flag = jugadorService.addJugador(jugador);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(jugador.getIdJugador()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("jugador")
	public ResponseEntity<Jugador> updateJugador(@RequestBody Jugador jugador) {
		jugadorService.updateJugador(jugador);
		return new ResponseEntity<Jugador>(jugador, HttpStatus.OK);
	}
	@DeleteMapping("jugador/{id}")
	public ResponseEntity<Void> deleteJugador(@PathVariable("id") Integer id) {
		jugadorService.deleteJugador(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}