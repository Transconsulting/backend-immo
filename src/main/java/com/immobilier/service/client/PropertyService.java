package com.immobilier.service.client;

import java.util.List;

import com.immobilier.dto.client.PropertyDto;

public interface PropertyService {
	
	public List<PropertyDto> listeProperty();
	public List<PropertyDto> listePropertyByAgent(String nomComplet);
	public List<PropertyDto> listePropertyByDommaineNom(String titre);
	public List<PropertyDto> listePropertyByDommaineUuid(String uuid);
}
