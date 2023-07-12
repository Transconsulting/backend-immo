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

import com.immobilier.dto.QuartierDto;
import com.immobilier.serviceImple.QuartierServiceImple;

@CrossOrigin
@RestController
public class QuartierController {
	
	@Autowired
	QuartierServiceImple quartierServiceImple;
	
	@PostMapping("/quartier")
	public QuartierDto ajoutQuartier(@RequestBody QuartierDto quartierDto) {
		return quartierServiceImple.addQuatier(quartierDto);
	}

	@PutMapping("/quartier/{uuid}")
	public QuartierDto modifierQuartier(@RequestBody QuartierDto quartierDto,@PathVariable String uuid) {
		return quartierServiceImple.updateQuatier(quartierDto, uuid);
	}
	
	@GetMapping("/quartier/{uuid}")
	public QuartierDto rechercherQuartier(@PathVariable String uuid) {
		return quartierServiceImple.getByUuid(uuid);
	}
	
	@DeleteMapping("/quartier/{uuid}")
	public void supprimerQuartier(@PathVariable String uuid) {
		quartierServiceImple.deleteQuatier(uuid);
	}
	
	@GetMapping("/quartier")
	public List<QuartierDto> afficherQuartier(){
		return quartierServiceImple.findAllQuatier();
	}
	
	@GetMapping("/quartier/listeByCommune/{uuidCommune}")
	public List<QuartierDto> findAllByCommuneUuid(@PathVariable String uuidCommune){
		return quartierServiceImple.findAllByCommuneUuid(uuidCommune);
	}
	
	@GetMapping("/quartier/findByQuartierAndUuidCommune/{quartier}/{uuidCommune}")
	public QuartierDto findAllByCommune(@PathVariable String quartier,@PathVariable String uuidCommune){
		return quartierServiceImple.findByQuartierAndCommune(quartier, uuidCommune);
	}
}
