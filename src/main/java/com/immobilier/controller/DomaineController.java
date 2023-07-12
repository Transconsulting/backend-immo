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

import com.immobilier.dto.DomaineDto;
import com.immobilier.enumeration.StatutDomaine;
import com.immobilier.serviceImple.DomaineServiceImple;

@CrossOrigin
@RestController
public class DomaineController {
	
	@Autowired
	DomaineServiceImple domaineServiceImple;
	
	@PostMapping("/domaine")
	public DomaineDto ajouterDomaine(@RequestBody DomaineDto domaineDto) {
		return domaineServiceImple.saveDomaine(domaineDto);
	}

	@PutMapping("/domaine/{uuid}")
	public DomaineDto modifierDomaine(@RequestBody DomaineDto domaineDto,@PathVariable String uuid) {
		return domaineServiceImple.updateDomaine(domaineDto, uuid);
	}
	
	@DeleteMapping("/domaine/{uuid}")
	public void supprimerDomaine(@PathVariable String uuid) {
		domaineServiceImple.deleteDomaine(uuid);
	}
	
	@GetMapping("/domaine/{uuid}")
	public DomaineDto rechercherDomaine(@PathVariable String uuid) {
		return domaineServiceImple.getByuuid(uuid);
	}
	
	@GetMapping("/domaine")
	public List<DomaineDto> afficherDomaine(){	
		return domaineServiceImple.findAllDomaine();
	}
	
	@GetMapping("/domaine/listeByProprietaire/{uuidProprietaire}")
	public List<DomaineDto> findAllByProprietaireUuid(@PathVariable String uuidProprietaire){
		return domaineServiceImple.findAllByProprietaireUuid(uuidProprietaire);
	}
	
	@GetMapping("/domaine/listeByStatutAndProprietaire/{statut}/{uuidProprietaire}")
	public List<DomaineDto> findAllByStatutAndProprietaire(@PathVariable StatutDomaine statut,@PathVariable String uuidProprietaire){
		return domaineServiceImple.findAllByStatutAndProprietaire(statut, uuidProprietaire);
	}
	
	@GetMapping("/domaine/listeByStatut/{statut}")
	public List<DomaineDto> findAllByStatut(@PathVariable StatutDomaine statut){
		return domaineServiceImple.findAllByStatut(statut);
	}
	
}
