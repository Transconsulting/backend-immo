package com.immobilier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.immobilier.service.EnumerationService;

@CrossOrigin
@RestController 
public class EnumerationController {

	@Autowired
	EnumerationService enumService;
	
	@GetMapping("/allListeByTypeAnnonce")
	public List<String> listeAnnonceDomaine(){
		return enumService.listeTypeAnnonce();
	}
	
	@GetMapping("/allListeByStatutDomaine")
	public List<String> listeStatutDomaine(){
		return enumService.listeStatutDomaine();
	}
	@GetMapping("/allListeTypeAgent")
	public List<String> listeTypeAgent(){
		return enumService.listeTypeAgent();
	}
	@GetMapping("/allListeByTypeDomaine")
	public List<String> listeTypeDomaine(){
		return enumService.listeTypeDomaine();
	}
	@GetMapping("/allListeByTypeContrat")
	public List<String> listeTypeContrat(){
		return enumService.listeTypeContrat();
	}
	
	@GetMapping("/allListeByTypeDeTraveau")
	public List<String> listeTypeDeTraveaux(){
		return enumService.listeTypeDeTraveaux();
	}
}
