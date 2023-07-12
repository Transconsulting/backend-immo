package com.immobilier.service;

import java.util.List;

import com.immobilier.dto.ProprietaireDto;

public interface ProprietaireService {
	
	ProprietaireDto saveProprietaire(ProprietaireDto proprietaireDto);
	ProprietaireDto updateProprietaire(ProprietaireDto proprietaireDto,String uuid);
	ProprietaireDto getByuuid(String uuid);
	ProprietaireDto deleteProprietaire(String uuid);
	List<ProprietaireDto> findAllProprietaire();
	long getTotalProprietaire();

}
