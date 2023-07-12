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

import com.immobilier.dto.ParcelleAppartementVideoDto;
import com.immobilier.dto.ParcelleAppartemntImageDto;
import com.immobilier.service.ParcelleAppartementVideoService;
import com.immobilier.service.ParcelleAppartemntImageService;

@RestController
@CrossOrigin
public class ParcelleAppartementVideoController {
	
	@Autowired
	ParcelleAppartementVideoService service;
	
	@PostMapping("/parcelleAppartementVideo")
	public ParcelleAppartementVideoDto addParcelleAppartementVideo(@RequestBody ParcelleAppartementVideoDto dto) {
		return this.service.add(dto);
	}
	
	@PutMapping("/parcelleAppartementVideo/update/{uuid}")
	public ParcelleAppartementVideoDto updateParcelleAppartementVideo(@RequestBody ParcelleAppartementVideoDto dto,
			@PathVariable String uuid) {
		return this.service.update(dto, uuid);
	}
	
	@GetMapping("/parcelleAppartementVideo")
	public List<ParcelleAppartementVideoDto> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("/parcelleAppartementVideo/byUuidParcelleAppartement/{uuid}")
	public List<ParcelleAppartementVideoDto> findAllByParcelleAppartemnt(@PathVariable String uuid){
		return this.service.findAllByParcelleAppartement(uuid);
	}
	
	@GetMapping("/parcelleAppartementVideo/byUuid/{uuid}")
	public ParcelleAppartementVideoDto getParcelleAppartementVideo(@PathVariable String uuid) {
		return this.service.getParcelleAppartementVideo(uuid);
	}
	
	@DeleteMapping("/parcelleAppartementVideo/delele/{uuid}")
	public void deleteParcelleAppartemntImage(String uuid) {
		this.service.deleteParcelleAppartementVideo(uuid);
	}

}
