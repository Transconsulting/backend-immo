package com.immobilier.service;

import java.util.List;

import com.immobilier.dto.ContratDto;
import com.immobilier.dto.PaiementContratDto; 
 

public interface ContratService {

	public ContratDto add(ContratDto dto); 
	public ContratDto update(ContratDto dto,String uuid);
	public List<ContratDto> findAll();
	public ContratDto getByUuid(String uuid); 
	public ContratDto delete(String uuid);
	public List<ContratDto> findAllByClientUuid(String uuid);
	public ContratDto validerAvance(PaiementContratDto dto,String uuidContrat);
	public ContratDto cloturer(String uuidContrat);
}
