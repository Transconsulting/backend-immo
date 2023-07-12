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
 
import com.immobilier.dto.ContratDto;
import com.immobilier.dto.PaiementContratDto;
import com.immobilier.service.ContratService;
  

@CrossOrigin
@RestController 
public class ContratController {
	
	@Autowired
	private ContratService service;
	
	@PostMapping("/contrat")
	public ContratDto add(@RequestBody ContratDto dto) {
		return service.add(dto);
	}
	
	@PutMapping("/contrat/{uuid}")
	public ContratDto update(@RequestBody ContratDto dto,@PathVariable String uuid) {
		return service.update(dto, uuid);
	}
	
	@GetMapping("/contrat")
	public List<ContratDto> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/contrat/{uuid}")
	public ContratDto getById(@PathVariable String uuid) {
		return service.getByUuid(uuid);
	}
	
	@DeleteMapping("/contrat/{uuid}")
	public void delete(@PathVariable String uuid) {
		service.delete(uuid);
	}
	
	@GetMapping("/contrat/validerMontantAvance/{uuidContrat}")
	public ContratDto validerAvance(@RequestBody PaiementContratDto dto,@PathVariable String uuidContrat){
		return service.validerAvance(dto,uuidContrat);
	}
	
	@GetMapping("/contrat/listeContratByClient/{uuidClient}")
	List<ContratDto> findAllByClientUuid(@PathVariable String uuidClient){
		return service.findAllByClientUuid(uuidClient);
	}
	
	@PutMapping("/contrat/cloturer/{uuidContrat}")
	public ContratDto cloturer(@PathVariable String uuidContrat) {
		return service.cloturer(uuidContrat);
	}

}
