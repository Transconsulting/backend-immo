package com.immobilier.service;

import java.util.List;
 
import com.immobilier.dto.QuartierDto;
 

public interface QuartierService {

	public QuartierDto addQuatier(QuartierDto quartierdto); 
	public QuartierDto updateQuatier(QuartierDto quartierdto,String uuid);
	public List<QuartierDto> findAllQuatier();
	public QuartierDto getByUuid(String uuid);
	void deleteQuatier(String uuid); 
	List<QuartierDto> findAllByCommuneUuid(String uuidCommune);
	
	public QuartierDto findByQuartierAndCommune(String quartier,String uuidCommune);
}
