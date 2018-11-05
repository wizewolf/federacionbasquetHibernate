package com.finallab2.basquet.controller;

import com.finallab2.basquet.entity.Carnet;
import com.finallab2.basquet.service.ICarnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;


@Controller
@RequestMapping("federacion")
public class CarnetController {
	@Autowired
	private ICarnetService carnetService;
	@GetMapping("carnet/{id}")
	public ResponseEntity<Carnet> getCarnetById(@PathVariable("id") Integer id) {
		Carnet jugador = carnetService.getCarnetById(id);
		return new ResponseEntity<Carnet>(jugador, HttpStatus.OK);
	}


	@GetMapping("carnet/jugador/")
	public ResponseEntity<Carnet> getCarnetByIdJugador(@RequestParam("id") String id,@RequestParam("anio") String anio){
		Carnet carnet = carnetService.getCarnetByIdJugador(Integer.valueOf(id),Integer.valueOf(anio));
		if (carnet==null){
			return new ResponseEntity<Carnet>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Carnet>(carnet, HttpStatus.OK);
	}


	@GetMapping("carnet/jugadorDNI/")
	public ResponseEntity<Carnet> getCarnetxDNI(@RequestParam("dni") String dni,@RequestParam("anio") String anio){
		Carnet carnet = carnetService.getCarnetByIdJugador(Integer.valueOf(dni),Integer.valueOf(anio));
		if (carnet==null){
			return new ResponseEntity<Carnet>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Carnet>(carnet, HttpStatus.OK);
	}


	@GetMapping("carnet")
	public ResponseEntity<List<Carnet>> getAllCarnet(){
		List<Carnet> list = carnetService.getAllCarnet();
		if (list.size()==0){
			return new ResponseEntity<List<Carnet>>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<List<Carnet>>(list, HttpStatus.OK);
	}


	@PostMapping("carnet")
	public ResponseEntity<Void> addCarnet(@RequestBody Carnet carnet, UriComponentsBuilder builder) {
		boolean flag = carnetService.addCarnet(carnet);
        if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(carnet.getIdcarnet()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("carnet")
	public ResponseEntity<Carnet> updateCarnet(@RequestBody Carnet carnet)  {
		carnetService.updateCarnet(carnet);
		return new ResponseEntity<Carnet>(carnet, HttpStatus.OK);
	}


	@DeleteMapping("carnet/{id}")
	public ResponseEntity<Void> deleteCarnet(@PathVariable("id") Integer id) throws Exception {
		carnetService.deleteCarnet(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


	@DeleteMapping("carnet/generar/")
	public ResponseEntity<Void> deleteCarnet(@RequestParam("dni") String dni) throws Exception {
		carnetService.mostrarCarnet(Integer.valueOf(dni));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}