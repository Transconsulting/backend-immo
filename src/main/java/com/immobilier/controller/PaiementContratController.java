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

import com.immobilier.dto.PaiementContratDto;
import com.immobilier.service.PaiementContratService;
  
@CrossOrigin
@RestController 
public class PaiementContratController {
	
	@Autowired
	private PaiementContratService service;
	
	@PostMapping("/paiement")
	public PaiementContratDto add(@RequestBody PaiementContratDto dto) {
		return service.add(dto);
	}
	
	@PutMapping("/paiement/{uuid}")
	public PaiementContratDto update(@RequestBody PaiementContratDto dto,@PathVariable String uuid) {
		return service.update(dto, uuid);
	}
	
	@GetMapping("/paiement")
	public List<PaiementContratDto> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/paiement/{uuid}")
	public PaiementContratDto getById(@PathVariable String uuid) {
		return service.getByUuid(uuid);
	}
	
	@DeleteMapping("/paiement/{uuid}")
	public void delete(@PathVariable String uuid) {
		service.delete(uuid);
	}
	
	
	@GetMapping("/paiement/detail/{uuidContrat}")
	public List<PaiementContratDto> getPaiementByContrat(@PathVariable String uuidContrat){
		return service.getPaiementByContrat(uuidContrat);
	}
}
