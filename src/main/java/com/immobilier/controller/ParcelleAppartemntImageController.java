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

import com.immobilier.dto.ParcelleAppartemntImageDto;
import com.immobilier.service.ParcelleAppartemntImageService;

@RestController
@CrossOrigin
public class ParcelleAppartemntImageController {
	
	@Autowired
	ParcelleAppartemntImageService appartemntImageService;
	
	@PostMapping("/parcelleAppartemntImage")
	public ParcelleAppartemntImageDto addParcelleAppartemntImage(@RequestBody ParcelleAppartemntImageDto appartemntImageDto) {
		return this.appartemntImageService.addParcelleAppartemntImage(appartemntImageDto);
	}
	
	@PutMapping("/parcelleAppartemntImage/{uuid}")
	public ParcelleAppartemntImageDto updateParcelleAppartemntImage(@RequestBody ParcelleAppartemntImageDto parcelleAppartemenntAppartemntImageDto,
			@PathVariable String uuid) {
		return this.updateParcelleAppartemntImage(parcelleAppartemenntAppartemntImageDto, uuid);
	}
	
	@GetMapping("/parcelleAppartemntImage")
	public List<ParcelleAppartemntImageDto> findAll(){
		return this.appartemntImageService.findAll();
	}
	
	@GetMapping("/parcelleAppartemntImageByAppartementParcelle/{uuid}")
	public List<ParcelleAppartemntImageDto> findAllByParcelleAppartemnt(@PathVariable String uuid){
		return this.appartemntImageService.findAllByParcelleAppartemnt(uuid);
	}
	
	@GetMapping("/parcelleAppartemntImage/{uuid}")
	public ParcelleAppartemntImageDto getParcelleAppartemntImage(@PathVariable String uuid) {
		return this.appartemntImageService.getParcelleAppartemntImage(uuid);
	}
	
	@DeleteMapping("/parcelleAppartemntImage/{uuid}")
	public void deleteParcelleAppartemntImage(String uuid) {
		this.appartemntImageService.deleteParcelleAppartemntImage(uuid);
	}

}
