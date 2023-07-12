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

import com.immobilier.dto.ClientDto;
import com.immobilier.service.ClientService;
  

@CrossOrigin
@RestController 
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@PostMapping("/client")
	public ClientDto add(@RequestBody ClientDto dto) {
		return service.add(dto);
	}
	
	@PutMapping("/client/{uuid}")
	public ClientDto update(@RequestBody ClientDto dto,@PathVariable String uuid) {
		return service.update(dto, uuid);
	}
	
	@GetMapping("/client")
	public List<ClientDto> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/client/total")
	public long getTotalClient(){
		return service.getTotalClient();
	}
	
	@GetMapping("/client/{uuid}")
	public ClientDto getById(@PathVariable String uuid) {
		return service.getByUuid(uuid);
	}
	
	@DeleteMapping("/client/{uuid}")
	public void delete(@PathVariable String uuid) {
		service.delete(uuid);
	}
	

}
