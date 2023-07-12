package com.immobilier.service;

import java.util.List;

import com.immobilier.dto.ParcelleAppartementVideoDto;
  

public interface ParcelleAppartementVideoService {
	
	ParcelleAppartementVideoDto	add(ParcelleAppartementVideoDto dto);
	ParcelleAppartementVideoDto	update(ParcelleAppartementVideoDto dto,String uuid);
	List<ParcelleAppartementVideoDto> findAll();
	List<ParcelleAppartementVideoDto> findAllByParcelleAppartement(String uuid);
	ParcelleAppartementVideoDto getParcelleAppartementVideo(String uuid);
	void deleteParcelleAppartementVideo(String uuid);
	
}
