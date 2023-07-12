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

import com.immobilier.dto.MaterielDto; 
import com.immobilier.service.MaterielService;
  

@CrossOrigin
@RestController 
public class MaterielController {
	
	@Autowired
	private MaterielService service;
	
	@PostMapping("/materiel")
	public MaterielDto add(@RequestBody MaterielDto dto) {
		return service.add(dto);
	}
	
	@PutMapping("/materiel/{uuid}")
	public MaterielDto update(@RequestBody MaterielDto dto,@PathVariable String uuid) {
		return service.update(dto, uuid);
	}
	
	@GetMapping("/materiel")
	public List<MaterielDto> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/materiel/{uuid}")
	public MaterielDto getById(@PathVariable String uuid) {
		return service.getByUuid(uuid);
	}
	
	@DeleteMapping("/materiel/{uuid}")
	public void delete(@PathVariable String uuid) {
		service.delete(uuid);
	}
	

}
