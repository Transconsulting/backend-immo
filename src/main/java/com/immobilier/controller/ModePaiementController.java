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

import com.immobilier.dto.ModePaiementDto;
import com.immobilier.service.ModePaiementService;
  

@CrossOrigin
@RestController 
public class ModePaiementController {
	
	@Autowired
	private ModePaiementService service;
	
	@PostMapping("/modepaiement")
	public ModePaiementDto add(@RequestBody ModePaiementDto dto) {
		return service.add(dto);
	}
	
	@PutMapping("/modepaiement/{uuid}")
	public ModePaiementDto update(@RequestBody ModePaiementDto dto,@PathVariable String uuid) {
		return service.update(dto, uuid);
	}
	
	@GetMapping("/modepaiement")
	public List<ModePaiementDto> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/modepaiement/{uuid}")
	public ModePaiementDto getById(@PathVariable String uuid) {
		return service.getByUuid(uuid);
	}
	
	@DeleteMapping("/modepaiement/{uuid}")
	public void delete(@PathVariable String uuid) {
		service.delete(uuid);
	}
	
}
