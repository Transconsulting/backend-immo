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
import com.immobilier.dto.AffectationDto;
import com.immobilier.serviceImple.AffectationServiceImple;

@CrossOrigin
@RestController
public class AffectationController {

	@Autowired
	AffectationServiceImple affectationServiceImple;
	
	@PostMapping("/affectation")
	public AffectationDto ajoutAffectation(@RequestBody AffectationDto affectationDto) {
		return affectationServiceImple.saveAffectation(affectationDto);
	}
	
	@PutMapping("/affectation/{uuid}")
	public AffectationDto modifierAffectation(@RequestBody AffectationDto affectationDto,
			@PathVariable String uuid) {
		return affectationServiceImple.updateAffectation(affectationDto, uuid);
	}
	
	@GetMapping("/affectation/{uuid}")
	public AffectationDto rechercherAffectation(@PathVariable String uuid) {
		return affectationServiceImple.getByuuidAffectation(uuid);
	}
	
	@DeleteMapping("/affectation/{uuid}")
	public void supprimerAffectation(@PathVariable String uuid) {
		affectationServiceImple.deleteAffectation(uuid);
	}
	
	@GetMapping("/affectation")
	public List<AffectationDto> afficherAffectation(){
		return affectationServiceImple.findAllAffectation();
	}
}
