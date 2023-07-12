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

import com.immobilier.dto.CommandeClientDto; 
import com.immobilier.dto.DetailCommandeClientDto;
import com.immobilier.service.CommandeClientService; 
  

@CrossOrigin
@RestController 
public class CommandeClientController {
	
	@Autowired
	private CommandeClientService service;
	
	@PostMapping("/commandeClient")
	public CommandeClientDto add(@RequestBody CommandeClientDto dto) { 
		return service.add(dto);
	}
	
	@PutMapping("/commandeClient/{uuid}")
	public CommandeClientDto update(@RequestBody CommandeClientDto dto,@PathVariable String uuid) {
		return service.update(dto, uuid);
	}
	
	@GetMapping("/commandeClient")
	public List<CommandeClientDto> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/commandeClient/{uuid}")
	public CommandeClientDto getById(@PathVariable String uuid) {
		return service.findByUuid(uuid);
	}
	
	@GetMapping("/commandeClient/facture/{numero}")
	public CommandeClientDto getByNumFacture(@PathVariable String numero) {
		return service.findByNumFacture(numero);
	}
	
	@DeleteMapping("/commandeClient/{uuid}")
	public void delete(@PathVariable String uuid) {
		service.delete(uuid);
	}
	
	@GetMapping("/commandeClient/detail/{uuidCmd}")
	public List<DetailCommandeClientDto> getDetailContrat(@PathVariable String uuidCmd){
		return service.getDetailCommandeClient(uuidCmd);
	}
	
}
