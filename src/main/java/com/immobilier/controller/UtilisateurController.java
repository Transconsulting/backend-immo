package com.immobilier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController;

import com.immobilier.dto.UtilisateurDto;
import com.immobilier.service.UtilisateurService;
  



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
//@CrossOrigin
public class UtilisateurController {

	@Autowired
	UtilisateurService  utilisateurService;
	
	@PostMapping("/utilisateur")
    public UtilisateurDto newUtilisateurDto(@RequestBody UtilisateurDto newUtilisateurdto) {
        //logger.info("\n\ninserting new DistinctionRef {}\n\n", newDistinctionRef.getLibelle());
        return utilisateurService.save(newUtilisateurdto);
    }
	
	@PutMapping("/utilisateur/{uuid}")
    public UtilisateurDto updateUtilisateurDto(@RequestBody UtilisateurDto utilisateurDto, @PathVariable String uuid) {
    	return utilisateurService.updateUtilisateur(utilisateurDto, uuid);       
    }
	
	//@DeleteMapping("/utilisateur/{uuid}")
	public  void deleteUtilisateur(@PathVariable String uuid) {
		utilisateurService.deleteUtilisateur(uuid);
	}
	
	//@GetMapping("/utilisateur/{uuid}")
	public UtilisateurDto findById(@PathVariable String uuid){
		return utilisateurService.getUtilisateur(uuid);
	}
	
	@GetMapping("/utilisateurEmail/{email}")
	public UtilisateurDto findByEmail(@PathVariable String email){
		return utilisateurService.getUtilisateurByEmail(email);
	}
	@GetMapping("/utilisateur/onligne")
	public List<UtilisateurDto> findByUserOnLigne(){
		return utilisateurService.getByUserOnLigne();
	}
	@GetMapping("/utilisateur")
	public List<UtilisateurDto> findAll(){
		return utilisateurService.findAll();
	}
	@GetMapping("/deconnecter")
	public void deconnecterUtilisateur() {
		utilisateurService.deconnecterUtilisateur();
	}

}
