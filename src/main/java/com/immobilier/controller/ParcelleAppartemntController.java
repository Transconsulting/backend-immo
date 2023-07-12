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
import com.immobilier.dto.ParcelleAppartemntDto;
import com.immobilier.enumeration.StatutDomaine;
import com.immobilier.serviceImple.ParcelleAppartemntServiceImple;

@CrossOrigin
@RestController
public class ParcelleAppartemntController {

	@Autowired
	ParcelleAppartemntServiceImple parcelleAppartemntServiceImple;
	
	@PostMapping("/parcelleAppartemnt")
	public ParcelleAppartemntDto ajoutParcelleAppartemnt(@RequestBody ParcelleAppartemntDto parcelleAppartemntDto) {
		return parcelleAppartemntServiceImple.saveParcelleAppartemnt(parcelleAppartemntDto);
	}
	
	@PutMapping("/parcelleAppartemnt/{uuid}")
	public ParcelleAppartemntDto modifierParcelleAppartemnt(
			@RequestBody ParcelleAppartemntDto parcelleAppartemntDto,@PathVariable String uuid) {
		return parcelleAppartemntServiceImple.updateParcelleAppartemnt(parcelleAppartemntDto, uuid);
	}
	
	@DeleteMapping("/parcelleAppartemnt/{uuid}")
	public void supprimerParcelleAppartemnt(@PathVariable String uuid) {
		parcelleAppartemntServiceImple.deleteParcelleAppartemnt(uuid);
	}
	
	@GetMapping("/parcelleAppartemnt/{uuid}")
	public ParcelleAppartemntDto rechercherParcelleAppartemnt(@PathVariable String uuid) {
		return parcelleAppartemntServiceImple.getByuuid(uuid);
	}
	
	@GetMapping("/parcelleAppartemnt")
	public List<ParcelleAppartemntDto> afficherParcelleAppartemnt(){
		return parcelleAppartemntServiceImple.findAllParcelleAppartemnt();
	}
	
	@GetMapping("/parcelleAppartemnt/totalByStatut/{statut}")
	public Integer getTotalByStatut(@PathVariable StatutDomaine statut) {
		return parcelleAppartemntServiceImple.getTotalByStatut(statut);
	}
	
	@GetMapping("/parcelleAppartemnt/listeByStatut/{statut}") 
	public List<ParcelleAppartemntDto> findAllByStatut(@PathVariable StatutDomaine statut){
		return parcelleAppartemntServiceImple.findAllByStatut(statut);
	}
	
	@GetMapping("/parcelleAppartemnt/listeByStatutAndDomaine/{statut}/{uuidDommaine}")
	public List<ParcelleAppartemntDto> findAllByStatutAndDomaine(@PathVariable StatutDomaine statut,@PathVariable String uuidDommaine){
		return parcelleAppartemntServiceImple.findAllByStatutAndDomaine(statut, uuidDommaine);
	}
	
	@PutMapping("/parcelleAppartemnt/modificationStatutByUuidParcelle/{statut}/{uuidParcelleApp}") 
	public ParcelleAppartemntDto statutAppartementParcelle(@PathVariable StatutDomaine statut,@PathVariable String uuidParcelleApp){
		return parcelleAppartemntServiceImple.statutAppartementParcelle(statut,uuidParcelleApp);
	}
	
}
