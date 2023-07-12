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

import com.immobilier.dto.CommuneDto;
import com.immobilier.serviceImple.CommuneServiceImple;

@CrossOrigin
@RestController
public class CommuneController {
	
	@Autowired
	CommuneServiceImple communeServiceImple;
	
	@PostMapping("/commune")
	public CommuneDto ajoutCommmune(@RequestBody CommuneDto communeDto) {
		return communeServiceImple.addCommune(communeDto);
	}
	
	@PutMapping("/commune/{uuid}")
	public CommuneDto modifierCommmune(@RequestBody CommuneDto communeDto,@PathVariable String uuid) {
		return communeServiceImple.updateCommune(communeDto, uuid);
	}

	@DeleteMapping("/commune/{uuid}")
	public void supprimerCommune(@PathVariable String uuid) {
		communeServiceImple.deleteCommune(uuid);
	}
	
	@GetMapping("/commune/{uuid}")
	public CommuneDto rechercherCommune(@PathVariable String uuid) {
		return communeServiceImple.getByUuid(uuid);
	}
	
	@GetMapping("commune")
	public List<CommuneDto> afficherCommune(){
		return communeServiceImple.findAllCommune();
	}
	
	@GetMapping("commune/listeByVille/{uuidVille}")
	public List<CommuneDto> findAllByVilleUuid(@PathVariable String uuidVille){
		return communeServiceImple.findAllByVilleUuid(uuidVille);
	}
	
	@GetMapping("commune/findByCommuneAndBVille/{commune}/{uuidVille}")
	public CommuneDto findByCommuneAndVille(@PathVariable String commune,@PathVariable String uuidVille){
		return communeServiceImple.findByNomCommuneAndVilleUuid(commune, uuidVille);
	}
}
