package com.immobilier.service;

import java.util.List;

import com.immobilier.dto.ModePaiementDto;
 
public interface ModePaiementService {

	public ModePaiementDto add(ModePaiementDto dto); 
	public ModePaiementDto update(ModePaiementDto dto,String uuid);
	public List<ModePaiementDto> findAll();
	public ModePaiementDto getByUuid(String uuid);
	void delete(String uuid); 
}
