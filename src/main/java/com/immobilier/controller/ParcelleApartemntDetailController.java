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

import com.immobilier.dto.ParcelleApartemntDetailDto;
import com.immobilier.serviceImple.ParcelleApartemntDetailServiceImple;

@CrossOrigin
@RestController
public class ParcelleApartemntDetailController {
	
	@Autowired
	ParcelleApartemntDetailServiceImple parcelleApartemntDetailServiceImple;
	
	@PostMapping("/parcelleApartemntDetail")
	public ParcelleApartemntDetailDto ajoutParcelleApartemntDetail(@RequestBody ParcelleApartemntDetailDto parcelleApartemntDetailDto) {
		return parcelleApartemntDetailServiceImple.saveParcelleApartemntDetail(parcelleApartemntDetailDto);
	}
	
	@PutMapping("/parcelleApartemntDetail/{uuid}")
	public ParcelleApartemntDetailDto modifierParcelleApartemntDetail(@RequestBody ParcelleApartemntDetailDto parcelleApartemntDetailDto,@PathVariable String uuid) {
		return parcelleApartemntDetailServiceImple.updateParcelleApartemntDetail(parcelleApartemntDetailDto, uuid);
	}

	@DeleteMapping("/parcelleApartemntDetail/{uuid}")
	public void supprimerParcelleApartemntDetail(@PathVariable String uuid) {
		parcelleApartemntDetailServiceImple.deleteParcelleApartemntDetail(uuid);
	}
	
	@GetMapping("/parcelleApartemntDetail/{uuid}")
	public ParcelleApartemntDetailDto rechercherParcelleApartemntDetail(@PathVariable String uuid) {		
		return parcelleApartemntDetailServiceImple.getByuuid(uuid);
	}
	
	@GetMapping("/parcelleApartemntDetail")
	public List<ParcelleApartemntDetailDto> afficherParcelleApartemntDetail(){
		return parcelleApartemntDetailServiceImple.findAllParcelleApartemntDetail();
	}
	
	@GetMapping("/parcelleApartementDetail/{uuidParcelleAprtement}")
	public List<ParcelleApartemntDetailDto> afficheDetailParcelleApartement(@PathVariable String uuidParcelleAprtement){
		return parcelleApartemntDetailServiceImple.getParcelleApartemntDetail(uuidParcelleAprtement);
	}
}
