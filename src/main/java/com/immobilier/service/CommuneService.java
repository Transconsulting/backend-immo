package com.immobilier.service;

import java.util.List;
 
import com.immobilier.dto.CommuneDto; 

public interface CommuneService {

	public CommuneDto addCommune(CommuneDto communedto); 
	public CommuneDto updateCommune(CommuneDto communedto, String uuid);
	public List<CommuneDto> findAllCommune();
	public CommuneDto getByUuid(String uuid);
	void deleteCommune(String uuid); 
	
	List<CommuneDto> findAllByVilleUuid(String uuidVille);
	public CommuneDto findByNomCommuneAndVilleUuid(String commune,String uuidVille);
}
