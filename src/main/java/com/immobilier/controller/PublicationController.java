package com.immobilier.controller;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.immobilier.dto.ContratDto;
import com.immobilier.dto.DomaineDto;
import com.immobilier.dto.ParcelleAppartemntDto;
import com.immobilier.enumeration.StatutDomaine;
import com.immobilier.service.ContratService;
import com.immobilier.service.ParcelleAppartemntService;
import com.immobilier.serviceImple.DomaineServiceImple; 

@CrossOrigin
@RestController
public class PublicationController {
	
	@Autowired
	DomaineServiceImple domaineServiceImple;
	@Autowired
	ParcelleAppartemntService arcelleAppartemntService;
	@Autowired
	private ContratService contratService;
	
	 
	@PutMapping("/publication/statutDommaine/{statut}/{uuidDomaine}")
	public DomaineDto statutDomaine(@PathVariable StatutDomaine statut,@PathVariable String uuidDomaine) {
		return domaineServiceImple.statutDomaine(statut, uuidDomaine);
	}
	
	@PutMapping("/publication/statutParcelleAppartement/{statut}/{uuidParcelleAppartement}")
	public ParcelleAppartemntDto statutAppartementParcelle(@PathVariable StatutDomaine statut,@PathVariable String uuidParcelleAppartement) {
		return arcelleAppartemntService.statutAppartementParcelle(statut, uuidParcelleAppartement);
	}
 
	
	@PutMapping("publication/contratCloturer/{uuidContrat}")
	public ContratDto cloturer(@PathVariable String uuidContrat) {
		return contratService.cloturer(uuidContrat);
	}
	
	
	
}
