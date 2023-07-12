package com.immobilier.controller.client;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immobilier.dto.client.PropertyDto; 
import com.immobilier.service.clientImp.PropertyServiceImp;

@CrossOrigin
@RestController
public class PropertyController {
	

	@Autowired
	PropertyServiceImp propertyServiceImp;
	
	@GetMapping("/listeProperty")
	public List<PropertyDto> listeProperty() { 
		return propertyServiceImp.listeProperty(); 
	}

	@GetMapping("/listeProperty/agentByNom/{nomComplet}")
	public List<PropertyDto> listePropertyByAgent(String nomComplet) {  
		return propertyServiceImp.listePropertyByAgent(nomComplet); 
	}

	@GetMapping("/listeProperty/dommaineByNom/{titre}")
	public List<PropertyDto> listePropertyByDommaineNom(String titre) {
		return propertyServiceImp.listePropertyByDommaineNom(titre);
	}
	
	@GetMapping("/listeProperty/dommaineByUuid/{uuid}")
	public List<PropertyDto> listePropertyByDommaineUuid(String uuid) {
		return propertyServiceImp.listePropertyByDommaineUuid(uuid);
	}

}
