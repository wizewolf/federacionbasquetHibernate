package com.finallab2.basquet.controller;
import java.util.List;

import com.finallab2.basquet.entity.Club;
import com.finallab2.basquet.service.IClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
@RequestMapping("federacion")
public class ClubController {
	@Autowired
	private IClubService clubService;
	@GetMapping("club/{id}")
	public ResponseEntity<Club> getClubById(@PathVariable("id") Integer id) {
		Club club = clubService.getClubById(id);
		if (club==null){
			return new ResponseEntity<Club>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Club>(club, HttpStatus.OK);
	}
	@GetMapping("clubs")
	public ResponseEntity<List<Club>> getAllClubs() {
		List<Club> list = clubService.getAllClub();
		if (list==null){
			return new ResponseEntity<List<Club>>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<List<Club>>(list, HttpStatus.OK);
	}
	@PostMapping("club/add")
	public ResponseEntity<Void> addClub(@RequestBody Club club, UriComponentsBuilder builder) {
        boolean flag = clubService.addClub(club);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(club.getIdClub()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("club/update")
	public ResponseEntity<Club> updateClub(@RequestBody Club club) {
		clubService.updateClub(club);
		return new ResponseEntity<Club>(club, HttpStatus.OK);
	}
	@DeleteMapping("club/delete/{id}")
	public ResponseEntity<Void> deleteClub(@PathVariable("id") Integer id) {
		clubService.deleteClub(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}