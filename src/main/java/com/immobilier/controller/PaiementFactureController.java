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
 
import com.immobilier.dto.PaiementFactureDto;
import com.immobilier.service.PaiementFactureService; 

@CrossOrigin
@RestController 
public class PaiementFactureController {
	
	@Autowired
	private PaiementFactureService service;
	
	@PostMapping("/paiementfacture")
	public PaiementFactureDto add(@RequestBody PaiementFactureDto dto) {
		return service.add(dto);
	}
	
	@PutMapping("/paiementfacture/{uuid}")
	public PaiementFactureDto update(@RequestBody PaiementFactureDto dto,@PathVariable String uuid) {
		return service.update(dto, uuid);
	}
	
	@GetMapping("/paiementfacture")
	public List<PaiementFactureDto> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/paiementfacture/{uuid}")
	public PaiementFactureDto getById(@PathVariable String uuid) {
		return service.getByUuid(uuid);
	}
	
	@DeleteMapping("/paiementfacture/{uuid}")
	public void delete(@PathVariable String uuid) {
		service.delete(uuid);
	}
	
	
	@GetMapping("/paiementfacture/detail/{uuidCommande}")
	public List<PaiementFactureDto> getPaiementByContrat(@PathVariable String uuidCommande){
		return service.getPaiementByCommande(uuidCommande);
	}
}
