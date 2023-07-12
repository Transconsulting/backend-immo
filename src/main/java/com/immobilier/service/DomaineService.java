package com.immobilier.service;

import java.util.List;

import com.immobilier.dto.DomaineDto;
import com.immobilier.enumeration.StatutDomaine;

public interface DomaineService {
	
	DomaineDto saveDomaine(DomaineDto domaineDto);
	DomaineDto updateDomaine(DomaineDto domaineDto, String uuid);
	DomaineDto getByuuid(String uuid);
	DomaineDto deleteDomaine(String uuid);
	List<DomaineDto> findAllDomaine();
	List<DomaineDto> findAllByProprietaireUuid(String uuidProprietaire);
	DomaineDto statutDomaine(StatutDomaine statut,String uuidDommaine);
	
	List<DomaineDto> findAllByStatutAndProprietaire(StatutDomaine statut,String uuidProprietaire);
	List<DomaineDto> findAllByStatut(StatutDomaine statut); 

}
