package com.immobilier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.immobilier.dto.ProprietaireDto;
import com.immobilier.serviceImple.ProprietaireServiceImple;

@CrossOrigin
@RestController
public class ProprietaireController {
	
	@Autowired
	ProprietaireServiceImple proprietaireServiceImple;
	
	@PostMapping("/proprietaire")
	public ProprietaireDto ajouterProprietaire(@RequestBody ProprietaireDto proprietaireDto) {
		return proprietaireServiceImple.saveProprietaire(proprietaireDto);
	}
	
	@PutMapping("/proprietaire/{uuid}")
	public ProprietaireDto modifierProprietaire(@RequestBody ProprietaireDto proprietaireDto,@PathVariable String uuid) {	
		return proprietaireServiceImple.updateProprietaire(proprietaireDto, uuid);
	}
	
	@DeleteMapping("/proprieatire/{uuid}")
	public void supprimerProprietaire(@PathVariable String uuid) {
		proprietaireServiceImple.deleteProprietaire(uuid);
	}

	@GetMapping("/proprietaire/{uuid}")
	public ProprietaireDto rehcrecher(@PathVariable String uuid) {
		return proprietaireServiceImple.getByuuid(uuid);
	}
	
	@GetMapping("/proprietaire")
	public List<ProprietaireDto> afficherProprietaire(){	
		return proprietaireServiceImple.findAllProprietaire();
	}
	@GetMapping("/proprietaire/total")
	public long getTotalProprietaire(){	
		return proprietaireServiceImple.getTotalProprietaire();
	}
}
