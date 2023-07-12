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

import com.immobilier.dto.AgenceDto;
import com.immobilier.serviceImple.AgenceServiceImple;

@CrossOrigin
@RestController
public class AgenceController {

	@Autowired
	AgenceServiceImple agenceServiceImple;
	
	@PostMapping("/agence")
	public AgenceDto ajoutAgence(@RequestBody AgenceDto agenceDto) {
		return agenceServiceImple.saveAgence(agenceDto);
	}
	
	@PutMapping("/agence/{uuid}")
	public AgenceDto modifiertAgence(@RequestBody AgenceDto agenceDto, @PathVariable String uuid) {
		return agenceServiceImple.updateAgence(agenceDto,uuid);
	}
	
	@GetMapping("/agence/{uuid}")
	public AgenceDto rechercherAgence(@PathVariable String uuid) {
		return agenceServiceImple.getByuuidAgence(uuid);
	}
	
	@DeleteMapping("/agence/{uuid}")
	public void supprimerAgence(@PathVariable String uuid) {
		agenceServiceImple.deleteAgence(uuid);
	}
	
	@GetMapping("/agence")
	public List<AgenceDto> afficherAgence(){
		return agenceServiceImple.findAllAgence();
	}
	
}
