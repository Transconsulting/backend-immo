package com.immobilier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.immobilier.dto.IntereseDto;
import com.immobilier.service.IntereseService; 

@RestController
@CrossOrigin
public class IntereseController {
	
	@Autowired
	private IntereseService intereseService;
	
	@PostMapping("/interese/save/{uuidParcelApp}")
	public IntereseDto add(@PathVariable String uuidParcelApp) {
		return intereseService.add(uuidParcelApp);
	}
	@DeleteMapping("/interese/delete/uuid")
	public void delete(@PathVariable String uuid) {
		intereseService.delete(uuid);
	}
	@GetMapping("/interese/totalByUuidParcel/{uuid}")
	public long totalByUuidPacelle(@PathVariable String uuid) {
		return this.intereseService.totalByUuidPacelle(uuid);
	}
	@GetMapping("/interese/listeIntereseByParcelApp/{uuidParcelApp}")
	public List<IntereseDto>   listeUserInterseByParcelApp(@PathVariable String uuidParcelApp) {
		return this.intereseService.listeUserInterseByParcelApp(uuidParcelApp);
	}
	
	@GetMapping("/interese/liste")
	public List<IntereseDto>   findAll() {
		return this.intereseService.findAll();
	}
}
