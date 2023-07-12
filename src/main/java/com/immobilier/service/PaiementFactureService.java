package com.immobilier.service;

import java.util.List;
  
import com.immobilier.dto.PaiementFactureDto;

public interface PaiementFactureService {

	public PaiementFactureDto add(PaiementFactureDto dto); 
	public PaiementFactureDto update(PaiementFactureDto dto,String uuid);
	public List<PaiementFactureDto> findAll();
	public PaiementFactureDto getByUuid(String uuid);
	public List<PaiementFactureDto> getPaiementByCommande(String uuidCommande);
	void delete(String uuid); 
}
