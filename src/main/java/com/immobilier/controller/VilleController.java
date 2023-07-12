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

import com.immobilier.dto.VilleDto;
import com.immobilier.serviceImple.VilleServiceImple;

@CrossOrigin
@RestController
public class VilleController {
	
	@Autowired
	VilleServiceImple villeServiceImple;
	
	@PostMapping("/ville")
	public VilleDto ajoutVille(@RequestBody VilleDto villeDto) {
		return villeServiceImple.addVille(villeDto);
	}
	
	@PutMapping("/ville/{uuid}")
	public VilleDto modifierVille(@RequestBody VilleDto villeDto,@PathVariable String uuid) {
		return villeServiceImple.updateVille(villeDto, uuid);
	}
	
	@DeleteMapping("/ville/{uuid}")
	public void supprimerVille(@PathVariable String uuid) {
		villeServiceImple.deleteVille(uuid);
	}
	
	@GetMapping("/ville/{uuid}")
	public VilleDto rechercherVille(@PathVariable String uuid) {	
		return villeServiceImple.getByUuid(uuid);
	}
	
	@GetMapping("/ville")
	public List<VilleDto> afficherVille() {
		return villeServiceImple.findAllVille();
	}
	
	@GetMapping("/ville/findByVille/{ville}")
	public VilleDto findByVille(@PathVariable String ville) {
		return villeServiceImple.findByVille(ville);
	}

}
