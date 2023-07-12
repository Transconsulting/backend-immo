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

import com.immobilier.dto.ContratDetailDto; 
import com.immobilier.service.ContratDetailService; 

@CrossOrigin
@RestController 
public class ContratDetailController {

	@Autowired
	private ContratDetailService service;
	
	@PostMapping("/contratdetail/save")
	public ContratDetailDto add(@RequestBody ContratDetailDto dto) {
		return service.add(dto);
	}
	
	@PutMapping("/contratdetail/update/{uuid}")
	public ContratDetailDto update(@RequestBody ContratDetailDto dto,@PathVariable String uuid) {
		return service.update(dto, uuid);
	}
	
	@GetMapping("/contratdetail/getByUuid/{uuid}")
	public ContratDetailDto getByUuid(@PathVariable String uuid) {
		return service.getByUuid(uuid);
	} 
	
	@GetMapping("/contratdetail/{uuidContrat}")
	public List<ContratDetailDto> getDetailContrat(@PathVariable String uuidContrat){
		return service.getDetailContrat(uuidContrat);
	}	
		
	@DeleteMapping("/contratdetail/delete/{uuid}")
	public ContratDetailDto delete(@PathVariable String uuid) {
		return service.delete(uuid);
	}
}
