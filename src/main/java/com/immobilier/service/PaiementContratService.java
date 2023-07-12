package com.immobilier.service;

import java.util.List;
 
import com.immobilier.dto.PaiementContratDto;

public interface PaiementContratService {

	public PaiementContratDto add(PaiementContratDto dto); 
	public PaiementContratDto update(PaiementContratDto dto,String uuid);
	public List<PaiementContratDto> findAll();
	public PaiementContratDto getByUuid(String uuid);
	public List<PaiementContratDto> getPaiementByContrat(String uuidContrat); 
	void delete(String uuid); 
}
